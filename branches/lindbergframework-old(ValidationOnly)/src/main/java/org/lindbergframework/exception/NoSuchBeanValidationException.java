package org.lindbergframework.exception;

import java.util.List;

/**
 * Exception que indica a não possibilidade de encontrar uma validação específica
 * 
 * @author Victor Lindberg
 *
 */
public class NoSuchBeanValidationException extends LindbergException {
	
	private static final long serialVersionUID = 1L;

	public NoSuchBeanValidationException()	{
		super("Bean de validação especificado não encontrado");
	}
	
	public NoSuchBeanValidationException(String msg)
	{
		super(msg);
	}

	public NoSuchBeanValidationException(String msg, Throwable cause)
	{
		super(msg,cause);
	}

	public NoSuchBeanValidationException(Throwable cause)
	{
		super(cause);
	}
	
	public NoSuchBeanValidationException(List<String> msgs)
	{
	   super(msgs);
	}

	public NoSuchBeanValidationException(List<String> msgs, Throwable cause)
	{
		super(msgs,cause);
	}


}
