package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class XmlDocumentException extends ConfigurationException{
	
	private static final long serialVersionUID = 1L;

	public XmlDocumentException() {
		//
	}
	
	public XmlDocumentException(String msg) {
		super(msg);
	}

	public XmlDocumentException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public XmlDocumentException(Throwable cause) {
		super(cause);
	}

	public XmlDocumentException(List<String> msgs) {
		super(msgs);
	}

	public XmlDocumentException(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}

}
