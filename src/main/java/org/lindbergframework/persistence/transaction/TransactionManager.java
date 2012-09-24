package org.lindbergframework.persistence.transaction;

import org.lindbergframework.exception.TransactionFailureException;

/**
 * Interface that defines the contract for transaction manager implementations.
 * 
 * A transaction manager is used by lindberg persistence to manage database transactions.
 * 
 * @author Victor Lindberg
 *
 */
public interface TransactionManager {
    
    /**
     * Executes a transaction based on specified context.
     * 
     * @param transactionalContext context of transaction.
     * @return  result object of transaction.
     * 
     * @throws TransactionFailureException transaction failed.
     */
    public Object execute(TransactionalContext transactionalContext) throws TransactionFailureException;

}
