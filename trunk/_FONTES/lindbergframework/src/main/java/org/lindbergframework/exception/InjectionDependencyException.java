package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class InjectionDependencyException extends BeanException{
	
	public InjectionDependencyException() {
		//
	}
	
	public InjectionDependencyException(String msg) {
		super(msg);
	}

	public InjectionDependencyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InjectionDependencyException(Throwable cause) {
		super(cause);
	}

	public InjectionDependencyException(List<String> msgs) {
		super(msgs);
	}

	public InjectionDependencyException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
