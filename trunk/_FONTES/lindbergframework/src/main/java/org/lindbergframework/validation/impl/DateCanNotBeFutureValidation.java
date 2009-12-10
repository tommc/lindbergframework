package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.DateUtil;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.stereotype.Component;


/**
 * Implementaçãoo da validação de que a data não pode ser futura
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateCanNotBeFutureValidation")
public class DateCanNotBeFutureValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && DateUtil.isAfterDespisingTime(date,new Date()))
			throw new ValidationException("Data n�o pode ser maior do que a atual");
		
	}

}
