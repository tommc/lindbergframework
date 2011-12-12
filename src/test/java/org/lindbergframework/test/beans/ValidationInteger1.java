package org.lindbergframework.test.beans;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IValidation;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationInteger1 implements IValidation<Integer>{

    public ValidationInteger1() {
        //
    }
    
    public void validate(Integer obj) throws ValidationException {
        if (obj != null && obj != 13)
            throw new ValidationException();
    }
}
