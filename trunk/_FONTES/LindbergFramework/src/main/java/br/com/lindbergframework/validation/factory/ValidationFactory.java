package br.com.lindbergframework.validation.factory;

import br.com.lindbergframework.spring.LindbergSpringFactory;
import br.com.lindbergframework.validation.ICampoRequeridoValidacao;
import br.com.lindbergframework.validation.IDateValidation;
import br.com.lindbergframework.validation.IDocumentValidation;
import br.com.lindbergframework.validation.IHasBeNullValidacao;
import br.com.lindbergframework.validation.INotEmptyListValidacao;
import br.com.lindbergframework.validation.INotNullValidacao;
import br.com.lindbergframework.validation.INumberValidation;
import br.com.lindbergframework.validation.IValidationComposite;

/**
 * Fábrica de validadores
 * 
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationFactory {
	
	public static final String CAMPO_REQUERIDO_VALIDACAO_BEAN = "campoRequeridoValidacao";
	public static final String CAMPO_REQUERIDO_NAO_PERMITINDO_INFO_VAZIA_VALIDACAO_BEAN = "campoRequeridoNaoPermitindoInformacaoVazia";
	public static final String NOT_NULL_VALIDACAO = "notNullValidacao";
	public static final String VALIDACAO_COMPOSITE_BEAN = "validacaoComposite";
	public static final String DOUBLE_VALIDACAO_BEAN = "doubleValidacao";
	public static final String NOT_EMPTY_VALIDACAO_BEAN = "notEmptyListValidacao";
	public static final String HAS_BE_NULL_VALIDACAO_BEAN = "hasBeNullValidacao";
	public static final String NUMBER_MAIOR_QUE_ZERO_VALIDACAO_BEAN = "numberMaiorQueZeroValidacao";
	public static final String CPF_VALIDACAO_BEAN = "cpfValidation";
	public static final String CNPJ_VALIDACAO_BEAN = "cnpjValidation";
	public static final String CPF_CNPJ_VALIDACAO_BEAN = "cpfAndCnpjValidation";
	public static final String DATE_HAS_BE_FUTURE_VALIDACAO_BEAN = "dateHasBeFutureValidation";
	public static final String DATE_HAS_BE_PAST_VALIDACAO_BEAN = "dateHasBePastValidation";
	public static final String DATE_HAS_BE_PRESENT_VALIDACAO_BEAN = "dateHasBePresent";
	public static final String DATE_CAN_NOT_BE_FUTURE_VALIDACAO_BEAN = "dateCanNotBeFutureValidation";
	public static final String DATE_CAN_NOT_BE_PAST_VALIDACAO_BEAN = "dateCanNotBePastValidation";
	public static final String DATE_CAN_NOT_BE_PRESENT_VALIDACAO_BEAN = "dateCanNotBePresentValidation";

	
	private static LindbergSpringFactory springFactory = LindbergSpringFactory.getInstance();
	
	public static ICampoRequeridoValidacao createCampoRequeridoValidacao() {
		return springFactory.getBean(
				CAMPO_REQUERIDO_VALIDACAO_BEAN);
	}
	
	public static ICampoRequeridoValidacao createCampoRequeridoNaoPermitindoInfoVaziaValidacao() {
		return springFactory.getBean(
				CAMPO_REQUERIDO_NAO_PERMITINDO_INFO_VAZIA_VALIDACAO_BEAN);
	}

	public static INumberValidation createNumberMaiorQueZeroValidacao() {
		return springFactory.getBean(
				NUMBER_MAIOR_QUE_ZERO_VALIDACAO_BEAN);
	}

	public static IHasBeNullValidacao createHasBeNullValidacao() {
		return springFactory.getBean(
				HAS_BE_NULL_VALIDACAO_BEAN);
	}

	public static INotEmptyListValidacao createNotEmptyListValidacao() {
		return springFactory.getBean(NOT_EMPTY_VALIDACAO_BEAN);
	}

	public static INotNullValidacao createNotNullValidacao() {
		return springFactory.getBean(NOT_NULL_VALIDACAO);
	}

	public static INumberValidation createDoubleValidacao() {
		return springFactory.getBean(DOUBLE_VALIDACAO_BEAN);
	}
	
	public static <E> IDocumentValidation<E> createCpfValidacao() {
		return springFactory.getBean(CPF_VALIDACAO_BEAN);
	}
	
	public static <E> IDocumentValidation<E> createCnpjValidacao() {
		return springFactory.getBean(CNPJ_VALIDACAO_BEAN);
	}
	
	public static <E> IDocumentValidation<E> createCpfCnpjValidacao() {
		return springFactory.getBean(CPF_CNPJ_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateHasBeFutureValidation() {
		return springFactory.getBean(DATE_HAS_BE_FUTURE_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateHasBePastValidation() {
		return springFactory.getBean(DATE_HAS_BE_PAST_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateHasBePresent() {
		return springFactory.getBean(DATE_HAS_BE_PRESENT_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateCanNotBeFutureValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_FUTURE_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateCanNotBePastValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PAST_VALIDACAO_BEAN);
	}
	
	public static IDateValidation createDateCanNotBePresentValidation() {
		return springFactory.getBean(DATE_CAN_NOT_BE_PRESENT_VALIDACAO_BEAN);
	}
	

	/**
	 * Cria um ValidationComposite
	 */
	public static IValidationComposite createValidationComposite() {
		return springFactory.getBean(VALIDACAO_COMPOSITE_BEAN);
	}

	

}
