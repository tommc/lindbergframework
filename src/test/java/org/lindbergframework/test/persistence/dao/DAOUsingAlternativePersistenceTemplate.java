package org.lindbergframework.test.persistence.dao;


/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class DAOUsingAlternativePersistenceTemplate extends PersistTemplateDaoTest{

	/**
	 * Default Constructor.
	 */
	public DAOUsingAlternativePersistenceTemplate() {
		super(new PersistenceTemplateImpl());
	}
	
	
}
