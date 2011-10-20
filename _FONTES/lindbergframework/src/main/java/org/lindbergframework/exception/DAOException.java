package org.lindbergframework.exception;

import java.util.List;

/**
 * Data access layer exception.
 * 
 * @author Victor Lindberg
 *
 */
public class DAOException extends PersistenceException {
 
	private static final long serialVersionUID = 1L;

	public DAOException() {
		//
	}

    public DAOException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public DAOException(List<String> msgs) {
        super(msgs);
    }

    public DAOException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public DAOException(String msg, Throwable cause, String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public DAOException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	
}
