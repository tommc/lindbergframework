package org.lindbergframework.exception;

import java.util.List;

/**
 * Persistence Transaction failed. 
 * 
 * @author Victor Lindberg
 *
 */
public class TransactionFailureException extends TransactionException{
	
	private static final long serialVersionUID = 1L;

	public TransactionFailureException() {
		//
	}

    public TransactionFailureException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public TransactionFailureException(List<String> msgs) {
        super(msgs);
    }

    public TransactionFailureException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public TransactionFailureException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public TransactionFailureException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	


}
