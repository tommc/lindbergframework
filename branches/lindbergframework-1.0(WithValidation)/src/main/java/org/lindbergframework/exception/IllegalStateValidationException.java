package org.lindbergframework.exception;

import java.util.List;

/**
 * Validation state is not valid.
 * 
 * @author Victor Lindberg
 *
 */
public class IllegalStateValidationException extends BusinessException{

	private static final long serialVersionUID = 1L;

	public IllegalStateValidationException() {
		//
	}

    public IllegalStateValidationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public IllegalStateValidationException(List<String> msgs) {
        super(msgs);
    }

    public IllegalStateValidationException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public IllegalStateValidationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public IllegalStateValidationException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

		
	
}
