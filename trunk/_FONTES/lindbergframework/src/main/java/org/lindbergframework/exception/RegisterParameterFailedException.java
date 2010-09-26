package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class RegisterParameterFailedException extends PersistenceException{
	
	public RegisterParameterFailedException() {
		//
	}

	public RegisterParameterFailedException(String msg) {
		super(msg);
	}

	public RegisterParameterFailedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RegisterParameterFailedException(Throwable cause) {
		super(cause);
	}

	public RegisterParameterFailedException(List<String> msgs) {
		super(msgs);
	}

	public RegisterParameterFailedException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
