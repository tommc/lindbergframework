package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IValidation;
import org.lindbergframework.validation.Types;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Validação de campo que não permite informação vazia. <br> 
 * Esta validação não verifica se o campo é requerido ou não
 * 
 * @author Victor Lindberg
 *
 */
@Component(Types.NO_INFORMATION_EMPTY)
@Scope("prototype")
public class DoesNotAllowInformationEmptyValidation implements IValidation<Object>{
	
	public void validate(Object objeto) throws ValidationException {
	   	if (objeto != null && objeto.toString().trim().length() == 0)
	   		throw new ValidationException("Campo não permite informação vazia");
	}

}
