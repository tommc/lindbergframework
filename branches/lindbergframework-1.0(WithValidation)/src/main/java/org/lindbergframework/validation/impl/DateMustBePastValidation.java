package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.DateUtil;
import org.lindbergframework.validation.IDateValidation;
import org.lindbergframework.validation.Types;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementa a validação de que a data é passada
 * 
 * @author Victor Lindberg
 *
 */
@Component(Types.DATE_MUST_BE_PAST)
@Scope("prototype")
public class DateMustBePastValidation implements IDateValidation{
	
	public void validate(Date data) throws ValidationException {
	   if (data != null && ! DateUtil.isBeforeDespisingTime(data, new Date()))
		   throw new ValidationException("Data maior ou igual a atual");
	}

}
