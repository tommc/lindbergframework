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
 * 
 * @author Victor Lindberg
 *
 */
@Bean("defaultLinpTransactionManager")
public class LinpSpringTransactionManager extends TransactionTemplate
                              implements TransactionManager{
    
    private static final long serialVersionUID = 1L;

    public LinpSpringTransactionManager(){
        this(new DataSourceTransactionManager(LinpContext.getInstance().getDataSource()));
    }
    
    public LinpSpringTransactionManager(PlatformTransactionManager transactionManager){
        super(transactionManager);
    }
    
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
