package org.lindbergframework.persistence.transaction;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.exception.TransactionException;
import org.lindbergframework.exception.TransactionFailureException;
import org.lindbergframework.persistence.context.LinpContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Transaction template implementation that uses Spring transaction resources to manage transactions of database.
 * 
 * @author Victor Lindberg
 *
 */
@Bean("defaultLinpTransactionManager")
public class LinpSpringTransactionManager extends TransactionTemplate
                              implements TransactionManager{
    
    private static final long serialVersionUID = 1L;

    /**
     * default constructor that uses DataSourceTransactionManager as PlatformTransactionManager implementation.
     */
    public LinpSpringTransactionManager(){
        this(new DataSourceTransactionManager(LinpContext.getInstance().getDataSource()));
    }

    /**
     * Creates a LinpSpringTransactionManager with the specified PlatformTransactionManager imlementation.
     * 
     * @param transactionManager PlatformTransactionManager imlementation.
     */
    public LinpSpringTransactionManager(PlatformTransactionManager transactionManager){
        super(transactionManager);
    }
    
    /**
     * {@inheritDoc}
     */
    public Object execute(TransactionalContext transactionalContext)
        throws TransactionException {
        final TransactionalContext finalContext = transactionalContext;
        return super.execute(new TransactionCallback(){
           public Object doInTransaction(TransactionStatus status) {
               try{
                return finalContext.call();
               }catch(Throwable ex){
                   throw new TransactionFailureException(
                       "Transaction failed : "+ex.getMessage(), ex);    
               }
            } 
        });
    }

}
