package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class BeanNotFoundException extends BeanException{
	
	private static final long serialVersionUID = 1L;

	public BeanNotFoundException() {
		//
	}
	
	public BeanNotFoundException(String msg) {
		super(msg);
	}

	public BeanNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BeanNotFoundException(Throwable cause) {
		super(cause);
	}

	public BeanNotFoundException(List<String> msgs) {
		super(msgs);
	}

	public BeanNotFoundException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
