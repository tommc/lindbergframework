package br.com.lindbergframework.validation.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IListValidation;

/**
 * Implementação de validação de lista que verifica se a lista esta vazia
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
