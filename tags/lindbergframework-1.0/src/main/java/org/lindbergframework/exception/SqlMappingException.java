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

    public SqlMappingException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public SqlMappingException(List<String> msgs) {
        super(msgs);
    }

    public SqlMappingException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public SqlMappingException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public SqlMappingException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
