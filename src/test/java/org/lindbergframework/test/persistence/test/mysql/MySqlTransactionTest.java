package org.lindbergframework.test.persistence.test.mysql;

import org.lindbergframework.test.persistence.test.TransactionTest;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class MySqlTransactionTest extends TransactionTest{
    
    public MySqlTransactionTest(){
        super("org/lindbergframework/test/persistence/resource/mysql/configMySql.xml");
    }

}
