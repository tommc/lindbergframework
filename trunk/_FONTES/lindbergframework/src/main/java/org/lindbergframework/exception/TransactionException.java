package org.lindbergframework.exception;

import java.util.List;

/**
 * Persistence transactions exception.
 * 
 * @author Victor Lindberg
 *
 */
public class TransactionException extends PersistenceException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionException() {
		//
	}

	public TransactionException(String msg) {
		super(msg);
	}

	public TransactionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TransactionException(Throwable cause) {
		super(cause);
	}

	public TransactionException(List<String> msgs) {
		super(msgs);
	}

	public TransactionException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
