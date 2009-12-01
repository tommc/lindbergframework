package br.com.lindbergframework.validation.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IDateValidation;

/**
 * Implementa a validação de que a data é futura
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateHasBeFutureValidation")
public class DateHasBeFutureValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
	   if (date != null && ! date.after(new Date()))
		   throw new ValidationException("Data menor ou igual a atual");
	}

}
