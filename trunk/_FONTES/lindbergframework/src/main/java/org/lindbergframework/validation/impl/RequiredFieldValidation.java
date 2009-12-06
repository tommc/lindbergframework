package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IRequiredFieldValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa��o de valida��o de campo requerido. Esta valida��o permite informa��o vazia <br>
 * ou seja sequencia de caracteres espa�o. Validar n�o permitindo informa��o <br>
 * vazia use {@link RequiredFieldDoesNotAllowInformationEmpty}
 * 
 * 
 * @author Victor Lindberg
 *
 */
@Component("requiredFieldValidation")
public class RequiredFieldValidation implements IRequiredFieldValidation 
{

	/**
	 * valida campo requerido
	 */
	public void validate(Object valor) throws ValidationException 
	{
       if (valor == null || valor.toString().length() == 0)
    	   throw new ValidationException("Campo requerido");
	}

}
