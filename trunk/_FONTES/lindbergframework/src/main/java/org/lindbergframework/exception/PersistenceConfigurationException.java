package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class PersistenceConfigurationException extends PersistenceException{
	
	public PersistenceConfigurationException() {
		//
	}

	public PersistenceConfigurationException(String msg) {
		super(msg);
	}

	public PersistenceConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PersistenceConfigurationException(Throwable cause) {
		super(cause);
	}

	public PersistenceConfigurationException(List<String> msgs) {
		super(msgs);
	}

	public PersistenceConfigurationException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
