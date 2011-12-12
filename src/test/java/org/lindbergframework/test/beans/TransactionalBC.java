package org.lindbergframework.test.beans;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.persistence.transaction.annotation.Transax;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Bean("transactionalBC")
@Transax
public class TransactionalBC extends NoTransactionalBC{
    

}
