package org.lindbergframework.test.beans;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IValidation;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationString1 implements IValidation<String>{

    public ValidationString1() {
        //
    }
    
    public void validate(String obj) throws ValidationException {
        if (obj != null && ! obj.equals("test"))
            throw new ValidationException();
    }
}
