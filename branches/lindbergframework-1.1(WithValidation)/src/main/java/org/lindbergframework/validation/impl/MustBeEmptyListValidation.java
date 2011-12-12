package org.lindbergframework.validation.impl;

import java.util.List;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IListValidation;
import org.lindbergframework.validation.Types;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementação de validação de lista que verifica se a lista esta vazia
 * 
 * @author Victor Lindberg
 *
 */
@Component(Types.MUST_BE_EMPTY_LIST)
@Scope("prototype")
public class MustBeEmptyListValidation implements IListValidation<Object>{
	
	public void validate(List<Object> lista) throws ValidationException {
	   if (lista != null && ! lista.isEmpty())
		   throw new ValidationException("Lista não esta vazia");
	}

}
