package org.lindbergframework.exception;

import java.util.List;

/**
 * Exceção indicando o estado inválido de uma validação
 * 
 * @author Victor Lindberg
 *
 */
public class IllegalStateValidationException extends ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalStateValidationException() {
		//
	}

	public IllegalStateValidationException(String msg) {
		super(msg);
	}

	public IllegalStateValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public IllegalStateValidationException(Throwable cause) {
		super(cause);
	}

	public IllegalStateValidationException(List<String> msgs) {
		super(msgs);
	}

	public IllegalStateValidationException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

	
	
}
