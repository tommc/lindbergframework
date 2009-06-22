package br.com.lindbergframework.validation.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.INotEmptyListValidacao;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Component("notEmptyListValidacao")
public class NotEmptyListValidacao implements INotEmptyListValidacao{
	
	public void validate(List<Object> lista) throws ValidationException {
	   if (lista != null && lista.isEmpty())
		   throw new ValidationException("Validação not empty list falhou");
	}

}
