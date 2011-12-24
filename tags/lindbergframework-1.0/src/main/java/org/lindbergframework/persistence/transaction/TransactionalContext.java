package org.lindbergframework.persistence.transaction;

/**
 * interface that defines a transactional context.
 * 
 * @author Victor Lindberg
 *
 */
public interface TransactionalContext {
  
    /**
     * Method that defines the entry point of transactional context.
     * Everything that occurs within this point is inside a transaction
     * 
     * @return result object of transactional call.
     */
    public Object call();

}
