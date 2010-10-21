package org.lindbergframework.exception;

import java.util.List;

/**
 * Exception is thrown when a query should return one row returned more than one row.
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *
 */
public class NonUniqueRowException extends LindbergException{
    
    private static final long serialVersionUID = 1L;

    public NonUniqueRowException() {
        //
    }

    public NonUniqueRowException(String msg) {
        super(msg);
    }

    public NonUniqueRowException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NonUniqueRowException(Throwable cause) {
        super(cause);
    }

    public NonUniqueRowException(List<String> msgs) {
        super(msgs);
    }

    public NonUniqueRowException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }


}
