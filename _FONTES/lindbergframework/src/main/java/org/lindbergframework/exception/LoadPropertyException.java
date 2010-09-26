package org.lindbergframework.exception;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class LoadPropertyException extends XmlDocumentException{

	
	public LoadPropertyException() {
		//
	}

	public LoadPropertyException(String msg) {
		super(msg);
	}

	public LoadPropertyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LoadPropertyException(Throwable cause) {
		super(cause);
	}

}
