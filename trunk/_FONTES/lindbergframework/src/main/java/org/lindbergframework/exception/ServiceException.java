package org.lindbergframework.exception;

import java.util.List;

/**
 * Exce��o originada das classes de service/neg�cio
 * 
 * 
 * @author Victor Lindberg
 *
 */
public class ServiceException extends LindbergException
{
	
	private static final long serialVersionUID = 1L;

	public ServiceException()
	{
		//
	}
	
	public ServiceException(String msg)
	{
		super(msg);
	}

	public ServiceException(String msg, Throwable cause)
	{
		super(msg,cause);
	}

	public ServiceException(Throwable cause)
	{
		super(cause);
	}
	
	public ServiceException(List<String> msgs)
	{
	   super(msgs);
	}

	public ServiceException(List<String> msgs, Throwable cause)
	{
		super(msgs,cause);
	}
}