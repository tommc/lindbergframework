package org.lindbergframework.validation.executors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.lindbergframework.exception.FieldValueInaccessibleValidation;
import org.lindbergframework.exception.NoSuchBeanValidationException;
import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IExecutorValidation;
import org.lindbergframework.validation.IValidation;
import org.lindbergframework.validation.ValidationItem;
import org.lindbergframework.validation.annotation.Valid;
import org.lindbergframework.validation.annotation.Validations;
import org.lindbergframework.validation.annotation.engine.IExecutorValidationAnnotationEngine;
import org.lindbergframework.validation.factory.ValidationFactory;
import org.lindbergframework.validation.settings.MsgType;
import org.lindbergframework.validation.settings.ValidationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * Engine padrão de execução de validações de beans que utilizam <br>
 * as annotations Valid e Validations
 * 
 * 
 * @author Victor Lindberg
 *
 */
@Component("executorValidationAnnotationEngineImpl")
@Scope("prototype")
public class ExecutorValidationAnnotationEngineImpl 
               implements IExecutorValidationAnnotationEngine{
	
	@Autowired
	private IExecutorValidation executorValidation;
	
	public ExecutorValidationAnnotationEngineImpl(){
		//
	}

	public void addBeans(Object... objs) {
	   for (Object newBean : objs)
		   addNewBean(newBean);
	}

	public void execute(Object... beansToValidate) throws ValidationException,
			ValidationClassCastException {
		addBeans(beansToValidate);
		execute();
	}

	public void execute(ValidationMode mode, Object... beansToValidate)
			throws ValidationException, ValidationClassCastException {
	   addBeans(beansToValidate);
	   execute(mode);
	}

	public void clearValidations() {
		executorValidation.clearValidations();
	}

	public void execute() throws ValidationException,
			ValidationClassCastException {
		executorValidation.execute();
	}

	public void execute(ValidationMode mode) throws ValidationException,
			ValidationClassCastException {
	   executorValidation.execute(mode);
	}

	public void execute(String separatorMessages) throws ValidationException,
			ValidationClassCastException {
       executorValidation.execute(separatorMessages);		
	}

	public void reset() {
	   executorValidation.reset();
	}
	
	public <E> List<IValidation<E>> getValidations() {
		return executorValidation.getValidations();
	}

	/**
	 * adiciona as validações definidas via annotations ao conjunto <br>
	 * de validações para serem processadas
	 */
	@SuppressWarnings("unchecked")
	private void addNewBean(Object newBean){
       Field[] fields = newBean.getClass().getDeclaredFields();
		
	   for (Field field : fields){
		  List<Valid> annots = getAnnotations(field);
           			
		  try{
		     for (Valid val : annots){
			    IValidation newValid = getValidation(val);
				     
				Object valorCampo = getFieldValue(field, newBean);
				     
				MsgType msgType = val.msgType();
				     
				if (val.msg().equals(""))
				   msgType = MsgType.NO_USING_CUSTOM;
				     
			 	executorValidation.addValidationForSeveralItems(newValid, new ValidationItem(val.separator(),valorCampo,msgType,val.msg()));
			 }
		  }catch(ValidationException ex){
		     throw ex;
		  }
		  catch(Exception ex){
		     throw new ValidationException("Ocorreu um erro adicionando o bean de validação. Certifique-se que o bean referido está acessível e pode ser instanciado");
		  }
	   } 
	}
	
	/**
	 * retorna o valor do campo. Se o campo for public retorna o valor de forma direta <br.
	 * caso não o seja tenta invocar o método get do campo.
	 * 
	 * @throws FieldValueInaccessibleValidation caso o campo não esteja acessível
	 */
	private Object getFieldValue(Field field, Object newBean) throws FieldValueInaccessibleValidation{
		try{
		   if (field.getModifiers() == Modifier.PUBLIC)
			  return field.get(newBean);
		
		   return newBean.getClass().getMethod(getGetMethodName(field)).invoke(newBean);
		}catch(Exception exception){
			throw new FieldValueInaccessibleValidation("O campo para validação não está acessível e não tem nenhum método get para acessá-lo");
		}
	}

	/**
	 * Retorna uma lista com as annotations Valid definidas para o campo <br>
	 * estejam elas diretamente anotadas no campo ou através da annotation Validations
	 */
	private List<Valid> getAnnotations(Field field){
		List<Valid> annots = new Vector<Valid>(); 
		
		for (Annotation annot : field.getDeclaredAnnotations())
			if (Valid.class.isInstance(annot))
				annots.add((Valid) annot);
        
		Validations validations = field.getAnnotation(Validations.class);
		if (validations != null)
			annots.addAll(Arrays.asList(validations.value()));
		
		return annots;
	}
	
	/**
	 * Retorna a implementação de {@link IValidation} definida pela annotation Valid
	 */
	@SuppressWarnings("unchecked")
	private IValidation getValidation(Valid valid) {
		Object beanValid = null;
		try {
			beanValid = ValidationFactory
					       .getValidationBeanReturningNullIfNoSuchBean(valid.value());

			if (beanValid == null) {
				Class beanClass = Class.forName(valid.value());
				beanValid = beanClass.newInstance();
			} 
		} catch (Exception ex) {
			throw new NoSuchBeanValidationException();
		}

		if (beanValid != null && beanValid instanceof IValidation)
			return (IValidation) beanValid;

		throw new ValidationException("Validation não corresponde a um bean de validação");
	}

	/**
	 * Retorna o nome do método get do campo passado como argumento<br><br>
	 * 
	 * Se o campo for por exemplo name então a String retornada será getName
	 */
	private String getGetMethodName(Field field){
		String nome = field.getName();
		String primeira = nome.substring(0,1);
		return "get"+nome.replaceFirst(primeira, primeira.toUpperCase());
	}
	
}