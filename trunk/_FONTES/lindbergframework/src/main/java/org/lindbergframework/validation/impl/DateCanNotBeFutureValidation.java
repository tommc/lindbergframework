package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa a validação de que a data não pode ser futura
 * 
 * @author victorsilva
 *
 */
@Component("dateCanNotBeFutureValidation")
public class DateCanNotBeFutureValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && date.after(new Date()))
			throw new ValidationException("Data não pode ser maior do que a atual");
		
	}

}
