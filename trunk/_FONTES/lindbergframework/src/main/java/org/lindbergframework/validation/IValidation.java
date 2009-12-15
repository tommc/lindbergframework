package org.lindbergframework.validation;

import org.lindbergframework.exception.ValidationException;

/**
 * Interface que define as validações
 * 
 * @author Victor Lindebrg
 *
 * @param <E> tipo de entrada para validação
 */
public interface IValidation<E extends Object> {

    /**
     * Efetua a validação do objeto passado como argumento baseado na regra de validação implementada
     *  
     * @param objeto
     * @throws ValidationException lançada caso a validação falhe
     * 
     */
	public void validate(E objeto) throws ValidationException;
	
}
