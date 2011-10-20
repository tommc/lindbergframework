package org.lindbergframework.exception;

import java.util.List;

/**
 * Injection dependency container exception.
 * 
 * @author Victor Lindberg
 *
 */
public class InjectionDependencyException extends BeanException{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InjectionDependencyException() {
    }

    public InjectionDependencyException(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public InjectionDependencyException(List<String> msgs) {
        super(msgs);
    }

    public InjectionDependencyException(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public InjectionDependencyException(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public InjectionDependencyException(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

    

}
