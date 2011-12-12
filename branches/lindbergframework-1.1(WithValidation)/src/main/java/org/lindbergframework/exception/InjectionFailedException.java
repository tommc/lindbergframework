package org.lindbergframework.exception;

import java.util.List;

/**
 * Auto bean injection failed.
 * 
 * @author Victor Lindberg
 *
 */
public class InjectionFailedException extends InjectionDependencyException{
	
    private static final long serialVersionUID = 1L;

    public InjectionFailedException() {
        //
    }

    public InjectionFailedException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public InjectionFailedException(List<String> msgs) {
        super(msgs);
    }

    public InjectionFailedException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public InjectionFailedException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public InjectionFailedException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

    

}
