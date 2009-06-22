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
@Component("dateCanNotBePastValidation")
public class DateCanNotBePastValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && date.compareTo(new Date()) < 0)
			throw new ValidationException("Data não pode ser menor do que a atual");
	}

}
