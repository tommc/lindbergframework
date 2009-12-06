package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa a validação de que a data é passada
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateHasBePastValidation")
public class DateHasBePastValidation implements IDateValidation{
	
	public void validate(Date data) throws ValidationException {
	   if (data != null && ! data.before(new Date()))
		   throw new ValidationException("Data maior ou igual a atual");
	}

}
