package org.lindbergframework.exception;

import java.util.List;

/**
 * Bean mapping not found in the base package specified in the configuration.
 * 
 * @author Victor Lindberg
 *
 */
public class BeanMappingNotFoundException extends BeanNotFoundException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BeanMappingNotFoundException() {
    }

    public BeanMappingNotFoundException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public BeanMappingNotFoundException(List<String> msgs) {
        super(msgs);
    }

    public BeanMappingNotFoundException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public BeanMappingNotFoundException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public BeanMappingNotFoundException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

}
