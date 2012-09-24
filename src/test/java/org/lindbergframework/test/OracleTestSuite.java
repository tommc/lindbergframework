package org.lindbergframework.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.lindbergframework.test.persistence.test.oracle.OraclePersistenceTemplateTest;
import org.lindbergframework.test.persistence.test.oracle.OraclePersistenceTransactionSpringIntegrationTest;
import org.lindbergframework.test.persistence.test.oracle.OracleTransactionTest;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class OracleTestSuite {

	/**
	 * Default Constructor.
	 */
	public OracleTestSuite() {
		//
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.lindbergframework");
		//$JUnit-BEGIN$
		//Oracle
		suite.addTestSuite(OraclePersistenceTemplateTest.class);
		suite.addTestSuite(OracleTransactionTest.class);
		suite.addTestSuite(OraclePersistenceTransactionSpringIntegrationTest.class);
		//$JUnit-END$
		return suite;
	}
}
