package org.lindbergframework.exception;

import java.util.List;

/**
 * Core module exception.
 * 
 * @author Victor Lindberg
 *
 */
public class CoreException extends LindbergException{
    
    private static final long serialVersionUID = 1L;

    public CoreException() {
        //
    }

    public CoreException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public CoreException(List<String> msgs) {
        super(msgs);
    }

    public CoreException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public CoreException(String msg, Throwable cause, String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public CoreException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

    

}
