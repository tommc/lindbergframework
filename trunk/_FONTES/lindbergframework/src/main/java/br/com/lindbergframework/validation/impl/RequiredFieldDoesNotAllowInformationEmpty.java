package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IRequiredFieldValidation;

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
