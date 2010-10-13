package org.lindbergframework.exception;

import java.util.List;

/**
 * Field not found. This exception is throwed in reflection operations.
 *  
 * @author Victor Lindberg
 *
 */
public class FieldNotFoundException extends ReflectionException{
	
	private static final long serialVersionUID = 1L;

	public FieldNotFoundException() {
		//
	}
	
	public FieldNotFoundException(String beanClassName, String field){
		super(String.format("Field %s not found in %s", field,beanClassName));
	}
	
	public FieldNotFoundException(Class beanClass, String field){
		this(beanClass.getName(),field);
	}

	public FieldNotFoundException(String msg) {
		super(msg);
	}

	public FieldNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FieldNotFoundException(Throwable cause) {
		super(cause);
	}

	public FieldNotFoundException(List<String> msgs) {
		super(msgs);
	}

	public FieldNotFoundException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
