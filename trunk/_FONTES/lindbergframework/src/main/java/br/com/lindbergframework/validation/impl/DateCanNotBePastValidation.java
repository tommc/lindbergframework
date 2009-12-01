package br.com.lindbergframework.validation.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IDateValidation;

/**
 * Implementa a valida��o de que a data n�o pode ser passada
 * 
 * @author Victor Lindberg
 *
 */
@Component("dateCanNotBePastValidation")
public class DateCanNotBePastValidation implements IDateValidation{
	
	public void validate(Date date) throws ValidationException {
		if (date != null && date.before(new Date()))
			throw new ValidationException("Data n�o pode ser menor do que a atual");
	}

}
