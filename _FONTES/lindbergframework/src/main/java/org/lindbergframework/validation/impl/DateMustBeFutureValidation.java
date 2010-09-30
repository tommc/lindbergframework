package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.DateUtil;
import org.lindbergframework.validation.IDateValidation;
import org.lindbergframework.validation.Types;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementa a validação de que a data é futura
 * 
 * @author Victor Lindberg
 *
 */
@Component(Types.DATE_MUST_BE_FUTURE)
@Scope("prototype")
public class DateMustBeFutureValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
	   if (date != null && ! DateUtil.isAfterDespisingTime(date, new Date()))
		   throw new ValidationException("Data menor ou igual a atual");
	}

}
