package org.lindbergframework.exception;

import java.util.List;

/**
 * Duplicated sql mapping id in lindberg persistence context.
 * 
 * @author Victor Lindberg
 *
 */
public class DuplicatedSqlMappingIdException extends SqlMappingException{
	
	private static final long serialVersionUID = 1L;

	public DuplicatedSqlMappingIdException() {
		//
	}

	public DuplicatedSqlMappingIdException(String msg) {
		super(msg);
	}

	public DuplicatedSqlMappingIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicatedSqlMappingIdException(Throwable cause) {
		super(cause);
	}

	public DuplicatedSqlMappingIdException(List<String> msgs) {
		super(msgs);
	}

	public DuplicatedSqlMappingIdException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
