package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class InvalidSqlSyntaxException extends LindbergException{

    private static final long serialVersionUID = 1L;

    public InvalidSqlSyntaxException() {
        //
    }

    public InvalidSqlSyntaxException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public InvalidSqlSyntaxException(List<String> msgs) {
        super(msgs);
    }

    public InvalidSqlSyntaxException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public InvalidSqlSyntaxException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public InvalidSqlSyntaxException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }
    
    
}
