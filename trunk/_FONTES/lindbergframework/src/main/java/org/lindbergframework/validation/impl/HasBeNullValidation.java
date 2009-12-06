package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IHasBeNullValidation;
import org.springframework.stereotype.Component;


/**
 * 
 * Se o argumento passado n�o for <i>null</i> � lan�ada uma {@link ValidationException} <br>
 * Essa valida��o garante que n�o passar� um argumento que seja <i>null</i>
 * 
 * @author Victor Lindberg
 *
 */
@Component("hasBeNullValidacao")
public class HasBeNullValidation implements IHasBeNullValidation {
	
	public void validate(Object objeto) throws ValidationException {
	   if (objeto != null)
		   throw new ValidationException("Objeto informado onde era esperado null");
	}
	
}
