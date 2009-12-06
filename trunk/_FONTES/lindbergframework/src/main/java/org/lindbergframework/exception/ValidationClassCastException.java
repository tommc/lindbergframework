package org.lindbergframework.exception;

import java.util.List;

/**
 * Exce��o lan�ada a partir da convers�o de classes nas valida��es
 * 
 * @author Victor Lindberg
 * 
 */
public class ValidationClassCastException extends ServiceException {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationClassCastException() {
		//
	}

	public ValidationClassCastException(String msg) {
		super(msg);
	}

	public ValidationClassCastException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ValidationClassCastException(Throwable cause) {
		super(cause);
	}

	public ValidationClassCastException(List<String> msgs) {
		super(msgs);
	}

	public ValidationClassCastException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
