package org.lindbergframework.exception;

import java.util.List;

/**
 * Registry of parameter from procedure or function failed.
 * 
 * @author Victor Lindberg
 *
 */
public class RegisterParameterProceduresAndFunctionsFailedException extends PersistenceException{
	
	private static final long serialVersionUID = 1L;

    public RegisterParameterProceduresAndFunctionsFailedException() {
		//
	}

    public RegisterParameterProceduresAndFunctionsFailedException(
        List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public RegisterParameterProceduresAndFunctionsFailedException(
        List<String> msgs) {
        super(msgs);
    }

    public RegisterParameterProceduresAndFunctionsFailedException(String msg,
        String... causeMessages) {
        super(msg, causeMessages);
    }

    public RegisterParameterProceduresAndFunctionsFailedException(String msg,
        Throwable cause, String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public RegisterParameterProceduresAndFunctionsFailedException(
        Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	


}
