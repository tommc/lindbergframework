package org.lindbergframework.test.persistence.test.oracle;

import java.util.List;

import junit.framework.Test;

import org.lindbergframework.test.persistence.dao.oracle.OraclePersistTemplateDaoTest;
import org.lindbergframework.test.persistence.test.PersistenceTemplateTest;
import org.lindbergframework.test.testBeans.Person;

import static org.lindbergframework.test.persistence.util.BeansUtil.*;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class OraclePersistenceTemplateTest extends PersistenceTemplateTest implements Test{
	
	private OraclePersistTemplateDaoTest oraclePersistTemplateDaoTest;
	
	public OraclePersistenceTemplateTest(){
		super("org/lindbergframework/test/persistence/resource/oracle/configOracle.xml");
	}
	
	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		oraclePersistTemplateDaoTest = new OraclePersistTemplateDaoTest();
		setPersistTemplateDaoTest(oraclePersistTemplateDaoTest);
	}
	
	public void testQueryOut3ParametersFromProcedure(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "nick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = oraclePersistTemplateDaoTest.out3PersonsFromProcedure();
		assertNotNull(result);
		assertTrue(result.size() == 3);
		
		//PERSON1
		Person person11 = result.get(0);
		assertNotNull(person11.getId());
		assertNotNull(person11.getNickname());
		assertNotNull(person11.getProfession());
		assertNotNull(person11.getAddres());
		assertNotNull(person11.getAddres().getStreet());
		assertNotNull(person11.getAddres().getNumber());
		
		assertEquals(person1.getId(), person11.getId());
		assertEquals(person1.getNickname(), person11.getNickname());
		assertEquals(person1.getProfession(), person11.getProfession());
		assertEquals(person1.getAddres().getStreet(), person11.getAddres().getStreet());
		assertEquals(person1.getAddres().getNumber(), person11.getAddres().getNumber());
		
		//PERSON2
		Person person22 = result.get(1);
		assertNotNull(person22.getId());
		assertNotNull(person22.getNickname());
		assertNotNull(person22.getProfession());
		assertNotNull(person22.getAddres());
		assertNotNull(person22.getAddres().getStreet());
		assertNotNull(person22.getAddres().getNumber());
		
		assertEquals(person2.getId(), person22.getId());
		assertEquals(person2.getNickname(), person22.getNickname());
		assertEquals(person2.getProfession(), person22.getProfession());
		assertEquals(person2.getAddres().getStreet(), person22.getAddres().getStreet());
		assertEquals(person2.getAddres().getNumber(), person22.getAddres().getNumber());
		
		//PERSON3
		Person person33 = result.get(2);
		assertNotNull(person33.getId());
		assertNotNull(person33.getNickname());
		assertNotNull(person33.getProfession());
		assertNotNull(person33.getAddres());
		assertNotNull(person33.getAddres().getStreet());
		assertNotNull(person33.getAddres().getNumber());
		
		assertEquals(person3.getId(), person33.getId());
		assertEquals(person3.getNickname(), person33.getNickname());
		assertEquals(person3.getProfession(), person33.getProfession());
		assertEquals(person3.getAddres().getStreet(), person33.getAddres().getStreet());
		assertEquals(person3.getAddres().getNumber(), person33.getAddres().getNumber());
		
	}
	
	public void testQueryFromProcedure(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "testnick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "tenick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = oraclePersistTemplateDaoTest.listPersonsFromProcedure("te");
		assertNotNull(result);
		assertTrue(result.size() == 2);
		
		//PERSON2
		Person person22 = result.get(0);
		assertNotNull(person22.getId());
		assertNotNull(person22.getNickname());
		assertNotNull(person22.getProfession());
		assertNotNull(person22.getAddres());
		assertNotNull(person22.getAddres().getStreet());
		assertNotNull(person22.getAddres().getNumber());
		
		assertEquals(person2.getId(), person22.getId());
		assertEquals(person2.getNickname(), person22.getNickname());
		assertEquals(person2.getProfession(), person22.getProfession());
		assertEquals(person2.getAddres().getStreet(), person22.getAddres().getStreet());
		assertEquals(person2.getAddres().getNumber(), person22.getAddres().getNumber());
		
		//PERSON3
		Person person33 = result.get(1);
		assertNotNull(person33.getId());
		assertNotNull(person33.getNickname());
		assertNotNull(person33.getProfession());
		assertNotNull(person33.getAddres());
		assertNotNull(person33.getAddres().getStreet());
		assertNotNull(person33.getAddres().getNumber());
		
		assertEquals(person3.getId(), person33.getId());
		assertEquals(person3.getNickname(), person33.getNickname());
		assertEquals(person3.getProfession(), person33.getProfession());
		assertEquals(person3.getAddres().getStreet(), person33.getAddres().getStreet());
		assertEquals(person3.getAddres().getNumber(), person33.getAddres().getNumber());
		
	}
	
	public void testQueryNoExistsFromProcedure(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "testnick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "tenick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = oraclePersistTemplateDaoTest.listPersonsFromProcedure("abcde");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	public void testQueryFromFunction(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "testnick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "tenick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = oraclePersistTemplateDaoTest.listPersonsFromFunction("te");
		assertNotNull(result);
		assertTrue(result.size() == 2);
		
		//PERSON2
		Person person22 = result.get(0);
		assertNotNull(person22.getId());
		assertNotNull(person22.getNickname());
		assertNotNull(person22.getProfession());
		assertNotNull(person22.getAddres());
		assertNotNull(person22.getAddres().getStreet());
		assertNotNull(person22.getAddres().getNumber());
		
		assertEquals(person2.getId(), person22.getId());
		assertEquals("test", person22.getNickname());//test is returned from function as out parameter and this is set in person object
		assertEquals(person2.getProfession(), person22.getProfession());
		assertEquals(person2.getAddres().getStreet(), person22.getAddres().getStreet());
		assertEquals(person2.getAddres().getNumber(), person22.getAddres().getNumber());
		
		//PERSON3
		Person person33 = result.get(1);
		assertNotNull(person33.getId());
		assertNotNull(person33.getNickname());
		assertNotNull(person33.getProfession());
		assertNotNull(person33.getAddres());
		assertNotNull(person33.getAddres().getStreet());
		assertNotNull(person33.getAddres().getNumber());
		
		assertEquals(person3.getId(), person33.getId());
		assertEquals(person3.getNickname(), person33.getNickname());
		assertEquals(person3.getProfession(), person33.getProfession());
		assertEquals(person3.getAddres().getStreet(), person33.getAddres().getStreet());
		assertEquals(person3.getAddres().getNumber(), person33.getAddres().getNumber());
		
	}
	
	public void testQueryNoExistsFromFunction(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "testnick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "tenick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = oraclePersistTemplateDaoTest.listPersonsFromFunction("abcde");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	public static void main(String[] args) {
        System.out.println("UPDATEPERSONNICKBIRTHDATEFUNC".toLowerCase());
    }
	
}
