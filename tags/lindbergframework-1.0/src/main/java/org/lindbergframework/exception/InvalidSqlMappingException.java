package org.lindbergframework.exception;

import java.util.List;


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

    public InvalidSqlMappingException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public InvalidSqlMappingException(List<String> msgs) {
        super(msgs);
    }

    public InvalidSqlMappingException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public InvalidSqlMappingException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public InvalidSqlMappingException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }
	
	

}
