package org.lindbergframework.test.persistence.test.mysql;

import static org.lindbergframework.test.persistence.util.BeansUtil.createPerson;

import java.util.List;

import org.lindbergframework.test.persistence.dao.mysql.MySqlPersistTemplateDaoTest;
import org.lindbergframework.test.persistence.test.PersistenceTemplateTest;
import org.lindbergframework.test.testBeans.Person;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class MySqlPersistenceTemplateTest extends PersistenceTemplateTest{
    
	private MySqlPersistTemplateDaoTest mySqlPersistTemplateDaoTest;
	
	public MySqlPersistenceTemplateTest() {
		super("org/lindbergframework/test/persistence/resource/mysql/configMySql.xml");
	}
	
	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		mySqlPersistTemplateDaoTest = new MySqlPersistTemplateDaoTest();
		setPersistTemplateDaoTest(mySqlPersistTemplateDaoTest);
	}
	
	public void testFindPersonFromProcedure() {
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		mySqlPersistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		mySqlPersistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "nick3", "profession3", "street3", 333);
		mySqlPersistTemplateDaoTest.insertPerson(person3);
		
		String nick = mySqlPersistTemplateDaoTest.findPersonNickFromProcedure(2);
		assertNotNull(nick);
		assertEquals("nick2", nick);
	}
	
	public void testList3NickPersonsFromProcedure() {
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		mySqlPersistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		mySqlPersistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "nick3", "profession3", "street3", 333);
		mySqlPersistTemplateDaoTest.insertPerson(person3);
		
		List<String> nicks = mySqlPersistTemplateDaoTest.list3NickPersonsFromProcedure(2, 1, 3);
		assertNotNull(nicks);
		assertTrue(nicks.size() == 3);
		
		assertEquals("nick2", nicks.get(0));
		assertEquals("nick1", nicks.get(1));
		assertEquals("nick3", nicks.get(2));
	}
	
	public void testList3NickWithOneNoExistsPersonsFromProcedure() {
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		mySqlPersistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		mySqlPersistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "nick3", "profession3", "street3", 333);
		mySqlPersistTemplateDaoTest.insertPerson(person3);
		
		List<String> nicks = mySqlPersistTemplateDaoTest.list3NickPersonsFromProcedure(2, 10, 3);
		assertNotNull(nicks);
		assertTrue(nicks.size() == 3);
		
		assertEquals("nick2", nicks.get(0));
		assertNull(nicks.get(1));
		assertEquals("nick3", nicks.get(2));
	}
	
	public void testFindPersonNickFromFunction() {
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		mySqlPersistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		mySqlPersistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "nick3", "profession3", "street3", 333);
		mySqlPersistTemplateDaoTest.insertPerson(person3);
		
		String nick = mySqlPersistTemplateDaoTest.findPersonNickFromFunction(3);
		assertNotNull(nick);
		assertEquals("nick3", nick);
	}
	
	public void testFindNoExistsPersonNickFromFunction() {
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		mySqlPersistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		mySqlPersistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "nick3", "profession3", "street3", 333);
		mySqlPersistTemplateDaoTest.insertPerson(person3);
		
		String nick = mySqlPersistTemplateDaoTest.findPersonNickFromFunction(7);
		assertNull(nick);
	}
	
}
