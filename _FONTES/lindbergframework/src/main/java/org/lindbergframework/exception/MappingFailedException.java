package org.lindbergframework.exception;

import java.util.List;

/**
 * Bean Mapping exception.
 * 
 * @author Victor Lindberg
 *
 */
public class MappingFailedException extends BeanException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MappingFailedException() {
    }

    public MappingFailedException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public MappingFailedException(List<String> msgs) {
        super(msgs);
    }

    public MappingFailedException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public MappingFailedException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public MappingFailedException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

    

}
