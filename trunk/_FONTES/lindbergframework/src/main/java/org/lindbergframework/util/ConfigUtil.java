package org.lindbergframework.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlException;
import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.core.context.ConfigurationInitializer;
import org.lindbergframework.exception.BeanException;
import org.lindbergframework.exception.LindbergException;
import org.lindbergframework.exception.LoadXmlPropertyException;
import org.lindbergframework.exception.NoSuchMethodOrPropertyException;
import org.lindbergframework.schema.LindbergConfigurationDocument;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration;





/**
 * 
 * @author Victor Lindberg
 *
 */
public class ConfigUtil {
	
	public static <E> E getValueObject(String valueStr,Object... constructorArgs){
		if (valueStr == null)
			return null;

		if (valueStr.startsWith("#")){//if is instance, static property or method
		   valueStr = valueStr.substring(1);
		   
		   try{
		      Class clazz = Class.forName(valueStr);
		      return BeanUtil.createInstance(clazz, constructorArgs);
		   }catch(ClassNotFoundException exception){
			  //value does not correspond to a class
		   }catch(Exception ex){
			   throw new LoadXmlPropertyException("Error loading xml property : "+valueStr,ex);
		   }
		   
		   //value can be a constant 
		   int lastDotIndex = valueStr.lastIndexOf(".");
		   
		   String clazzName = valueStr.substring(0, lastDotIndex);
		   String propertyOrMethodName = valueStr.substring(lastDotIndex + 1);
		   
		   return (E) getValueObjectFromStaticPropertyOrStaticMethod(clazzName, propertyOrMethodName);
		}
		
		return (E) valueStr;
	}
	
	public static Object getValueObjectFromStaticPropertyOrStaticMethod(String clazzName, String propertyOrMethodName){
		try {
			Class clazz = Class.forName(clazzName);
			
			Field field = ReflectionUtil.getField(clazz, propertyOrMethodName,true);
			if (field != null && Modifier.isStatic(field.getModifiers()))
				return field.get(null);
			
			Method method = ReflectionUtil.getGetterMethod(clazz, propertyOrMethodName, true);
			if(method != null && Modifier.isStatic(method.getModifiers()))
			   return method.invoke(null);
			
			throw new NoSuchMethodOrPropertyException(clazzName,propertyOrMethodName);
		} catch (Exception ex) {
			throw new LindbergException(ex);
		}
	}
	
	public static Object getObjectIfPossible(String valueStr,
			Object... constructorArgs) {
		try {
			Class clazz = Class.forName(valueStr);
			return BeanUtil.createInstance(clazz, constructorArgs);
		} catch (ClassNotFoundException ex) {
			return valueStr;
		} catch (Exception ex) {
			throw new BeanException("Error instantiating : " + valueStr, ex);
		}
	}
	
	public static String[] stringToArray(String str){
		str = StringUtils.deleteWhitespace(str);
		String[] array = str.split(";");
		
		return array;
	}
	
	public static List<String> stringToList(String str){
		String[] strings = stringToArray(str);
		
		return Arrays.asList(strings);
	}

	public static void initializeConfig(ConfigurationInitializer initializer,Object fileConfig) throws IOException, XmlException {
        if (fileConfig instanceof File)
            initializer.initialize((File)fileConfig);
        else 
            if (fileConfig instanceof URL)
                initializer.initialize((URL)fileConfig);
            else 
               if (fileConfig instanceof InputStream) {
                  InputStream inputStreamConfig = (InputStream) fileConfig;
                  initializer.initialize((InputStream)fileConfig);
               }
               else
                  throw new IllegalStateException("invalid configuration file : "+fileConfig);
    }
	
	
}
