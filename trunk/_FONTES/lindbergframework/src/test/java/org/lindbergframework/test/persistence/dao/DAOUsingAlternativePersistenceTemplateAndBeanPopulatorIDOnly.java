package org.lindbergframework.test.persistence.dao;

import org.lindbergframework.test.beans.BeanPopulatorIDOnly;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class DAOUsingAlternativePersistenceTemplateAndBeanPopulatorIDOnly extends PersistTemplateDaoTest{

	/**
	 * Default Constructor.
	 */
	public DAOUsingAlternativePersistenceTemplateAndBeanPopulatorIDOnly() {
		super(new PersistenceTemplateImpl(),new BeanPopulatorIDOnly());
	}
}
