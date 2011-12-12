package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IRequiredFieldValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementação de validação de campo requerido. Esta validação permite informação vazia <br>
 * ou seja sequencia de caracteres espaço. Validar não permitindo informação <br>
 * vazia use {@link RequiredFieldDoesNotAllowInformationEmpty}
 * 
 * 
 * @author Victor Lindberg
 *
 */
@Component("requiredFieldValidation")
@Scope("prototype")
public class RequiredFieldValidation implements IRequiredFieldValidation 
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
