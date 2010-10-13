package org.lindbergframework.exception;

import java.util.List;

/**
 * Class cast exception for validation argument.
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationClassCastException extends ServiceException {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationClassCastException() {
		//
	}

	public ValidationClassCastException(String msg) {
		super(msg);
	}

	public ValidationClassCastException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ValidationClassCastException(Throwable cause) {
		super(cause);
	}

	public ValidationClassCastException(List<String> msgs) {
		super(msgs);
	}

	public ValidationClassCastException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
