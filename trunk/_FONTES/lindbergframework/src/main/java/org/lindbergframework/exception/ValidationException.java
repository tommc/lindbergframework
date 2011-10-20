package org.lindbergframework.exception;

import java.util.List;

/**
 * Exception from validations.
 * 
 * @author Victor Lindberg
 */
public class ValidationException extends BusinessException {
    
    private static final long serialVersionUID = 1L;

    public ValidationException() {
        //
    }

    public ValidationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public ValidationException(List<String> msgs) {
        super(msgs);
    }

    public ValidationException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public ValidationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public ValidationException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

    
}
