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

	public NoSuchBeanValidationException(String msg) {
		super(msg);
	}

	public NoSuchBeanValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBeanValidationException(Throwable cause) {
		super(cause);
	}

	public NoSuchBeanValidationException(List<String> msgs) {
		super(msgs);
	}

	public NoSuchBeanValidationException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
