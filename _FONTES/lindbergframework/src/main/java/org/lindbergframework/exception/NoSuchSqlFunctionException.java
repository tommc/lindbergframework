package org.lindbergframework.exception;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class NoSuchSqlFunctionException extends NoSuchSqlProcedureException{
	
	private static final long serialVersionUID = 1L;

	public NoSuchSqlFunctionException() {
		//
	}
	
	public NoSuchSqlFunctionException(String msg) {
		super(msg);
	}

	public NoSuchSqlFunctionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSqlFunctionException(Throwable cause) {
		super(cause);
	}

}
