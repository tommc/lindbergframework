package org.lindbergframework.exception;

import java.util.List;

/**
 * Bean mapping not found in the base package specified in the configuration.
 * 
 * @author Victor Lindberg
 *
 */
public class BeanMappingNotFoundException extends BeanNotFoundException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BeanMappingNotFoundException() {
		//
	}
	
	public BeanMappingNotFoundException(String msg) {
		super(msg);
	}

	public BeanMappingNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BeanMappingNotFoundException(Throwable cause) {
		super(cause);
	}

	public BeanMappingNotFoundException(List<String> msgs) {
		super(msgs);
	}

	public BeanMappingNotFoundException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
