package org.lindbergframework.validation;

import org.lindbergframework.exception.ValidationException;

/**
 * Interface que define as valida��es
 * 
 * @author Victor Lindebrg
 *
 * @param <E> tipo de entrada para valida��o
 */
public interface IValidation<E> {

    /**
     * Efetua a valida��o do objeto passado como argumento baseado na regra de valida��o implementada
     *  
     * @param objeto
     * @throws ValidationException lan�ada caso a valida��o falhe
     * 
     */
	public void validate(E objeto) throws ValidationException;
	
}
