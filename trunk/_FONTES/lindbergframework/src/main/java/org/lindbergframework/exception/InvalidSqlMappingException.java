package org.lindbergframework.exception;


/**
 * Sql mapping is not valid exception.
 * 
 * @author Victor Lindberg
 *
 */
public class InvalidSqlMappingException extends XmlDocumentException{
	
	private static final long serialVersionUID = 1L;

	public InvalidSqlMappingException() {
		//
	}
	
	public InvalidSqlMappingException(String msg) {
		super(msg);
	}

	public InvalidSqlMappingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidSqlMappingException(Throwable cause) {
		super(cause);
	}

}
