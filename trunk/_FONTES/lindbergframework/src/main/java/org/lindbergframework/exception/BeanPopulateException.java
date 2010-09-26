package org.lindbergframework.exception;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class BeanPopulateException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public BeanPopulateException() {
		//
	}

	public BeanPopulateException(String msg) {
		super(msg);
	}

	public BeanPopulateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BeanPopulateException(Throwable cause) {
		super(cause);
	}

	
}
