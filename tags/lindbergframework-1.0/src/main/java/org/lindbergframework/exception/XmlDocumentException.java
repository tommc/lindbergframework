package org.lindbergframework.exception;

import java.util.List;

/**
 * Xml configuration is not valid.
 * 
 * @author Victor Lindberg
 *
 */
public class XmlDocumentException extends ConfigurationException{
	
	private static final long serialVersionUID = 1L;

	public XmlDocumentException() {
		//
	}

    public XmlDocumentException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public XmlDocumentException(List<String> msgs) {
        super(msgs);
    }

    public XmlDocumentException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public XmlDocumentException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public XmlDocumentException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }
	
	

}
