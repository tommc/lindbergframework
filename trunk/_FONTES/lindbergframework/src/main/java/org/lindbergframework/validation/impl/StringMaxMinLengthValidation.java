package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.AbstractMaxMinLengthRequiredValidation;
import org.lindbergframework.validation.Types;
import org.lindbergframework.validation.factory.ValidationFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Validação que verifica comprimento máximo possível de String's
 * 
 * @author Victor Lindberg
 *
 */
@Component(Types.STRING_MAX_LENGTH)
@Scope("prototype")
public class StringMaxMinLengthValidation extends AbstractMaxMinLengthRequiredValidation<String>{
	
	
	public StringMaxMinLengthValidation(){
		//
	}
	
	public StringMaxMinLengthValidation(int minLengthRequired, int maxLengthRequired) {
		super(minLengthRequired,maxLengthRequired);
	}

	public void validate(String str) throws ValidationException {
	   if (str != null && (str.length() > getMaxLengthRequired() || str.length() < getMinLengthRequired()))
		   throw new ValidationException("Comprimento da string é inválido");
	}
	
	
}
