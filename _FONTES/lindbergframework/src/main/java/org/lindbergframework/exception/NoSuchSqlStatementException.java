package org.lindbergframework.exception;

/**
 * Sql statement not found in lindberg persistence context.
 * 
 * @author Victor Lindberg
 *
 */
public class NoSuchSqlStatementException extends NoSuchSqlCommandException{
	
	private static final long serialVersionUID = 1L;

	public NoSuchSqlStatementException() {
		//
	}
	
	public NoSuchSqlStatementException(String msg) {
		super(msg);
	}

	public NoSuchSqlStatementException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSqlStatementException(Throwable cause) {
		super(cause);
	}

}
