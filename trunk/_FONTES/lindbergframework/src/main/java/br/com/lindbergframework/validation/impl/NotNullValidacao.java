package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.INotNullValidacao;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Component("notNullValidacao")
public class NotNullValidacao implements INotNullValidacao{
	
	public void validate(Object objeto) throws ValidationException {
	   if (objeto == null)
		   throw new ValidationException("Validação not null falhou");
	}

}
