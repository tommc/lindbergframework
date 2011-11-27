package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class IllegalParameterException extends PersistenceException{

    /**
     * Construtor padrão.
     */
    public IllegalParameterException() {
        //
    }

    public IllegalParameterException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public IllegalParameterException(List<String> msgs) {
        super(msgs);
    }

    public IllegalParameterException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public IllegalParameterException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public IllegalParameterException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }
}
