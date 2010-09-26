package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class TransactionFailureException extends TransactionException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionFailureException() {
		//
	}

	public TransactionFailureException(String msg) {
		super(msg);
	}

	public TransactionFailureException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TransactionFailureException(Throwable cause) {
		super(cause);
	}

	public TransactionFailureException(List<String> msgs) {
		super(msgs);
	}

	public TransactionFailureException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
