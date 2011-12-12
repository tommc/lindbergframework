package org.lindbergframework.exception;

import java.util.List;


/**
 * Sql command not found in lindberg persistence context.
 * 
 * @author Victor Lindberg
 *
 */
public class NoSuchSqlCommandException extends LindbergException{
	
	private static final long serialVersionUID = 1L;

    public NoSuchSqlCommandException() {
    }

    public NoSuchSqlCommandException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public NoSuchSqlCommandException(List<String> msgs) {
        super(msgs);
    }

    public NoSuchSqlCommandException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public NoSuchSqlCommandException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public NoSuchSqlCommandException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
