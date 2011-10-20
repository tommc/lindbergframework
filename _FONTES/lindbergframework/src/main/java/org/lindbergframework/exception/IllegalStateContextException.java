package org.lindbergframework.exception;

import java.util.List;

/**
 * Context state is not valid.
 * 
 * @author Victor Lindberg
 *
 */
public class IllegalStateContextException extends LindbergException{
    
    private static final long serialVersionUID = 1L;

    public IllegalStateContextException() {
        //
    }

    public IllegalStateContextException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public IllegalStateContextException(List<String> msgs) {
        super(msgs);
    }

    public IllegalStateContextException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public IllegalStateContextException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public IllegalStateContextException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

    


}
