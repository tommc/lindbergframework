package org.lindbergframework.exception;


/**
 * Sql command Loading failed.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlCommandLoadingFailedException extends RuntimeException{
	
   private static final long serialVersionUID = 1L;
	
	public SqlCommandLoadingFailedException() {
		//
	}
	
	public SqlCommandLoadingFailedException(String msg) {
		super(msg);
	}

	public SqlCommandLoadingFailedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SqlCommandLoadingFailedException(Throwable cause) {
		super(cause);
	}

}
