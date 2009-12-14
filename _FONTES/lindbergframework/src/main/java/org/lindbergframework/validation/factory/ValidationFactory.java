package org.lindbergframework.validation.factory;

import org.lindbergframework.exception.NoSuchBeanValidationException;
import org.lindbergframework.spring.LindbergSpringFactory;
import org.lindbergframework.validation.AbstractComparableValidation;
import org.lindbergframework.validation.AbstractMaxLengthRequiredValidation;
import org.lindbergframework.validation.IComparableValidation;
import org.lindbergframework.validation.IDateValidation;
import org.lindbergframework.validation.IDocumentValidation;
import org.lindbergframework.validation.IExecutorValidation;
import org.lindbergframework.validation.IHasBeNullValidation;
import org.lindbergframework.validation.IListValidation;
import org.lindbergframework.validation.INotNullValidation;
import org.lindbergframework.validation.IRequiredFieldValidation;
import org.lindbergframework.validation.IValidation;
import org.lindbergframework.validation.Types;
import org.lindbergframework.validation.AbstractComparableValidation.FatorComparacao;
import org.lindbergframework.validation.annotation.engine.IExecutorValidationAnnotationEngine;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;


/**
 * Fábrica de validações
 * 
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationFactory implements Types{
	 
	private static LindbergSpringFactory springFactory = LindbergSpringFactory.getInstance();
	
	public static final String EXECUTOR_VALIDATION_MULT_THREAD_BEAN = "executorValidationMultThread";
	public static final String EXECUTOR_VALIDATION_BEAN = "executorValidation";
	public static final String EXECUTOR_VALIDATION_ANNOTATION_ENGINE_BEAN = "executorValidationAnnotationEngineImpl";
	
	/**
	 * Cria uma instancia de {@link IRequiredFieldValidation}
	 */
	public static IRequiredFieldValidation createRequiredFieldValidation() {
		return springFactory.getBean(
				REQUIRED_FIELD_VALIDATION_BEAN);
	}
	/**
	 * Cria uma instancia de {@link IRequiredFieldValidation} que não permite ,br>
	 * informação vazia como por exemplo uma sequencia de espacos em branco
	 */
	public static IRequiredFieldValidation createRequiredFieldDoesNotAllowInformationEmpty() {
		return springFactory.getBean(
				REQUIRED_FIELD_DOES_NOT_ALLOW_INFORMATION_EMPTY_VALIDATION_BEAN);
	}


	/**
	 * Cria uma instancia de {@link IHasBeNullValidation}
	 */
	public static IHasBeNullValidation createHasBeNullValidation() {
		return springFactory.getBean(
				HAS_BE_NULL_VALIDATION_BEAN);
	}

	/**
	 * Cria uma instancia de {@link IListValidation} que não permite que valida se uma lista não esta vaia
	 */
	public static  IListValidation<Object> createNotEmptyListValidation() {
		return springFactory.getBean(NOT_EMPTY_VALIDATION_BEAN);
	}

	/**
	 * Cria uma instancia de {@link IListValidation} que valida se uma lista esta vazia
	 */
	public static  IListValidation<Object> createHasBeEmptyListValidation() {
		return springFactory.getBean(HAS_BE_EMPTY_VALIDATION_BEAN);
	}

	/**
	 * Cria uma instancia de {@link INotNullValidation}
	 */
	public static INotNullValidation createNotNullValidation() {
		return springFactory.getBean(NOT_NULL_VALIDATION);
	}

	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de validação de CPF
	 */
	public static <E> IDocumentValidation<E> createCpfValidation() {
		return springFactory.getBean(CPF_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de validação de CNPJ 
	 */
	public static <E> IDocumentValidation<E> createCnpjValidation() {
		return springFactory.getBean(CNPJ_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de validação <br>
	 * de CNPJ e CNPJ dependendo do número passado 
	 */
	public static <E> IDocumentValidation<E> createCpfCnpjValidation() {
		return springFactory.getBean(CPF_CNPJ_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data é futura 
	 */
	public static IDateValidation createDateHasBeFutureValidation() {
		return springFactory.getBean(DATE_HAS_BE_FUTURE_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data é passado
	 */
	public static IDateValidation createDateHasBePastValidation() {
		return springFactory.getBean(DATE_HAS_BE_PAST_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data é presente 
	 */
	public static IDateValidation createDateHasBePresent() {
		return springFactory.getBean(DATE_HAS_BE_PRESENT_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data não é futura 
	 */
	public static IDateValidation createDateCanNotBeFutureValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_FUTURE_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data não é passado 
	 */
	public static IDateValidation createDateCanNotBePastValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PAST_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data não é presente 
	 */
	public static IDateValidation createDateCanNotBePresentValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PRESENT_VALIDATION_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IStringValidation} que valida o comprimento máximo de String's 
	 */
	public static AbstractMaxLengthRequiredValidation<String> createStringMaxLengthValidation(int maxLength) {
		 AbstractMaxLengthRequiredValidation<String> abstractMaxLengthRequiredValidation = 
			                springFactory.getBean(STRING_MAX_LENGTH_VALIDATION_BEAN);
		 
		 abstractMaxLengthRequiredValidation.setMaxLengthRequired(maxLength);
		 
		 return abstractMaxLengthRequiredValidation;
	}
	
	
	/**
	 * Cria uma instancia de {@link IComparableValidation} que valida a comparação entre Numbers 
	 */
	public static IComparableValidation<Number> createNumberComparableValidation(Number valorComparacao, FatorComparacao fatorComparacao) {
		AbstractComparableValidation<Number> comparableValidation = springFactory.getBean(NUMBER_COMPARABLE_VALIDATION_BEAN);
		comparableValidation.setValorComparacao(valorComparacao);
		comparableValidation.setFatorComparacao(fatorComparacao);
		
		return comparableValidation;
	}
	
	/**
	 * Cria uma instancia de {@link IValidation} que valida campos que não devem conter informação vazia 
	 */
	public static IValidation<Object> createDoesNotAllowInformationEmptyValidation() {
		return springFactory.getBean(DOES_NOT_ALLOW_INFORMATION_EMPTY_VALIDATION_BEAN);
		
	}
	
	/**
	 * Cria um IExecutorValidation padrão
	 */
	public static IExecutorValidation createExecutorValidation() {
		return springFactory.getBean(EXECUTOR_VALIDATION_BEAN);
	}
	
	/**
	 * Cria um {@link IExecutorValidation} para o tratamento de validações em mult threads
	 */
	public static IExecutorValidation createExecutorValidationMultThread() {
		return springFactory.getBean(EXECUTOR_VALIDATION_MULT_THREAD_BEAN);
	}
	
	/**
	 * Cria um {@link IExecutorValidationAnnotationEngine} para o tratamento de validações utilizando annotations
	 */
	public static IExecutorValidationAnnotationEngine createExecutorValidationAnnotationEngine() {
		return springFactory.getBean(EXECUTOR_VALIDATION_ANNOTATION_ENGINE_BEAN);
	}
	
	
	/**
	 * Retorna uma instancia do bean de validação, se existir um, cujo id é passado como argumento. <br><br>
	 * 
	 * O bean buscado deve estar no contexto através da classe {@link LindbergSpringFactory}
	 * 
	 * @param <E>
	 * @param id
	 * @return
	 */
	public static <E> IValidation<E> getValidationBean(String id) throws NoSuchBeanValidationException{
		Object bean = null;
		try{
	      bean = springFactory.getBean(id);
	      if (bean == null || ! (bean instanceof IValidation))
	    	  throw new NoSuchBeanValidationException();
		}catch(NoSuchBeanDefinitionException ex){
		   throw new NoSuchBeanValidationException();	
		}
		
		return (IValidation<E>) bean;
	}

	public static <E> IValidation<E> getValidationBeanReturningNullIfNoSuchBean(String id) throws NoSuchBeanValidationException{
		try{
	      return getValidationBean(id);
		}catch(NoSuchBeanValidationException ex){
		   return null;	
		}
	}
	
	
	
}
