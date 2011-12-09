package org.lindbergframework.test.beans;

import java.sql.SQLException;
import java.util.List;

import org.lindbergframework.persistence.transaction.annotation.Transax;
import org.lindbergframework.test.persistence.dao.PersistTemplateDaoTest;
import org.lindbergframework.test.testBeans.Person;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class SpringTransactionalBC {

	private PersistTemplateDaoTest dao;
	
	/**
	 * Default Constructor.
	 */
	public SpringTransactionalBC() {
		//
	}
	
	public void setDao(PersistTemplateDaoTest dao) {
		this.dao = dao;
	}
	
	@Transax
	public void insertPersons(Person... persons) throws SQLException{
		for(Person person : persons)
		   dao.insertPerson(person);
	}
	
	public List<Person> listPersons(){
		return dao.listPersons();
	}
	
	public void deletePerson(int id){
		dao.deletePerson(id);
	}
}
