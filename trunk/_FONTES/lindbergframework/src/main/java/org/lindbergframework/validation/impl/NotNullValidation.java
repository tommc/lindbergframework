package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.INotNullValidation;
import org.springframework.stereotype.Component;


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
