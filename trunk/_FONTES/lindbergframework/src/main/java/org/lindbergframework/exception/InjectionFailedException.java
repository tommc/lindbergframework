package org.lindbergframework.exception;

import java.util.List;

/**
 * Auto bean injection failed.
 * 
 * @author Victor Lindberg
 *
 */
public class InjectionFailedException extends InjectionDependencyException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

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
