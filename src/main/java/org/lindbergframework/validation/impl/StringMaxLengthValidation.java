package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.AbstractMaxLengthRequiredValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Validação que verifica comprimento máximo possível de String's
 * 
 * @author Victor Lindberg
 *
 */
@Component("stringMaxLengthValidation")
@Scope("prototype")
public class StringMaxLengthValidation extends AbstractMaxLengthRequiredValidation<String>{
	
	
	public StringMaxLengthValidation(){
		//
	}
	
	public StringMaxLengthValidation(int maxLengthRequired) {
		super(maxLengthRequired);
	}

	public void validate(String str) throws ValidationException {
	   if (str != null && str.length() > getMaxLengthRequired())
		   throw new ValidationException("Comprimento da string excede o limite");
	}
}
