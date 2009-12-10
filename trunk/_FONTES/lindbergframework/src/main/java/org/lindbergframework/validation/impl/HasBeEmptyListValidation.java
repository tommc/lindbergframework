package org.lindbergframework.validation.impl;

import java.util.List;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IListValidation;
import org.springframework.stereotype.Component;


/**
 * Implementa��o de valida��o de lista que verifica se a lista esta vazia
 * 
 * @author Lindberg
 *
 */
@Component("hasBeEmptyListValidation")
public class HasBeEmptyListValidation implements IListValidation<Object>{
	
	public void validate(List<Object> lista) throws ValidationException {
	   if (lista != null && ! lista.isEmpty())
		   throw new ValidationException("Lista nao esta vazia");
	}

}