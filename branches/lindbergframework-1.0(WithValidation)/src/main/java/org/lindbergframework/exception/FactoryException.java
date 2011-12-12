package org.lindbergframework.exception;

import java.util.List;

/**
 * Factories exception.
 * 
 * @author Victor Lindberg
 *
 */
public class FactoryException extends BeanException{
	
	private static final long serialVersionUID = 1L;

    public FactoryException() {
        //
    }

    public FactoryException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public FactoryException(List<String> msgs) {
        super(msgs);
    }

    public FactoryException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public FactoryException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public FactoryException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
