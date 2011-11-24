package org.lindbergframework.test.persistence.test;

import static org.lindbergframework.test.persistence.util.BeansUtil.createPerson;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.lindbergframework.test.persistence.dao.PersistTemplateDaoTest;
import org.lindbergframework.test.testBeans.Employee;
import org.lindbergframework.test.testBeans.Person;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class PersistenceTemplateTest extends LinpTestBase{
	
	protected PersistTemplateDaoTest persistTemplateDaoTest;
	
	public PersistenceTemplateTest(String configResourceLocation){
		super(configResourceLocation);
	}
	
	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
	}
	
	protected void setPersistTemplateDaoTest(PersistTemplateDaoTest persistTemplateDaoTest) {
		this.persistTemplateDaoTest = persistTemplateDaoTest;
	}
	
	public void testInsert(){
		Person person = createPerson(1, "nick", "profession", "street", 123);
		persistTemplateDaoTest.insertPerson(person);
		
		List<Person> result = persistTemplateDaoTest.listPersons();
		assertNotNull(result);
		assertTrue(result.size() == 1);
		
		Person personReturned = result.get(0);
		
		assertNotNull(personReturned.getId());
		assertNotNull(personReturned.getNickname());
		assertNotNull(personReturned.getProfession());
		assertNotNull(personReturned.getAddres());
		assertNotNull(personReturned.getAddres().getStreet());
		assertNotNull(personReturned.getAddres().getNumber());
		
		assertEquals(person.getId(), personReturned.getId());
		assertEquals(person.getNickname(), personReturned.getNickname());
		assertEquals(person.getProfession(), personReturned.getProfession());
		assertEquals(person.getAddres().getStreet(), personReturned.getAddres().getStreet());
		assertEquals(person.getAddres().getNumber(), personReturned.getAddres().getNumber());
	}

	public void testUpdate(){
		Person person = createPerson(1, "nick", "profession", "street", 123);
		persistTemplateDaoTest.insertPerson(person);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		person.setNickname("nickchanged");
		person.setProfession("professionchanged");
		persistTemplateDaoTest.updateNickNamePerson(person);
		
		Person personResult = persistTemplateDaoTest.getPersonFromId(person.getId());
		assertNotNull(personResult);
		
		assertEquals(personResult.getId(), new Integer(1));
		assertEquals(personResult.getNickname(), "nickchanged");
		assertEquals(personResult.getProfession(), "professionchanged");
		assertEquals(personResult.getAddres().getStreet(), "street");
		assertEquals(personResult.getAddres().getNumber(), 123);
		
		Person personResult2 = persistTemplateDaoTest.getPersonFromId(person2.getId());
		assertNotNull(personResult2);
		
		assertEquals(personResult2.getId(), new Integer(2));
		assertEquals(personResult2.getNickname(), "nick2");
		assertEquals(personResult2.getProfession(), "profession2");
		assertEquals(personResult2.getAddres().getStreet(), "street2");
		assertEquals(personResult2.getAddres().getNumber(), 222);
	}

	public void testDelete(){
		Person person = createPerson(1, "nick", "profession", "street", 123);
		persistTemplateDaoTest.insertPerson(person);
		
		Person personResult = persistTemplateDaoTest.getPersonFromId(person.getId());
		assertNotNull(personResult);
		
		persistTemplateDaoTest.deletePerson(person.getId());
		
		personResult = persistTemplateDaoTest.getPersonFromId(person.getId());
		
		assertNull(personResult);
	}
	
	public void testQuery(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "nick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = persistTemplateDaoTest.listPersons();
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
	
	public void testEmptyQuery(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "nick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "nick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = persistTemplateDaoTest.listPersonsLikeNickName("abcde");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	public void testQueryParameter(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "testNick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "teNick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = persistTemplateDaoTest.listPersonsLikeNickName("te");
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
	
	public void testQueryDateParameter(){
		Date currentDate = new Date();
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111, currentDate);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "testNick2", "profession2", "street2", 222, currentDate);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "teNick3", "profession3", "street3", 333, new Date(1000));
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = persistTemplateDaoTest.listPersonsFromBirthDate(currentDate);
		assertNotNull(result);
		assertTrue(result.size() == 2);
		
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
	}
	
	public void testQueryNoExistsDateParameter(){
		Date currentDate = new Date();
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111, currentDate);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "testNick2", "profession2", "street2", 222, currentDate);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "teNick3", "profession3", "street3", 333, new Date(1));
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Person> result = persistTemplateDaoTest.listPersonsFromBirthDate(new Date(999999999));
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	public void testUpdatePersonFromProcedure(){
		Date currentDate = new Date();
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111, currentDate);
		persistTemplateDaoTest.insertPerson(person1);
		
		Calendar updatedCal = Calendar.getInstance();
		updatedCal.set(Calendar.YEAR, 2000);
		updatedCal.set(Calendar.MONTH, 1);
		updatedCal.set(Calendar.DATE, 10);
		
		String updatedNick = "nickUpdated";
		persistTemplateDaoTest.updatePersonNickNameBirthDateFromProcedure(1, updatedNick, updatedCal.getTime());
		
		Person updatedPerson = persistTemplateDaoTest.getPersonFromId(1);
		assertNotNull(updatedPerson);
		
		assertEquals(updatedNick, updatedPerson.getNickname());
		
		Calendar updatedBirthDate = Calendar.getInstance();
		updatedBirthDate.setTime(updatedPerson.getBirthDate());
		
		assertEquals(updatedCal.get(Calendar.YEAR), updatedBirthDate.get(Calendar.YEAR));
		assertEquals(updatedCal.get(Calendar.MONTH), updatedBirthDate.get(Calendar.MONTH));
		assertEquals(updatedCal.get(Calendar.DATE), updatedBirthDate.get(Calendar.DATE));
		
		assertEquals(person1.getProfession(), updatedPerson.getProfession());
		
		assertNotNull(updatedPerson.getAddres());
		assertEquals(person1.getAddres().getStreet(), updatedPerson.getAddres().getStreet());
		assertEquals(person1.getAddres().getNumber(), updatedPerson.getAddres().getNumber());
	}
	
	public void testUpdatePersonFromFunction(){
		Date currentDate = new Date();
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111, currentDate);
		persistTemplateDaoTest.insertPerson(person1);
		
		Calendar updatedCal = Calendar.getInstance();
		updatedCal.set(Calendar.YEAR, 2000);
		updatedCal.set(Calendar.MONTH, 1);
		updatedCal.set(Calendar.DATE, 10);
		
		String updatedNick = "nickUpdated";
		Date dateResultFunction = persistTemplateDaoTest.updatePersonNickNameBirthDateFromFunction(1, updatedNick, updatedCal.getTime());
		
		Person updatedPerson = persistTemplateDaoTest.getPersonFromId(1);
		assertNotNull(updatedPerson);
		
		Calendar calResult = Calendar.getInstance();
		calResult.setTime(dateResultFunction);
		
		assertEquals(updatedCal.get(Calendar.YEAR), calResult.get(Calendar.YEAR));
		assertEquals(updatedCal.get(Calendar.MONTH), calResult.get(Calendar.MONTH));
		assertEquals(updatedCal.get(Calendar.DATE), calResult.get(Calendar.DATE));
		
		
		assertEquals(updatedNick, updatedPerson.getNickname());
		
		Calendar updatedBirthDate = Calendar.getInstance();
		updatedBirthDate.setTime(updatedPerson.getBirthDate());
		
		assertEquals(updatedCal.get(Calendar.YEAR), updatedBirthDate.get(Calendar.YEAR));
		assertEquals(updatedCal.get(Calendar.MONTH), updatedBirthDate.get(Calendar.MONTH));
		assertEquals(updatedCal.get(Calendar.DATE), updatedBirthDate.get(Calendar.DATE));
		
		assertEquals(person1.getProfession(), updatedPerson.getProfession());
		
		assertNotNull(updatedPerson.getAddres());
		assertEquals(person1.getAddres().getStreet(), updatedPerson.getAddres().getStreet());
		assertEquals(person1.getAddres().getNumber(), updatedPerson.getAddres().getNumber());
	}
	
	public void testQueryEmployeesPopulatingPropertiesInPersonSuperClass(){
		Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
		persistTemplateDaoTest.insertPerson(person1);
		
		Person person2 = createPerson(2, "testNick2", "profession2", "street2", 222);
		persistTemplateDaoTest.insertPerson(person2);
		
		Person person3 = createPerson(3, "teNick3", "profession3", "street3", 333);
		persistTemplateDaoTest.insertPerson(person3);
		
		List<Employee> result = persistTemplateDaoTest.queryEmployees();
		assertNotNull(result);
		assertTrue(result.size() == 3);
		
		//EMPLOYEE1
		Employee employee1 = result.get(0);
		assertNotNull(employee1.getId());
		assertNotNull(employee1.getNickname());
		assertNotNull(employee1.getProfession());
		assertNotNull(employee1.getAddres());
		assertNotNull(employee1.getAddres().getStreet());
		assertNotNull(employee1.getAddres().getNumber());
		assertNotNull(employee1.getWage());
		
		assertEquals(person1.getId(), employee1.getId());
		assertEquals(person1.getNickname(), employee1.getNickname());
		assertEquals(person1.getProfession(), employee1.getProfession());
		assertEquals(person1.getAddres().getStreet(), employee1.getAddres().getStreet());
		assertEquals(person1.getAddres().getNumber(), employee1.getAddres().getNumber());
		assertEquals(1000D, employee1.getWage());
		
		//EMPLOYEE2
		Employee employee2 = result.get(1);
		assertNotNull(employee2.getId());
		assertNotNull(employee2.getNickname());
		assertNotNull(employee2.getProfession());
		assertNotNull(employee2.getAddres());
		assertNotNull(employee2.getAddres().getStreet());
		assertNotNull(employee2.getAddres().getNumber());
		assertNotNull(employee2.getWage());
		
		assertEquals(person2.getId(), employee2.getId());
		assertEquals(person2.getNickname(), employee2.getNickname());
		assertEquals(person2.getProfession(), employee2.getProfession());
		assertEquals(person2.getAddres().getStreet(), employee2.getAddres().getStreet());
		assertEquals(person2.getAddres().getNumber(), employee2.getAddres().getNumber());
		assertEquals(1000D, employee2.getWage());
		
		//EMPLOYEE2
		Employee employee3 = result.get(2);
		assertNotNull(employee3.getId());
		assertNotNull(employee3.getNickname());
		assertNotNull(employee3.getProfession());
		assertNotNull(employee3.getAddres());
		assertNotNull(employee3.getAddres().getStreet());
		assertNotNull(employee3.getAddres().getNumber());
		assertNotNull(employee3.getWage());
		
		assertEquals(person3.getId(), employee3.getId());
		assertEquals(person3.getNickname(), employee3.getNickname());
		assertEquals(person3.getProfession(), employee3.getProfession());
		assertEquals(person3.getAddres().getStreet(), employee3.getAddres().getStreet());
		assertEquals(person3.getAddres().getNumber(), employee3.getAddres().getNumber());
		assertEquals(1000D, employee3.getWage());
	}
	
	public void testQueryForObjectDirectValue(){
	    Person person1 = createPerson(1, "nick1", "profession1", "street1", 111);
        persistTemplateDaoTest.insertPerson(person1);
        
        Person person2 = createPerson(2, "testNick2", "profession2", "street2", 222);
        persistTemplateDaoTest.insertPerson(person2);
        
        int qtd = this.persistTemplateDaoTest.getTotalPersons();
        assertTrue(qtd == 2);
        
	}
	
	
}
