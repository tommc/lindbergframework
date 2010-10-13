package org.lindbergframework.exception;

import java.util.List;

/**
 * Core module exception.
 * 
 * @author Victor Lindberg
 *
 */
public class CoreException extends LindbergException{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CoreException() {
        //
    }

    public CoreException(String msg) {
        super(msg);
    }

    public CoreException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CoreException(Throwable cause) {
        super(cause);
    }

    public CoreException(List<String> msgs) {
        super(msgs);
    }

    public CoreException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

}
