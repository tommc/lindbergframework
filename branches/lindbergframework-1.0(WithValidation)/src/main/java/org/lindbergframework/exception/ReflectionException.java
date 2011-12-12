package org.lindbergframework.exception;

import java.util.List;

/**
 * Reflection operations exception.
 * 
 * @author Victor Lindberg
 *
 */
public class ReflectionException extends LindbergException{

	
	private static final long serialVersionUID = 1L;

	public ReflectionException() {
		//
	}

    public ReflectionException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public ReflectionException(List<String> msgs) {
        super(msgs);
    }

    public ReflectionException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public ReflectionException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public ReflectionException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	

	
}
