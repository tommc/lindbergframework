package org.lindbergframework.exception;

import java.util.List;

/**
 * Core configuration exception.
 *  
 * @author Victor Lindberg
 *
 */
public class CoreConfigurationException extends CoreException{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CoreConfigurationException() {
        //
    }

    public CoreConfigurationException(String msg) {
        super(msg);
    }

    public CoreConfigurationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CoreConfigurationException(Throwable cause) {
        super(cause);
    }

    public CoreConfigurationException(List<String> msgs) {
        super(msgs);
    }

    public CoreConfigurationException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }


}
