﻿package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.DateUtil;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementa a validação de que a data não pode ser presente
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateCanNotBePresentValidation")
@Scope("prototype")
public class DateCanNotBePresentValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
	   	if (date != null && DateUtil.isEqualDespisingTime(date, new Date()))
	   		throw new ValidationException("Data não pode ser igual a atual");
	}

}
