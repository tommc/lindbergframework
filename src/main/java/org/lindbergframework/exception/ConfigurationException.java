package org.lindbergframework.exception;

import java.util.List;

/**
 * Configuration failed.
 * 
 * @author Victor Lindberg
 *
 */
public class ConfigurationException extends LindbergException{
	
	private static final long serialVersionUID = 1L;

	public ConfigurationException() {
		//
	}

    public ConfigurationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public ConfigurationException(List<String> msgs) {
        super(msgs);
    }

    public ConfigurationException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public ConfigurationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public ConfigurationException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }
	
	


}
