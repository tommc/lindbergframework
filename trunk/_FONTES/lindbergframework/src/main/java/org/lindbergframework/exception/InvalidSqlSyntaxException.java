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
    
    public InvalidSqlSyntaxException(String msg) {
        super(msg);
    }

    public InvalidSqlSyntaxException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidSqlSyntaxException(Throwable cause) {
        super(cause);
    }

    public InvalidSqlSyntaxException(List<String> msgs) {
        super(msgs);
    }

    public InvalidSqlSyntaxException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }
}
