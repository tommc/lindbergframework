package br.com.lindbergframework.validation;

import br.com.lindbergframework.exception.ValidationException;

/**
 * 
 * @author Victor Lindebrg
 *
 * @param <E>
 */
public interface IValidation<E> {

    /**
     * 
     * @param objeto
     * 
     */
	public void validate(E objeto) throws ValidationException;
	
}
