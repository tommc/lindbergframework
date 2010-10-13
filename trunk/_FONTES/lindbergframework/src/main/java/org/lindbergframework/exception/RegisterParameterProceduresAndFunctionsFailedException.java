package org.lindbergframework.exception;

import java.util.List;

/**
 * Registry of parameter from procedure or function failed.
 * 
 * @author Victor Lindberg
 *
 */
public class RegisterParameterProceduresAndFunctionsFailedException extends PersistenceException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public RegisterParameterProceduresAndFunctionsFailedException() {
		//
	}

	public RegisterParameterProceduresAndFunctionsFailedException(String msg) {
		super(msg);
	}

	public RegisterParameterProceduresAndFunctionsFailedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RegisterParameterProceduresAndFunctionsFailedException(Throwable cause) {
		super(cause);
	}

	public RegisterParameterProceduresAndFunctionsFailedException(List<String> msgs) {
		super(msgs);
	}

	public RegisterParameterProceduresAndFunctionsFailedException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
