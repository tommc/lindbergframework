package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class BeanException extends LindbergException{
	
	private static final long serialVersionUID = 1L;

	public BeanException() {
		//
	}
	
	public BeanException(String msg) {
		super(msg);
	}

	public BeanException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BeanException(Throwable cause) {
		super(cause);
	}

	public BeanException(List<String> msgs) {
		super(msgs);
	}

	public BeanException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
