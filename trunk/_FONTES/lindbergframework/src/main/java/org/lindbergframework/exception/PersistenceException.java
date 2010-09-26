package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class PersistenceException extends LindbergException {

	private static final long serialVersionUID = 1L;

	public PersistenceException() {
		//
	}

	public PersistenceException(String msg) {
		super(msg);
	}

	public PersistenceException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PersistenceException(Throwable cause) {
		super(cause);
	}

	public PersistenceException(List<String> msgs) {
		super(msgs);
	}

	public PersistenceException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
