package org.lindbergframework.exception;

import java.util.List;

/**
 * Factories exception.
 * 
 * @author Victor Lindberg
 *
 */
public class FactoryException extends BeanException{
	
	private static final long serialVersionUID = 1L;

	public FactoryException() {
		//
	}
	
	public FactoryException(String msg) {
		super(msg);
	}

	public FactoryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FactoryException(Throwable cause) {
		super(cause);
	}

	public FactoryException(List<String> msgs) {
		super(msgs);
	}

	public FactoryException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
