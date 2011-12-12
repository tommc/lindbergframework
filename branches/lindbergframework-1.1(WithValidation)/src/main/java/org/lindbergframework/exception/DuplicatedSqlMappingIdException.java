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

    public DuplicatedSqlMappingIdException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public DuplicatedSqlMappingIdException(List<String> msgs) {
        super(msgs);
    }

    public DuplicatedSqlMappingIdException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public DuplicatedSqlMappingIdException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public DuplicatedSqlMappingIdException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
