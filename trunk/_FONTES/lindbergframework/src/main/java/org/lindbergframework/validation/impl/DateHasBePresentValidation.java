package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa a valida��o de que a data � presente
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateHasBePresent")
public class DateHasBePresentValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && date.after(new Date()) || date.before(new Date()))
			throw new ValidationException("Data � diferente da atual");
	}

}
