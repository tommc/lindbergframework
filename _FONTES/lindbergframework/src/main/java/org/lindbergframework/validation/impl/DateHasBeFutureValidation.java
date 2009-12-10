package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.DateUtil;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa a valida��o de que a data � futura
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateHasBeFutureValidation")
public class DateHasBeFutureValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
	   if (date != null && ! DateUtil.isAfterDespisingTime(date, new Date()))
		   throw new ValidationException("Data menor ou igual a atual");
	}

}
