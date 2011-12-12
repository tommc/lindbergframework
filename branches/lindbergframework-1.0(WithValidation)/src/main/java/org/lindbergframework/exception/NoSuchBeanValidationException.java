package org.lindbergframework.exception;

import java.util.List;

/**
 * Validation bean not found.
 * 
 * @author Victor Lindberg
 * 
 */
public class NoSuchBeanValidationException extends BeanException {

	private static final long serialVersionUID = 1L;

	public NoSuchBeanValidationException() {
		super("Bean validation not found");
	}

    public NoSuchBeanValidationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public NoSuchBeanValidationException(List<String> msgs) {
        super(msgs);
    }

    public NoSuchBeanValidationException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public NoSuchBeanValidationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public NoSuchBeanValidationException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
