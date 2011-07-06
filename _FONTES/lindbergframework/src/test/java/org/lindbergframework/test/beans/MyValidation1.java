package org.lindbergframework.test.beans;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IValidation;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class MyValidation1 implements IValidation<String>{

    /**
     * Construtor padrão.
     */
    public MyValidation1() {
        //
    }
    
    public void validate(String string) throws ValidationException {
        if (string == null || ! string.equals("abc"))
           throw new ValidationException("msg3");
    }
}
