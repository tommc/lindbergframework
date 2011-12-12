package org.lindbergframework.exception;

import java.util.List;

/**
 * Lindberg web configuration excpetion.
 * 
 * @author Victor Lindberg
 *
 */
public class WebConfigurationException extends ConfigurationException{
	
	private static final long serialVersionUID = 1L;

	public WebConfigurationException() {
		//
	}

    public WebConfigurationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public WebConfigurationException(List<String> msgs) {
        super(msgs);
    }

    public WebConfigurationException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public WebConfigurationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public WebConfigurationException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }
	
	


}
