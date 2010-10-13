package org.lindbergframework.exception;

import java.util.List;

/**
 * Exception from validations.
 * 
 * 
 * @author Victor Lindberg 
 *
 */
public class ValidationException extends ServiceException
{    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException()
	{
		//
	}
	
	public ValidationException(String msg)
	{
		super(msg);
	}

	public ValidationException(String msg, Throwable cause)
	{
		super(msg,cause);
	}

	public ValidationException(Throwable cause)
	{
		super(cause);
	}
	
	public ValidationException(List<String> msgs)
	{
	   super(msgs);
	}

	public ValidationException(List<String> msgs, Throwable cause)
	{
		super(msgs,cause);
	}
}
