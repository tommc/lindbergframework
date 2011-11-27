package org.lindbergframework.exception;

import java.util.List;


/**
 * Bean population failed.
 * 
 * @author Victor Lindberg
 *
 */
public class BeanPopulateException extends LindbergException{
	
	private static final long serialVersionUID = 1L;

    public BeanPopulateException() {
    }

    public BeanPopulateException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public BeanPopulateException(List<String> msgs) {
        super(msgs);
    }

    public BeanPopulateException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public BeanPopulateException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public BeanPopulateException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	
}
