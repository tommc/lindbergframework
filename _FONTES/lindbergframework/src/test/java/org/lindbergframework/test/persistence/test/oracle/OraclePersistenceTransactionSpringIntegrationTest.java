package org.lindbergframework.test.persistence.test.oracle;

import org.lindbergframework.test.persistence.test.PersistenceTransactionSpringIntegrationTest;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class OraclePersistenceTransactionSpringIntegrationTest 
			extends PersistenceTransactionSpringIntegrationTest{

	/**
	 * Default Constructor.
	 */
	public OraclePersistenceTransactionSpringIntegrationTest() {
		super("org/lindbergframework/test/persistence/resource/oracle/configOracle.xml");
	}
}
