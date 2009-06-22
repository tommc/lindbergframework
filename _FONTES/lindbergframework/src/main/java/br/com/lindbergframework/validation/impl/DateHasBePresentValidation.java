package br.com.lindbergframework.validation.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IDateValidation;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateHasBePresent")
public class DateHasBePresentValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && date.compareTo(new Date()) != 0)
			throw new ValidationException("Data é diferente da atual");
	}

}
