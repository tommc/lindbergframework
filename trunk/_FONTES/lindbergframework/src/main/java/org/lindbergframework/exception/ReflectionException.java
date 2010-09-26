package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ReflectionException extends LindbergException{

	
	private static final long serialVersionUID = 1L;

	public ReflectionException() {
		//
	}

	public ReflectionException(String msg) {
		super(msg);
	}

	public ReflectionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ReflectionException(Throwable cause) {
		super(cause);
	}

	public ReflectionException(List<String> msgs) {
		super(msgs);
	}

	public ReflectionException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

	
}
