package org.lindbergframework.exception;

import java.util.List;

/**
 * Sql mapping exception.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlMappingException extends PersistenceException{
	
	private static final long serialVersionUID = 1L;

	public SqlMappingException() {
		//
	}

	public SqlMappingException(String msg) {
		super(msg);
	}

	public SqlMappingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SqlMappingException(Throwable cause) {
		super(cause);
	}

	public SqlMappingException(List<String> msgs) {
		super(msgs);
	}

	public SqlMappingException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
