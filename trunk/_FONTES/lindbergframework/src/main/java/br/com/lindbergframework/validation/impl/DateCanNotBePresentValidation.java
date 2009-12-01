package br.com.lindbergframework.validation.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IDateValidation;

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
