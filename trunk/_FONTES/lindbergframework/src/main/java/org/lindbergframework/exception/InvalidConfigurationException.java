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
		//
	}
	
	public InvalidConfigurationException(String msg) {
		super(msg);
	}

	public InvalidConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidConfigurationException(Throwable cause) {
		super(cause);
	}

	public InvalidConfigurationException(List<String> msgs) {
		super(msgs);
	}

	public InvalidConfigurationException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
