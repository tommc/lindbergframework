package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IRequiredFieldValidation;

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
