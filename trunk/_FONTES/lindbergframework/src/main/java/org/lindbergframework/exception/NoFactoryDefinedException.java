package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class NoFactoryDefinedException extends FactoryException{
	
	public NoFactoryDefinedException() {
		//
	}
	
	public NoFactoryDefinedException(String msg) {
		super(msg);
	}

	public NoFactoryDefinedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoFactoryDefinedException(Throwable cause) {
		super(cause);
	}

	public NoFactoryDefinedException(List<String> msgs) {
		super(msgs);
	}

	public NoFactoryDefinedException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
