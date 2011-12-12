package org.lindbergframework.exception;

import java.util.List;

/**
 * Field validation value is inaccessible.
 * 
 * @author Victor Lindberg
 * 
 */
public class FieldValueInaccessibleValidationException extends ValidationException {

	private static final long serialVersionUID = 1L;

	public FieldValueInaccessibleValidationException() {
		//
	}

    public FieldValueInaccessibleValidationException(List<String> msgs,
        Throwable cause) {
        super(msgs, cause);
    }

    public FieldValueInaccessibleValidationException(List<String> msgs) {
        super(msgs);
    }

    public FieldValueInaccessibleValidationException(String msg,
        String... causeMessages) {
        super(msg, causeMessages);
    }

    public FieldValueInaccessibleValidationException(String msg,
        Throwable cause, String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public FieldValueInaccessibleValidationException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
