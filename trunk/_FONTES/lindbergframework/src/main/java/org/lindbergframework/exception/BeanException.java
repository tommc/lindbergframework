package org.lindbergframework.exception;

import java.util.List;

/**
 * Bean exception.
 * 
 * @author Victor Lindberg
 *
 */
public class BeanException extends LindbergException{
	
	private static final long serialVersionUID = 1L;

    public BeanException() {
        //
    }

    public BeanException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public BeanException(List<String> msgs) {
        super(msgs);
    }

    public BeanException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public BeanException(String msg, Throwable cause, String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public BeanException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

}
