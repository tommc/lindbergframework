package org.lindbergframework.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.lindbergframework.test.beans.di.test.DiTest;
import org.lindbergframework.test.persistence.test.mysql.MySqlPersistenceTemplateTest;
import org.lindbergframework.test.persistence.test.mysql.MySqlTransactionTest;
import org.lindbergframework.test.persistence.test.oracle.OraclePersistenceTemplateTest;
import org.lindbergframework.test.persistence.test.oracle.OracleTransactionTest;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergFrameworkTestSuite{
	
	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for lindbergframework");
		//$JUnit-BEGIN$
		suite.addTestSuite(OraclePersistenceTemplateTest.class);
		suite.addTestSuite(MySqlPersistenceTemplateTest.class);
		suite.addTestSuite(DiTest.class);
		suite.addTestSuite(OracleTransactionTest.class);
		suite.addTestSuite(MySqlTransactionTest.class);
		//$JUnit-END$
		return suite;
	}

}
