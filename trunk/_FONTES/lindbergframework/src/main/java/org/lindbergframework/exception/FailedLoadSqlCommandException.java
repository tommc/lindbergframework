package org.lindbergframework.exception;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class FailedLoadSqlCommandException extends RuntimeException{
	
   private static final long serialVersionUID = 1L;
	
	public FailedLoadSqlCommandException() {
		//
	}
	
	public FailedLoadSqlCommandException(String msg) {
		super(msg);
	}

	public FailedLoadSqlCommandException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FailedLoadSqlCommandException(Throwable cause) {
		super(cause);
	}

}
