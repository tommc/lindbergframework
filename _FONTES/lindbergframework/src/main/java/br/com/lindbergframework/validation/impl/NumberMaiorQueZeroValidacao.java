package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.INumberValidation;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Component("numberMaiorQueZeroValidacao")
public class NumberMaiorQueZeroValidacao implements INumberValidation{
	 
	public void validate(Number valor) throws ValidationException {
	   if (valor != null && valor.doubleValue() <= 0)
		   throw new ValidationException("Campo de valor monetário tem que ser maior que 0,00");
	}
	
		
}
