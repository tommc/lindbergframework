package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class MappingFailedException extends BeanException{
	
	public MappingFailedException () {
		//
	}

	public MappingFailedException (String msg) {
		super(msg);
	}

	public MappingFailedException (String msg, Throwable cause) {
		super(msg, cause);
	}

	public MappingFailedException (Throwable cause) {
		super(cause);
	}

	public MappingFailedException (List<String> msgs) {
		super(msgs);
	}

	public MappingFailedException (List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
