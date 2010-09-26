package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class BeanMappingNotFoundException extends BeanNotFoundException{
	
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
