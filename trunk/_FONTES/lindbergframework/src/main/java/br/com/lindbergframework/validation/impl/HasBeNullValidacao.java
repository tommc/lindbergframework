package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IHasBeNullValidacao;

/**
 * 
 * Se o argumento passado não for <i>null</i> é lançada uma {@link ValidationException} <br>
 * Essa validação garante que não passará um argumento que seja <i>null</i>
 * 
 * @author Victor Lindberg
 *
 */
@Component("hasBeNullValidacao")
public class HasBeNullValidacao implements IHasBeNullValidacao {
	
	public void validate(Object objeto) throws ValidationException {
	   if (objeto != null)
		   throw new ValidationException("Objeto informado onde era esperado null");
	}
	
}
