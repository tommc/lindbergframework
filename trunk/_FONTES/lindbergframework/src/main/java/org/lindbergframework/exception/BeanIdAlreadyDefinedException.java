package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class BeanIdAlreadyDefinedException extends BeanException{

	
	private static final long serialVersionUID = 1L;

	public BeanIdAlreadyDefinedException() {
		//
	}
	
	public BeanIdAlreadyDefinedException(String msg) {
		super(msg);
	}

	public BeanIdAlreadyDefinedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BeanIdAlreadyDefinedException(Throwable cause) {
		super(cause);
	}

	public BeanIdAlreadyDefinedException(List<String> msgs) {
		super(msgs);
	}

	public BeanIdAlreadyDefinedException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}
	
}
