package org.lindbergframework.exception;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class NoSuchSqlCommandException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoSuchSqlCommandException() {
		//
	}
	
	public NoSuchSqlCommandException(String msg) {
		super(msg);
	}

	public NoSuchSqlCommandException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSqlCommandException(Throwable cause) {
		super(cause);
	}

}
