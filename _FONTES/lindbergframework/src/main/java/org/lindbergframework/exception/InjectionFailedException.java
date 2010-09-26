package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class InjectionFailedException extends InjectionDependencyException{
	
	public InjectionFailedException() {
		//
	}
	
	public InjectionFailedException(String msg) {
		super(msg);
	}

	public InjectionFailedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InjectionFailedException(Throwable cause) {
		super(cause);
	}

	public InjectionFailedException(List<String> msgs) {
		super(msgs);
	}

	public InjectionFailedException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
