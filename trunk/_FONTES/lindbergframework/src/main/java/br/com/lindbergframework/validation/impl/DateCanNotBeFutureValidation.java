package br.com.lindbergframework.validation.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IDateValidation;

/**
 * Implementa a valida��o de que a data n�o pode ser futura
 * 
 * @author victorsilva
 *
 */
@Component("dateCanNotBeFutureValidation")
public class DateCanNotBeFutureValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && date.after(new Date()))
			throw new ValidationException("Data n�o pode ser maior do que a atual");
		
	}

}
