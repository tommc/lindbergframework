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
	
	public static final String REQUIRED_FIELD = "requiredFieldValidation";
	public static final String REQUIRED_FIELD_NO_INFORMATION_EMPTY = "requiredFieldDoesNotAllowInformationEmpty";
	public static final String NOT_NULL = "notNullValidation";
	public static final String NOT_EMPTY_LIST = "notEmptyListValidation";
	public static final String MUST_BE_NULL = "mustBeNullValidation";
	public static final String CPF = "cpfValidation";
	public static final String CNPJ = "cnpjValidation";
	public static final String CPF_CNPJ = "cpfAndCnpjValidation";
	public static final String DATE_MUST_BE_FUTURE = "dateMustBeFutureValidation";
	public static final String DATE_MUST_BE_PAST = "dateMustBePastValidation";
	public static final String DATE_MUST_BE_PRESENT = "dateMustBePresent";
	public static final String DATE_CAN_NOT_BE_FUTURE = "dateCanNotBeFutureValidation";
	public static final String DATE_CAN_NOT_BE_PAST = "dateCanNotBePastValidation";
	public static final String DATE_CAN_NOT_BE_PRESENT = "dateCanNotBePresentValidation";
	public static final String MUST_BE_EMPTY_LIST = "mustBeEmptyListValidation";
	public static final String NUMBER_COMPARABLE = "numberComparableValidation";
	public static final String STRING_MAX_LENGTH = "stringMaxLengthValidation";
	public static final String NO_INFORMATION_EMPTY = "doesNotAllowInformationEmptyValidation";

}
