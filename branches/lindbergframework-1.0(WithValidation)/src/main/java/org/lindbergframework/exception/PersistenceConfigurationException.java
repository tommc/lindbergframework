package org.lindbergframework.exception;

import java.util.List;

/**
 * Lindberg persistence configuration exception.
 * 
 * @author Victor Lindberg
 *
 */
public class PersistenceConfigurationException extends PersistenceException{
	
	private static final long serialVersionUID = 1L;

    public PersistenceConfigurationException() {
		//
	}

    public PersistenceConfigurationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public PersistenceConfigurationException(List<String> msgs) {
        super(msgs);
    }

    public PersistenceConfigurationException(String msg,
        String... causeMessages) {
        super(msg, causeMessages);
    }

    public PersistenceConfigurationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public PersistenceConfigurationException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	


}
