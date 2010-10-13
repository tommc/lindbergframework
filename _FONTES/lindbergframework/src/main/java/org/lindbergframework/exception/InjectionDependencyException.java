package org.lindbergframework.exception;

import java.util.List;

/**
 * Injection dependency container exception.
 * 
 * @author Victor Lindberg
 *
 */
public class InjectionDependencyException extends BeanException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

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
