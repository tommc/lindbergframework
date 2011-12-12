package org.lindbergframework.test.persistence.test.mysql;

import org.lindbergframework.test.persistence.test.PersistenceTransactionSpringIntegrationTest;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class MySqlPersistenceTransactionSpringIntegrationTest 
			extends PersistenceTransactionSpringIntegrationTest{

	/**
	 * Default Constructor.
	 */
	public MySqlPersistenceTransactionSpringIntegrationTest() {
		super("org/lindbergframework/test/persistence/resource/mysql/configMySql.xml");
	}
}
