package org.lindbergframework.validation.impl;

import java.util.List;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IListValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa��o de valida��o de lista que verifica se a lista n�o esta vazia
 * 
 * @author Victor Lindberg
 *
 */
@Component("notEmptyListValidacao")
public class NotEmptyListValidation implements IListValidation<Object>{
	
	public void validate(List<Object> lista) throws ValidationException {
	   if (lista != null && lista.isEmpty())
		   throw new ValidationException("Valida��o not empty list falhou");
	}

}
