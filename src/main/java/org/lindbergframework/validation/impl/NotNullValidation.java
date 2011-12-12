package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.INotNullValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementação de validação de obrigatoriedade não null
 * 
 * @author Victor Lindberg
 *
 */
@Component("notNullValidation")
@Scope("prototype")
public class NotNullValidation implements INotNullValidation{
	
	public void validate(Object objeto) throws ValidationException {
	   if (objeto == null)
		   throw new ValidationException("Validação not null falhou");
	}
	
}
