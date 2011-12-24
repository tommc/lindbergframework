package org.lindbergframework.exception;

import java.util.List;

/**
 * Field validation value is inaccessible.
 * 
 * @author Victor Lindberg
 * 
 */
public class FieldValueInaccessibleException extends LindbergException {

	private static final long serialVersionUID = 1L;

	public FieldValueInaccessibleException() {
		//
	}

	public FieldValueInaccessibleException(List<String> msgs,
			Throwable cause) {
		super(msgs, cause);
	}

	public FieldValueInaccessibleException(List<String> msgs) {
		super(msgs);
	}

	public FieldValueInaccessibleException(String msg,
			String... causeMessages) {
		super(msg, causeMessages);
	}

	public FieldValueInaccessibleException(String msg,
			Throwable cause, String... causeMessages) {
		super(msg, cause, causeMessages);
	}

	public FieldValueInaccessibleException(Throwable cause,
			String... causeMessages) {
		super(cause, causeMessages);
	}

}
