package org.lindbergframework.exception;

import java.util.List;

/**
 * Bean not found in the IOC context.
 * 
 * @author Victor Lindberg
 *
 */
public class BeanNotFoundException extends BeanException{
	
	private static final long serialVersionUID = 1L;

    public BeanNotFoundException() {
        //
    }

    public BeanNotFoundException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public BeanNotFoundException(List<String> msgs) {
        super(msgs);
    }

    public BeanNotFoundException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public BeanNotFoundException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public BeanNotFoundException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

}
