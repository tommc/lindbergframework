package org.lindbergframework.exception;

import java.util.List;

/**
 * Configuration is not valid exception.
 * 
 * @author Victor Lindberg
 *
 */
public class InvalidConfigurationException extends ConfigurationException{
	
	private static final long serialVersionUID = 1L;

    public InvalidConfigurationException() {
    }

    public InvalidConfigurationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public InvalidConfigurationException(List<String> msgs) {
        super(msgs);
    }

    public InvalidConfigurationException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public InvalidConfigurationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public InvalidConfigurationException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
