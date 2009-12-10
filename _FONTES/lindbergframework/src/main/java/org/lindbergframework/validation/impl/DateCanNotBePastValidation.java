package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.DateUtil;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa a validação de que a data não pode ser passado
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateCanNotBePastValidation")
public class DateCanNotBePastValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && DateUtil.isBeforeDespisingTime(date,new Date()))
			throw new ValidationException("Data não pode ser menor do que a atual");
	}
	
	
	
	
}
