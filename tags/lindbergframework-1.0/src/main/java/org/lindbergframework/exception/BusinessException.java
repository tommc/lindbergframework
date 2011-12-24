package org.lindbergframework.exception;

import java.util.List;

/**
 * Exception launched from business layer.
 * 
 * @author Victor Lindberg
 */
public class BusinessException extends LindbergException {

    private static final long serialVersionUID = 1L;

    public BusinessException() {
        //
    }

    public BusinessException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public BusinessException(List<String> msgs) {
        super(msgs);
    }

    public BusinessException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public BusinessException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public BusinessException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

   
}
