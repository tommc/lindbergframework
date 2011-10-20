package org.lindbergframework.exception;

import java.util.List;

/**
 * Lindberg persistence exception.
 * 
 * @author Victor Lindberg
 * 
 */
public class PersistenceException extends LindbergException {

	private static final long serialVersionUID = 1L;

	public PersistenceException() {
		//
	}

    public PersistenceException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public PersistenceException(List<String> msgs) {
        super(msgs);
    }

    public PersistenceException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public PersistenceException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public PersistenceException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
