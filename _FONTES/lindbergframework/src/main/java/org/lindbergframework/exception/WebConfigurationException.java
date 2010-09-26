package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class WebConfigurationException extends ConfigurationException{
	
	private static final long serialVersionUID = 1L;

	public WebConfigurationException() {
		//
	}
	
	public WebConfigurationException(String msg) {
		super(msg);
	}

	public WebConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public WebConfigurationException(Throwable cause) {
		super(cause);
	}

	public WebConfigurationException(List<String> msgs) {
		super(msgs);
	}

	public WebConfigurationException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
