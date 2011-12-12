package org.lindbergframework.exception;

import java.util.List;

/**
 * Duplicated bean id in IOC context.
 * 
 * @author Victor Lindberg
 *
 */
public class BeanIdAlreadyDefinedException extends BeanException{

	
	private static final long serialVersionUID = 1L;

    public BeanIdAlreadyDefinedException() {
        //
    }

    public BeanIdAlreadyDefinedException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public BeanIdAlreadyDefinedException(List<String> msgs) {
        super(msgs);
    }

    public BeanIdAlreadyDefinedException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public BeanIdAlreadyDefinedException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public BeanIdAlreadyDefinedException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	
	
}
