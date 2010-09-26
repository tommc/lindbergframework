package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LoadXmlPropertyException extends XmlDocumentException{
	
	private static final long serialVersionUID = 1L;

	public LoadXmlPropertyException() {
		//
	}
	
	public LoadXmlPropertyException(String msg) {
		super(msg);
	}

	public LoadXmlPropertyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LoadXmlPropertyException(Throwable cause) {
		super(cause);
	}

	public LoadXmlPropertyException(List<String> msgs) {
		super(msgs);
	}

	public LoadXmlPropertyException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
