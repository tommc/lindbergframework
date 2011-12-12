package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.DateUtil;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementa a validação de que a data é presente
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateHasBePresent")
@Scope("prototype")
public class DateHasBePresentValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && ! DateUtil.isEqualDespisingTime(date, new Date()))
			throw new ValidationException("Data é diferente da atual");
	}
	
}
