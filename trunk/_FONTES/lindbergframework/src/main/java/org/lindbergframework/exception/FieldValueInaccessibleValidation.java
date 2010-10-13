package org.lindbergframework.exception;

import java.util.List;

/**
 * Field validation value is inaccessible.
 * 
 * @author Victor Lindberg
 * 
 */
public class FieldValueInaccessibleValidation extends ValidationException {

	private static final long serialVersionUID = 1L;

	public FieldValueInaccessibleValidation() {
		//
	}

	public FieldValueInaccessibleValidation(String msg) {
		super(msg);
	}

	public FieldValueInaccessibleValidation(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FieldValueInaccessibleValidation(Throwable cause) {
		super(cause);
	}

	public FieldValueInaccessibleValidation(List<String> msgs) {
		super(msgs);
	}

	public FieldValueInaccessibleValidation(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
