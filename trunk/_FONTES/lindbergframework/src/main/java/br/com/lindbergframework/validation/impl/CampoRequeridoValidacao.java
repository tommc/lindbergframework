package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.ICampoRequeridoValidacao;

/**
 * Validador de campo requerido
 * 
 * 
 * @author Victor Lindberg
 *
 */
@Component("campoRequeridoValidacao")
public class CampoRequeridoValidacao implements ICampoRequeridoValidacao 
{

	/**
	 * valida campo requerido
	 */
	public void validate(Object valor) throws ValidationException 
	{
       if (valor == null || valor.toString().length() == 0)
    	   throw new ValidationException("Campo requerido");
	}

}
