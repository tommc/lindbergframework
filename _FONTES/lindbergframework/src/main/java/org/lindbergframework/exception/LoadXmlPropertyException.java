package org.lindbergframework.exception;

import java.util.List;


/**
 * Loading xml configuration property exception.
 * 
 * @author Victor Lindberg
 *
 */
public class LoadXmlPropertyException extends XmlDocumentException{

	
	private static final long serialVersionUID = 1L;

    public LoadXmlPropertyException() {
		//
	}

    public LoadXmlPropertyException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public LoadXmlPropertyException(List<String> msgs) {
        super(msgs);
    }

    public LoadXmlPropertyException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public LoadXmlPropertyException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public LoadXmlPropertyException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

	

}
