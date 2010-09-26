package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class CoreException extends LindbergException{
    
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
