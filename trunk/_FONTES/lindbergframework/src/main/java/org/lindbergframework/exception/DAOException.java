package org.lindbergframework.exception;

import java.util.List;

/**
 * Excecao nas operações de persistencia

 * @author victorsilva
 *
 */
public class DAOException extends LindbergException
{
	
	private static final long serialVersionUID = 1L;

	public DAOException()
	{
		//
	}
	
	public DAOException(String msg)
	{
		super(msg);
	}

	public DAOException(String msg, Throwable cause)
	{
		super(msg,cause);
	}

	public DAOException(Throwable cause)
	{
		super(cause);
	}
	
	public DAOException(List<String> msgs)
	{
	   super(msgs);
	}

	public DAOException(List<String> msgs, Throwable cause)
	{
		super(msgs,cause);
	}
}
