package org.lindbergframework.exception;

/**
 * Sql procedure not found in lindberg persistence context.
 * 
 * @author Victor Lindberg
 *
 */
public class NoSuchSqlProcedureException extends NoSuchSqlCommandException{
	
	private static final long serialVersionUID = 1L;

	public NoSuchSqlProcedureException() {
		//
	}
	
	public NoSuchSqlProcedureException(String msg) {
		super(msg);
	}

	public NoSuchSqlProcedureException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSqlProcedureException(Throwable cause) {
		super(cause);
	}

}
