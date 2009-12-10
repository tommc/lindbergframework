package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IRequiredFieldValidation;
import org.springframework.stereotype.Component;


/**
 * Implementação de validação de valor requerido e que não permite <br>
 * informação vazia como uma sequencia de caracteres espaço
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
