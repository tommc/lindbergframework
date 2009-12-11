package org.lindbergframework.validation.impl;

import java.util.List;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IListValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementação de validação de lista que verifica se a lista não esta vazia
 * 
 * @author Victor Lindberg
 *
 */
@Component("notEmptyListValidation")
@Scope("prototype")
public class NotEmptyListValidation implements IListValidation<Object>{
	
	public void validate(List<Object> lista) throws ValidationException {
	   if (lista != null && lista.isEmpty())
		   throw new ValidationException("Validação not empty list falhou");
	}

}
