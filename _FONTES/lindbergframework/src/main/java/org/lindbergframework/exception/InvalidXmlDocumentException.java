package org.lindbergframework.exception;

import java.util.List;

/**
 * Xml document is not valid.
 * 
 * @author Victor Lindberg
 *
 */
public class InvalidXmlDocumentException extends XmlDocumentException{
	
	private static final long serialVersionUID = 1L;

	public InvalidXmlDocumentException() {
		//
	}

    public InvalidXmlDocumentException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public InvalidXmlDocumentException(List<String> msgs) {
        super(msgs);
    }

    public InvalidXmlDocumentException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public InvalidXmlDocumentException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public InvalidXmlDocumentException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }
	
	

}
