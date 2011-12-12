package org.lindbergframework.exception;

import java.util.List;

/**
 * Lindberg validation configuration exception.
 * 
 * @author Victor Lindberg
 *
 */
public class ValidationConfigurationException extends ConfigurationException{
	
	private static final long serialVersionUID = 1L;

    public ValidationConfigurationException() {
		//
	}

    public ValidationConfigurationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public ValidationConfigurationException(List<String> msgs) {
        super(msgs);
    }

    public ValidationConfigurationException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public ValidationConfigurationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public ValidationConfigurationException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	


}
