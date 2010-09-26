package org.lindbergframework.persistence.transaction;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface TransactionalContext {
    
    public Object call();

}
