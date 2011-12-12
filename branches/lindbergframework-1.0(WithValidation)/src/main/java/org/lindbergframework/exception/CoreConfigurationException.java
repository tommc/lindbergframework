package org.lindbergframework.exception;

import java.util.List;

/**
 * Core configuration exception.
 *  
 * @author Victor Lindberg
 *
 */
public class CoreConfigurationException extends CoreException{
    
    private static final long serialVersionUID = 1L;

    public CoreConfigurationException() {
        //
    }

    public CoreConfigurationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public CoreConfigurationException(List<String> msgs) {
        super(msgs);
    }

    public CoreConfigurationException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public CoreConfigurationException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public CoreConfigurationException(Throwable cause, String... causeMessages) {
        super(cause, causeMessages);
    }

    


}
