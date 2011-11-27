package org.lindbergframework.exception;

import java.util.List;

/**
 * Sql command Loading failed.
 * @author Victor Lindberg
 */
public class SqlCommandLoadingFailedException extends LindbergException {

    private static final long serialVersionUID = 1L;

    public SqlCommandLoadingFailedException() {
    }

    public SqlCommandLoadingFailedException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public SqlCommandLoadingFailedException(List<String> msgs) {
        super(msgs);
    }

    public SqlCommandLoadingFailedException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public SqlCommandLoadingFailedException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public SqlCommandLoadingFailedException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

}
