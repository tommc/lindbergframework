package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class IllegalStateContextException extends LindbergException{
    
    private static final long serialVersionUID = 1L;

    public IllegalStateContextException() {
        //
    }

    public IllegalStateContextException(String msg) {
        super(msg);
    }

    public IllegalStateContextException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public IllegalStateContextException(Throwable cause) {
        super(cause);
    }

    public IllegalStateContextException(List<String> msgs) {
        super(msgs);
    }

    public IllegalStateContextException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }


}
