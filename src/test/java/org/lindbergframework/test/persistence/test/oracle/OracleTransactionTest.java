package org.lindbergframework.test.persistence.test.oracle;

import org.lindbergframework.test.persistence.test.TransactionTest;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class OracleTransactionTest extends TransactionTest{
    
    public OracleTransactionTest(){
        super("org/lindbergframework/test/persistence/resource/oracle/configOracle.xml");
    }

}
