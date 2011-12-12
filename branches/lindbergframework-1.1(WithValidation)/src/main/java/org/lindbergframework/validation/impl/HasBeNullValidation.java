package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IMustBeNullValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 
 * Se o argumento passado não for <i>null</i> é lancada uma {@link ValidationException} <br>
 * Essa validação garante que não passará um argumento que seja <i>null</i>
 * 
 * @author Victor Lindberg
 *
 */
@Component("hasBeNullValidation")
@Scope("prototype")
public class HasBeNullValidation implements IMustBeNullValidation {
	
	public void validate(Object objeto) throws ValidationException {
	   if (objeto != null)
		   throw new ValidationException("Objeto informado onde era esperado null");
	}
	
}
