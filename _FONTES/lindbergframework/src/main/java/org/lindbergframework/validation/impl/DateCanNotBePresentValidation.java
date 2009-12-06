package org.lindbergframework.validation.impl;

import java.util.Date;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IDateValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa a validação de que a data não pode ser presente
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateCanNotBePresentValidation")
public class DateCanNotBePresentValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		Date dateAtual = new Date();
		
	   	if (date != null && ! date.before(dateAtual) && ! date.after(dateAtual))
	   		throw new ValidationException("Data nao pode ser igual a atual");
	}

}
