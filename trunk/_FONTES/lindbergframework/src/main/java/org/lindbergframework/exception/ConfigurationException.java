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
	
	public ConfigurationException(String msg) {
		super(msg);
	}

	public ConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ConfigurationException(Throwable cause) {
		super(cause);
	}

	public ConfigurationException(List<String> msgs) {
		super(msgs);
	}

	public ConfigurationException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
