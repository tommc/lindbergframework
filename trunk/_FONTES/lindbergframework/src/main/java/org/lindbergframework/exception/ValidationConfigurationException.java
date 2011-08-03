package org.lindbergframework.exception;

import java.util.List;

/**
 * Lindberg validation configuration exception.
 * 
 * @author Victor Lindberg
 *
 */
public class ValidationConfigurationException extends PersistenceException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ValidationConfigurationException() {
		//
	}

	public ValidationConfigurationException(String msg) {
		super(msg);
	}

	public ValidationConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ValidationConfigurationException(Throwable cause) {
		super(cause);
	}

	public ValidationConfigurationException(List<String> msgs) {
		super(msgs);
	}

	public ValidationConfigurationException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
