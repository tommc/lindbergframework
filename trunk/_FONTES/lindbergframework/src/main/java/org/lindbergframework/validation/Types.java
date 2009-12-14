package org.lindbergframework.validation;

import org.lindbergframework.validation.factory.ValidationFactory;

/**
 * Interface que contem um conjunto de constantes com os ID´s dos beans de validação. <br><br>
 * 
 * Para obter beans de validação usando essa interface use {@link ValidationFactory} <br>
 * através do método <i>getValidationBean</i> ou <i>getValidationBeanReturningNullIfNoSuchBean</i> <br>
 * passando uma constante dessa interface como ID para obter uma instancia do bean.<br><br>
 * 
 * Essa interface deve ser usada também na utilização das validações via annotation através da @Valid <br>
 * onde sendo passada qualquer uma dessas constantes para o atributo value dessa annotation <br>
 * então a validação criada será o baseada no bean de validação ao qual a constante representa. <br><br>
 * 
 * Exemplo usando {@link ValidationFactory}<br><br>
 * 
 * ValidationFactory.getValidationBean(Types.NOT_NULL_VALIDATION)<br><br>
 * 
 *  Exemplo usando @Valid<br><br>
 *  
 *  (Arroba)Valid(Types.NOT_NULL_VALIDATION)<br>
	private String campo;  
 * 
 * 
 * @author Victor Lindberg
 *
 */
public interface Types {
	
	public static final String REQUIRED_FIELD_VALIDATION_BEAN = "requiredFieldValidation";
	public static final String REQUIRED_FIELD_DOES_NOT_ALLOW_INFORMATION_EMPTY_VALIDATION_BEAN = "requiredFieldDoesNotAllowInformationEmpty";
	public static final String NOT_NULL_VALIDATION = "notNullValidation";
	public static final String NOT_EMPTY_VALIDATION_BEAN = "notEmptyListValidation";
	public static final String HAS_BE_NULL_VALIDATION_BEAN = "hasBeNullValidation";
	public static final String NUMBER_GREATER_THAN_ZERO_VALIDATION_BEAN = "numberGreaterThanZeroValidation";
	public static final String CPF_VALIDATION_BEAN = "cpfValidation";
	public static final String CNPJ_VALIDATION_BEAN = "cnpjValidation";
	public static final String CPF_CNPJ_VALIDATION_BEAN = "cpfAndCnpjValidation";
	public static final String DATE_HAS_BE_FUTURE_VALIDATION_BEAN = "dateHasBeFutureValidation";
	public static final String DATE_HAS_BE_PAST_VALIDATION_BEAN = "dateHasBePastValidation";
	public static final String DATE_HAS_BE_PRESENT_VALIDATION_BEAN = "dateHasBePresent";
	public static final String DATE_CAN_NOT_BE_FUTURE_VALIDATION_BEAN = "dateCanNotBeFutureValidation";
	public static final String DATE_CAN_NOT_BE_PAST_VALIDATION_BEAN = "dateCanNotBePastValidation";
	public static final String DATE_CAN_NOT_BE_PRESENT_VALIDATION_BEAN = "dateCanNotBePresentValidation";
	public static final String HAS_BE_EMPTY_VALIDATION_BEAN = "hasBeEmptyListValidation";
	public static final String NUMBER_COMPARABLE_VALIDATION_BEAN = "numberComparableValidation";
	public static final String STRING_MAX_LENGTH_VALIDATION_BEAN = "stringMaxLengthValidation";
	public static final String DOES_NOT_ALLOW_INFORMATION_EMPTY_VALIDATION_BEAN = "doesNotAllowInformationEmptyValidation";

}
