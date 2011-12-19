package org.lindbergframework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.lang.StringUtils;
import org.lindbergframework.exception.BeanException;
import org.lindbergframework.exception.FieldValueInaccessibleException;
import org.springframework.util.ReflectionUtils;

/**
 * Classe utilitária para operações de reflexão 
 * 
 * @author Victor Lindberg
 *
 */
public class ReflectionUtil {
	
	/**
	 * retorna o valor do campo. Se o campo for public retorna o valor de forma direta <br.
	 * caso não o seja tenta invocar o método get do campo.
	 * 
	 */
	public static Object getFieldValue(Field field, Object bean) throws BeanException{
		try{
		   if (field.getModifiers() == Modifier.PUBLIC)
			  return field.get(bean);
           
		   return getGetterMethod(bean.getClass(), field.getName(), true).invoke(bean);
		}catch(Exception ex){
			throw new BeanException("Error accessing "+field.getName()+" in "+bean.getClass(),ex);
		}
	}
	
	public static void setFieldValue(Field field, Object bean,Object value, boolean setAsAccessible) throws FieldValueInaccessibleException{
		Method setterMethod = getSetterMethod(bean.getClass(), field.getName(), value.getClass(), true);
		
		if (setterMethod != null){
		   try {
		      setterMethod.invoke(bean, value);
		   } catch (Exception e) {
		      throw new FieldValueInaccessibleException("Error invoking setter method for "+field.getName()+" in "+bean.getClass(),e);
		   }
		}
		else{	
		   if (setAsAccessible)
		      field.setAccessible(true);
		
		   try {
			  field.set(bean, value);
		   } catch (IllegalArgumentException ex) {
			  throw new FieldValueInaccessibleException(ex);
		   } catch (IllegalAccessException ex) {
			  throw new FieldValueInaccessibleException(ex);
		   }
	   }
	}
	
	/**
	 * Retorna o nome do método get do campo passado como argumento<br><br>
	 * 
	 * Se o campo for por exemplo name então a String retornada será getName.
	 * 
	 * Obs: 
	 */
	public static String getGetterMethodName(Field field){
		return getGetterMethodName(field.getName());
	}
	
	public static String getGetterMethodName(String fieldName){
		return getMethod("get", fieldName);
	}
	
	public static String getSetterMethodName(String fieldName){
		return getMethod("set", fieldName);
	}
	
	private static String getMethod(String prefix,String fieldName){
		if (StringUtils.startsWith(fieldName, prefix))
			return fieldName;
		
		String first = fieldName.substring(0,1);
		return prefix+fieldName.replaceFirst(first, first.toUpperCase());
	}
	
	public static Method getGetterMethod(Object bean,String methodOrPropertyName,boolean findInSuperClasses){
	   return getGetterMethod(bean.getClass(), methodOrPropertyName, findInSuperClasses);
	}
	
	public static Method getGetterMethod(Class clazz,String methodOrPropertyName,boolean findInSuperClasses){
		methodOrPropertyName = getGetterMethodName(methodOrPropertyName);
		
		try {
			return clazz.getDeclaredMethod(methodOrPropertyName);
		} catch (Exception ex) {
			if (findInSuperClasses && clazz != Object.class)
				return getGetterMethod(clazz.getSuperclass(), methodOrPropertyName, findInSuperClasses);
		} 
		
		return null;
	}
	
	/**
     * Retorna o valor via reflexão de uma propriedade de um objeto.
     * 
     * Este método dá prioridade a chamada de métodos get caso não tenha um método definido
     * para a propriedade então a propriedade é setada como acessible = true e acessada diretamente.
     * 
     * Este método trabalha com multinível de modo que é recuperado qualquer valor de qualquer propriedade
     * mesmo que essa propriedade esteja dentro de um objeto dentro de outro objeto, que es´ta dentro de outro objeto
     * e por ai vai tendo como base o objeto passado como parametro.<br><br> 
     * 
     * <b>Exemplo de Uso</b>
     * Considere o objeto abaixo
     * 
     *   Pessoa pessoa = new Pessoa[nome = 'joao',endereco[rua = 'ipê roxo', bairro = 'asa norte']]
     *   
     *   Exemplos de chamada e resultado:
     *    1 - getValorViaReflexao("nome",pessoa) : Resultado = 'joão'
     *    2 - getValorViaReflexao("endereco.bairro",pessoa) : Resultado = 'asa norte' <br><br>
     *    
     *  <b>Obs: Verifique que o exemplo 2 acessa uma propriedade dentro de um objeto que é propriedade do objeto passado como parâmetro<br>
     *          Isso pode ser feito sem limite de nível. Levando em consideração padrão java bean de propriedades qualquer propriedade <br>
     *          acessível a partir do objeto passado como parâmetro pode ser acessado <br>
     *          seguindo o padrão "propriedade1.propriedade2DentroDaPropriedade1.propriedade3DentroDaPropriedade2.etc...<br>"
     *          Da mesma forma passando apenas a propriedade raiz do objeto como no exemplo 1, o método automaticamente identifica isso <br>
     *          e tenta chamar o método get, caso este não exista, tenta acessar a propriedade diretamente</b>
     *    
     * 
     * @param property String no padrão java bean da propriedade ao qual se deseja o valor no objeto
     * passado como argumento para o parametro 'objeto' deste método
     * @param obj objeto onde a propriedade será buscada e retornada
     * @return o valor retornado pelo método get da propriedade ou o próprio valor direto da propriedade caso um método get para a mesma não tenha sido definido.
     * 
     * @author Victor Lindberg
     */
    public static Object getValueByReflection(String property,Object obj){
        
        String[] propertyTokens = property.split("\\.");
        
        Field field = null;
        Method getterMethod = null;
        String rootProperty = property;
        boolean isMultLevelProperty = property.contains("."); 
        if (! isMultLevelProperty){
            getterMethod = getGetterMethod(obj.getClass(), property, true);
            field = getField(obj.getClass(),property,true);
        }
        else{
            rootProperty =  propertyTokens[0];
            property = StringUtils.removeStart(property, rootProperty+".");
            getterMethod = getGetterMethod(obj.getClass(), rootProperty, true);
            field = getField(obj.getClass(),rootProperty,true);
        }
        
        if (getterMethod == null && field == null)
            throw new RuntimeException("Property or getter Method not found");
        
        if (getterMethod != null){
            try{
               Object result = getterMethod.invoke(obj); 
               if (isMultLevelProperty)
                  return getValueByReflection(property, result);
               else
                  return result;
            }catch(Exception ex){
               throw new RuntimeException("Error invoking getter method "+getterMethod.getName()+" in "+obj.getClass(), ex); 
            }
        }
        
        field.setAccessible(true);
        try {
           Object result = field.get(obj);
           if (isMultLevelProperty)
              return getValueByReflection(property,result);
           else
              return result;
        }catch (Exception ex) {
           throw new RuntimeException("Error accessing "+field.getName()+" in "+obj.getClass(),ex);
        } 
        
    }
	
	public static Method getSetterMethod(Object bean,String methodOrPropertyName,Class paramClassSet,boolean findInSuperClasses){
		return getSetterMethod(bean.getClass(), methodOrPropertyName, paramClassSet,findInSuperClasses);
	}
	public static Method getSetterMethod(Class clazz,String methodOrPropertyName,Class paramClassSet,boolean findInSuperClasses){
		methodOrPropertyName = getSetterMethodName(methodOrPropertyName);
		
		try {
			return clazz.getDeclaredMethod(methodOrPropertyName,paramClassSet);
		} catch (Exception ex) {
			if (findInSuperClasses && clazz != Object.class)
				return getSetterMethod(clazz.getSuperclass(), methodOrPropertyName, paramClassSet, findInSuperClasses);
		} 
		
		return null;
	}
	
	public static void setValueByReflection(String property, Object obj,
        Object value) {
        setValueByReflection(property, obj, value, value.getClass());
    }

    public static void setValueByReflection(String property, Object obj,
        Object value, Class setParamClass) {

        String[] propriedadeTokens = property.split("\\.");

        boolean isMultLevelProperty = property.contains(".");
        if (!isMultLevelProperty) {
            Method setterMethod = getSetterMethod(obj.getClass(),
                property, true, setParamClass);
            try {
                setterMethod.invoke(obj, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            int lastIndexProperty = StringUtils.lastIndexOf(property,
                ".");
            String propriedadeSet = propriedadeTokens[propriedadeTokens.length - 1];
            property = StringUtils.substring(property, 0,
                lastIndexProperty);
            obj = getValueByReflection(property, obj);
            setValueByReflection(propriedadeSet, obj, value, setParamClass);
        }
    }
    
    public static Method getSetterMethod(Class clazz,
        String methodOrPropertyName, boolean findInSuperClasses,
        Class... classParams) {
        if (methodOrPropertyName == null)
            throw new IllegalStateException("methodOrPropertyName is null");

        if (!methodOrPropertyName.startsWith("set"))
            methodOrPropertyName = getSetMethodName(methodOrPropertyName);

        try {
            return clazz.getDeclaredMethod(methodOrPropertyName, classParams);
        } catch (Exception ex) {
            if (findInSuperClasses && clazz != Object.class)
                return getSetterMethod(clazz.getSuperclass(),
                    methodOrPropertyName, findInSuperClasses, classParams);
        }

        return null;
    }
    
    public static String getSetMethodName(String campo) {
        String primeiraLetra = campo.substring(0, 1);
        return "set"
            + campo.replaceFirst(primeiraLetra, primeiraLetra.toUpperCase());
    }
	
	/**
	 * Retorna o campo de <code>clazz</code> cujo o nome é passado como argumento retornando <br>
	 * null caso este não seja encontrado na classe
	 * 
	 *  
	 * @param clazz
	 * @param fieldName
	 * @return campo com o nome especificado na classe ou null caso este não seja encontrado na classe
	 */
	public static Field getField(Class clazz, String fieldName, boolean findInSuperClasses) {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			if (findInSuperClasses && clazz != Object.class){
			      return getField(clazz.getSuperclass(), fieldName, findInSuperClasses);
			}
		}
		return null;
	}
	
	/**
	 * Retorna o campo de <code>clazz</code> cujo o nome é passado como argumento retornando <br>
	 * null caso este não seja encontrado na classe do bean especificado
	 * 
	 *  
	 * @param bean
	 * @param fieldName
	 * @return campo com o nome especificado na classe ou null caso este não seja encontrado na classe do bean especificado
	 */
	public static Field getField(Object bean, String fieldName, boolean findInSuperClasses) {
			return getField(bean.getClass(), fieldName, findInSuperClasses);
	}
	
	public static void makeAttributesAccessible(Field[] fields) {
		for (Field field : fields)
			ReflectionUtils.makeAccessible(field);
	}
	
}
