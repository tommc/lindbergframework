package org.lindbergframework.exception;

import java.util.List;

/**
 * Persistence transactions exception.
 * 
 * @author Victor Lindberg
 *
 */
public class TransactionException extends PersistenceException{
	
	private static final long serialVersionUID = 1L;

	public TransactionException() {
		//
	}

    public TransactionException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public TransactionException(List<String> msgs) {
        super(msgs);
    }

    public TransactionException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public TransactionException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public TransactionException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	


}
