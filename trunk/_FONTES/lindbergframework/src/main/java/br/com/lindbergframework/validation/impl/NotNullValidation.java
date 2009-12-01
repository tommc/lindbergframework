package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.INotNullValidation;

/**
 * Implementa��o de valida��o de obrigatoriedade n�o null
 * 
 * @author Victor Lindberg
 *
 */
@Component("notNullValidacao")
public class NotNullValidation implements INotNullValidation{
	
	public void validate(Object objeto) throws ValidationException {
	   if (objeto == null)
		   throw new ValidationException("Valida��o not null falhou");
	}
	
}
