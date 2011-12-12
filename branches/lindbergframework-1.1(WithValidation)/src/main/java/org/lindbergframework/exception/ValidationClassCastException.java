package org.lindbergframework.exception;

import java.util.List;

/**
 * Class cast exception for validation argument.
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationClassCastException extends BusinessException {
 
	private static final long serialVersionUID = 1L;

	public ValidationClassCastException() {
		//
	}

    public ValidationClassCastException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public ValidationClassCastException(List<String> msgs) {
        super(msgs);
    }

    public ValidationClassCastException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public ValidationClassCastException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public ValidationClassCastException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
