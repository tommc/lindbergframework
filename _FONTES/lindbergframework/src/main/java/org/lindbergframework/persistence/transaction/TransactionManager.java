package org.lindbergframework.persistence.transaction;

import org.lindbergframework.exception.TransactionException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface TransactionManager {
    
    public Object execute(TransactionalContext transactionalContext) throws TransactionException;

}
