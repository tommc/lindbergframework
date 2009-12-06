package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IRequiredFieldValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa��o de valida��o de valor requerido e que n�o permite <br>
 * informa��o vazia como uma sequencia de caracteres espa�o
 * 
 * @author Victor Linndberg
 *
 */
@Component("requiredFieldDoesNotAllowInformationEmpty")
public class RequiredFieldDoesNotAllowInformationEmpty implements IRequiredFieldValidation {
	
	public void validate(Object valor) throws ValidationException {
		if (valor == null || valor.toString().trim().length() == 0)
	    	   throw new ValidationException("Campo requerido");
	}

}
