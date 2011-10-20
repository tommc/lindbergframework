package org.lindbergframework.exception;

import java.util.List;

/**
 * Exception is thrown when a query should return one row returned more than one row.
 * 
 * @author Victor Lindberg
 *
 */
public class NonUniqueRowException extends LindbergException{
    
    private static final long serialVersionUID = 1L;

    public NonUniqueRowException() {
        //
    }

    public NonUniqueRowException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public NonUniqueRowException(List<String> msgs) {
        super(msgs);
    }

    public NonUniqueRowException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public NonUniqueRowException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public NonUniqueRowException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

    


}
