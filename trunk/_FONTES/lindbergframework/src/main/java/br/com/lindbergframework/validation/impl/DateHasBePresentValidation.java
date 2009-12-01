package br.com.lindbergframework.validation.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IDateValidation;

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
