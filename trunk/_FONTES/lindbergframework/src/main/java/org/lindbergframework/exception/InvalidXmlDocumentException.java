package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class InvalidXmlDocumentException extends XmlDocumentException{
	
	private static final long serialVersionUID = 1L;

	public InvalidXmlDocumentException() {
		//
	}
	
	public InvalidXmlDocumentException(String msg) {
		super(msg);
	}

	public InvalidXmlDocumentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidXmlDocumentException(Throwable cause) {
		super(cause);
	}

	public InvalidXmlDocumentException(List<String> msgs) {
		super(msgs);
	}

	public InvalidXmlDocumentException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
