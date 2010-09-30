package org.lindbergframework.validation.factory;

import static org.lindbergframework.validation.Types.CNPJ;
import static org.lindbergframework.validation.Types.CPF;
import static org.lindbergframework.validation.Types.CPF_CNPJ;
import static org.lindbergframework.validation.Types.DATE_CAN_NOT_BE_FUTURE;
import static org.lindbergframework.validation.Types.DATE_CAN_NOT_BE_PAST;
import static org.lindbergframework.validation.Types.DATE_CAN_NOT_BE_PRESENT;
import static org.lindbergframework.validation.Types.DATE_MUST_BE_FUTURE;
import static org.lindbergframework.validation.Types.DATE_MUST_BE_PAST;
import static org.lindbergframework.validation.Types.DATE_MUST_BE_PRESENT;
import static org.lindbergframework.validation.Types.MUST_BE_EMPTY_LIST;
import static org.lindbergframework.validation.Types.MUST_BE_NULL;
import static org.lindbergframework.validation.Types.NOT_EMPTY_LIST;
import static org.lindbergframework.validation.Types.NOT_NULL;
import static org.lindbergframework.validation.Types.NO_INFORMATION_EMPTY;
import static org.lindbergframework.validation.Types.NUMBER_COMPARABLE;
import static org.lindbergframework.validation.Types.REQUIRED_FIELD;
import static org.lindbergframework.validation.Types.REQUIRED_FIELD_NO_INFORMATION_EMPTY;
import static org.lindbergframework.validation.Types.STRING_MAX_LENGTH;

import org.lindbergframework.exception.NoSuchBeanValidationException;
import org.lindbergframework.validation.AbstractComparableValidation;
import org.lindbergframework.validation.AbstractMaxLengthRequiredValidation;
import org.lindbergframework.validation.IComparableValidation;
import org.lindbergframework.validation.IDateValidation;
import org.lindbergframework.validation.IDocumentValidation;
import org.lindbergframework.validation.IMustBeNullValidation;
import org.lindbergframework.validation.IListValidation;
import org.lindbergframework.validation.INotNullValidation;
import org.lindbergframework.validation.IRequiredFieldValidation;
import org.lindbergframework.validation.IValidation;
import org.lindbergframework.validation.AbstractComparableValidation.FatorComparacao;
import org.lindbergframework.validation.context.LindbergValidationSpringBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;


/**
 * Fábrica de validações
 * 
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationFactory {
	 
	private static LindbergValidationSpringBeanFactory springFactory = LindbergValidationSpringBeanFactory.getInstance();
	
	/**
	 * Cria uma instancia de {@link IRequiredFieldValidation}
	 */
	public static IRequiredFieldValidation newRequiredField() {
		return springFactory.getBean(
				REQUIRED_FIELD);
	}
	/**
	 * Cria uma instancia de {@link IRequiredFieldValidation} que não permite ,br>
	 * informação vazia como por exemplo uma sequencia de espacos em branco
	 */
	public static IRequiredFieldValidation newRequiredFieldNoInformationEmpty() {
		return springFactory.getBean(
				REQUIRED_FIELD_NO_INFORMATION_EMPTY);
	}


	/**
	 * Cria uma instancia de {@link IMustBeNullValidation}
	 */
	public static IMustBeNullValidation newHasBeNull() {
		return springFactory.getBean(
				MUST_BE_NULL);
	}

	/**
	 * Cria uma instancia de {@link IListValidation} que não permite que valida se uma lista não esta vaia
	 */
	public static  IListValidation<Object> newNotEmptyList() {
		return springFactory.getBean(NOT_EMPTY_LIST);
	}

	/**
	 * Cria uma instancia de {@link IListValidation} que valida se uma lista esta vazia
	 */
	public static  IListValidation<Object> newHasBeEmptyList() {
		return springFactory.getBean(MUST_BE_EMPTY_LIST);
	}

	/**
	 * Cria uma instancia de {@link INotNullValidation}
	 */
	public static INotNullValidation newNotNull() {
		return springFactory.getBean(NOT_NULL);
	}

	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de validação de CPF
	 */
	public static <E> IDocumentValidation<E> newCpf() {
		return springFactory.getBean(CPF);
	}
	
	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de validação de CNPJ 
	 */
	public static <E> IDocumentValidation<E> newCnpj() {
		return springFactory.getBean(CNPJ);
	}
	
	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de validação <br>
	 * de CNPJ e CNPJ dependendo do número passado 
	 */
	public static <E> IDocumentValidation<E> newCpfCnpj() {
		return springFactory.getBean(CPF_CNPJ);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data é futura 
	 */
	public static IDateValidation newDateHasBeFuture() {
		return springFactory.getBean(DATE_MUST_BE_FUTURE);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data é passado
	 */
	public static IDateValidation newDateHasBePast() {
		return springFactory.getBean(DATE_MUST_BE_PAST);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data é presente 
	 */
	public static IDateValidation newDateHasBePresent() {
		return springFactory.getBean(DATE_MUST_BE_PRESENT);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data não é futura 
	 */
	public static IDateValidation newDateCanNotBeFuture() {
		return springFactory.getBean(DATE_CAN_NOT_BE_FUTURE);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data não é passado 
	 */
	public static IDateValidation newDateCanNotBePast() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PAST);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data não é presente 
	 */
	public static IDateValidation newDateCanNotBePresent() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PRESENT);
	}
	
	/**
	 * Cria uma instancia de {@link IStringValidation} que valida o comprimento máximo de String's 
	 */
	public static AbstractMaxLengthRequiredValidation<String> newStringMaxLength(int maxLength) {
		 AbstractMaxLengthRequiredValidation<String> abstractMaxLengthRequiredValidation = 
			                springFactory.getBean(STRING_MAX_LENGTH);
		 
		 abstractMaxLengthRequiredValidation.setMaxLengthRequired(maxLength);
		 
		 return abstractMaxLengthRequiredValidation;
	}
	
	
	/**
	 * Cria uma instancia de {@link IComparableValidation} que valida a comparação entre Numbers 
	 */
	public static IComparableValidation<Number> newNumberComparable(Number valorComparacao, FatorComparacao fatorComparacao) {
		AbstractComparableValidation<Number> comparableValidation = springFactory.getBean(NUMBER_COMPARABLE);
		comparableValidation.setValorComparacao(valorComparacao);
		comparableValidation.setFatorComparacao(fatorComparacao);
		
		return comparableValidation;
	}
	
	/**
	 * Cria uma instancia de {@link IValidation} que valida campos que não devem conter informação vazia 
	 */
	public static IValidation<Object> newNoInformationEmpty() {
		return springFactory.getBean(NO_INFORMATION_EMPTY);
		
	}
	
	
	/**
	 * Retorna uma instancia do bean de validação, se existir um, cujo id é passado como argumento. <br><br>
	 * 
	 * O bean buscado deve estar no contexto através da classe {@link LindbergValidationSpringBeanFactory}
	 * 
	 * @param <E>
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
