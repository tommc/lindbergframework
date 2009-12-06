package org.lindbergframework.validation.factory;

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
import org.lindbergframework.validation.ValidationItem;
import org.lindbergframework.validation.AbstractComparableValidation.FatorComparacao;


/**
 * F�brica de valida��es
 * 
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationFactory {
	 
	public static final String REQUIRED_FIELD_VALIDATION_BEAN = "requiredFieldValidation";
	public static final String REQUIRED_FIELD_DOES_NOT_ALLOW_INFORMATION_EMPTY_VALIDATION_BEAN = "requiredFieldDoesNotAllowInformationEmpty";
	public static final String NOT_NULL_VALIDACAO = "notNullValidacao";
	public static final String EXECUTOR_VALIDATION_BEAN = "executorValidation";
	public static final String DOUBLE_VALIDACAO_BEAN = "doubleValidacao";
	public static final String NOT_EMPTY_VALIDACAO_BEAN = "notEmptyListValidacao";
	public static final String HAS_BE_NULL_VALIDACAO_BEAN = "hasBeNullValidacao";
	public static final String NUMBER_GREATER_THAN_ZERO_VALIDATION_BEAN = "numberGreaterThanZeroValidation";
	public static final String CPF_VALIDACAO_BEAN = "cpfValidation";
	public static final String CNPJ_VALIDACAO_BEAN = "cnpjValidation";
	public static final String CPF_CNPJ_VALIDACAO_BEAN = "cpfAndCnpjValidation";
	public static final String DATE_HAS_BE_FUTURE_VALIDACAO_BEAN = "dateHasBeFutureValidation";
	public static final String DATE_HAS_BE_PAST_VALIDACAO_BEAN = "dateHasBePastValidation";
	public static final String DATE_HAS_BE_PRESENT_VALIDACAO_BEAN = "dateHasBePresent";
	public static final String DATE_CAN_NOT_BE_FUTURE_VALIDACAO_BEAN = "dateCanNotBeFutureValidation";
	public static final String DATE_CAN_NOT_BE_PAST_VALIDACAO_BEAN = "dateCanNotBePastValidation";
	public static final String DATE_CAN_NOT_BE_PRESENT_VALIDACAO_BEAN = "dateCanNotBePresentValidation";
	public static final String HAS_BE_EMPTY_VALIDACAO_BEAN = "hasBeEmptyListValidation";
	public static final String NUMBER_COMPARABLE_VALIDATION_BEAN = "numberComparableValidation";
	public static final String STRING_MAX_LENGTH_VALIDATION_BEAN = "stringMaxLengthValidation";

	
	private static LindbergSpringFactory springFactory = LindbergSpringFactory.getInstance();
	
	/**
	 * Cria uma instancia de {@link IRequiredFieldValidation}
	 */
	public static IRequiredFieldValidation createRequiredFieldValidation() {
		return springFactory.getBean(
				REQUIRED_FIELD_VALIDATION_BEAN);
	}
	 
	/**
	 * Cria uma instancia de {@link IRequiredFieldValidation} que n�o permite ,br>
	 * informa��o vazia como por exemplo uma sequencia de espa�os em branco
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
				HAS_BE_NULL_VALIDACAO_BEAN);
	}

	/**
	 * Cria uma instancia de {@link IListValidation} que n�o permite que valida se uma lista n�o esta vaia
	 */
	public static  IListValidation<Object> createNotEmptyListValidation() {
		return springFactory.getBean(NOT_EMPTY_VALIDACAO_BEAN);
	}

	/**
	 * Cria uma instancia de {@link IListValidation} que valida se uma lista esta vazia
	 */
	public static  IListValidation<Object> createHasBeEmptyListValidation() {
		return springFactory.getBean(HAS_BE_EMPTY_VALIDACAO_BEAN);
	}

	/**
	 * Cria uma instancia de {@link INotNullValidation}
	 */
	public static INotNullValidation createNotNullValidation() {
		return springFactory.getBean(NOT_NULL_VALIDACAO);
	}

	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de valida��o de CPF
	 */
	public static <E> IDocumentValidation<E> createCpfValidation() {
		return springFactory.getBean(CPF_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de valida��o de CNPJ 
	 */
	public static <E> IDocumentValidation<E> createCnpjValidacao() {
		return springFactory.getBean(CNPJ_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDocumentValidation} que implementa a regra de valida��o <br>
	 * de CNPJ e CNPJ dependendo do n�mero passado 
	 */
	public static <E> IDocumentValidation<E> createCpfCnpjValidation() {
		return springFactory.getBean(CPF_CNPJ_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data � futura 
	 */
	public static IDateValidation createDateHasBeFutureValidation() {
		return springFactory.getBean(DATE_HAS_BE_FUTURE_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data � passado
	 */
	public static IDateValidation createDateHasBePastValidation() {
		return springFactory.getBean(DATE_HAS_BE_PAST_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data � presente 
	 */
	public static IDateValidation createDateHasBePresent() {
		return springFactory.getBean(DATE_HAS_BE_PRESENT_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data n�o � futura 
	 */
	public static IDateValidation createDateCanNotBeFutureValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_FUTURE_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data n�o � passado 
	 */
	public static IDateValidation createDateCanNotBePastValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PAST_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IDateValidation} que valida se a data n�o � presente 
	 */
	public static IDateValidation createDateCanNotBePresentValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PRESENT_VALIDACAO_BEAN);
	}
	
	/**
	 * Cria uma instancia de {@link IStringValidation} que valida o comprimento m�ximo de String�s 
	 */
	public static AbstractMaxLengthRequiredValidation<String> createStringMaxLengthValidation(int maxLength) {
		 AbstractMaxLengthRequiredValidation<String> abstractMaxLengthRequiredValidation = 
			                springFactory.getBean(STRING_MAX_LENGTH_VALIDATION_BEAN);
		 
		 abstractMaxLengthRequiredValidation.setMaxLengthRequired(maxLength);
		 
		 return abstractMaxLengthRequiredValidation;
	}
	
	
	/**
	 * Cria uma instancia de {@link IComparableValidation} que valida a compara��o entre Numbers 
	 */
	public static IComparableValidation<Number> createNumberComparableValidation(Number valorComparacao, FatorComparacao fatorComparacao) {
		AbstractComparableValidation<Number> comparableValidation = springFactory.getBean(NUMBER_COMPARABLE_VALIDATION_BEAN);
		comparableValidation.setValorComparacao(valorComparacao);
		comparableValidation.setFatorComparacao(fatorComparacao);
		
		return comparableValidation;
	}
	
	/**
	 * Cria um IExecutorValidation
	 */
	public static IExecutorValidation createExecutorValidation() {
		return springFactory.getBean(EXECUTOR_VALIDATION_BEAN);
	}
	
}
