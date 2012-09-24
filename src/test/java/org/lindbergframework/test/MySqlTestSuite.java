package org.lindbergframework.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.lindbergframework.test.persistence.test.mysql.MySqlPersistenceTemplateTest;
import org.lindbergframework.test.persistence.test.mysql.MySqlPersistenceTransactionSpringIntegrationTest;
import org.lindbergframework.test.persistence.test.mysql.MySqlTransactionTest;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class MySqlTestSuite {

	/**
	 * Default Constructor.
	 */
	public MySqlTestSuite() {
		//
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.lindbergframework");
		//$JUnit-BEGIN$
		//Mysql
		suite.addTestSuite(MySqlPersistenceTemplateTest.class);
		suite.addTestSuite(MySqlTransactionTest.class);
		suite.addTestSuite(MySqlPersistenceTransactionSpringIntegrationTest.class);
		//$JUnit-END$
		return suite;
	}
}
