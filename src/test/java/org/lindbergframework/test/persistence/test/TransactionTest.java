package org.lindbergframework.test.persistence.test;

import static org.lindbergframework.test.persistence.util.BeansUtil.createPerson;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.lindbergframework.beans.di.context.UserBeanContext;
import org.lindbergframework.core.configuration.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.configuration.CoreConfiguration;
import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.exception.TransactionException;
import org.lindbergframework.test.beans.NoTransactionalBC;
import org.lindbergframework.test.beans.TransactionByMethodBC;
import org.lindbergframework.test.beans.TransactionalBC;
import org.lindbergframework.test.testBeans.Person;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class TransactionTest extends TestCase {

	private CoreConfiguration configuration;

	private String configResourceLocation;

	public TransactionTest(String configLocation) {
		this.configResourceLocation = configLocation;
	}

	@Override
	protected void setUp() throws Exception {
		if (!CoreContext.getInstance().isActive()) {
			configuration = new ClassPathXmlCoreConfiguration(
					configResourceLocation);
			CoreContext.getInstance().initialize(configuration);
		}

		super.setUp();
		UserBeanContext.getInstance().renew();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		CoreContext.getInstance().finalize();
	}

	public void testInsertPersonsSameID() {
		TransactionalBC transactionalBC = UserBeanContext.getInstance()
				.getBean("transactionalBC");
		insertPersonsSameID(transactionalBC);
	}

	public void testInsertPersonsSameIDTransactionByMethod() {
		TransactionByMethodBC transactionalBC = UserBeanContext.getInstance()
				.getBean("transactionByMethodBC");
		insertPersonsSameID(transactionalBC);
	}

	public void insertPersonsSameID(NoTransactionalBC transactionalBC) {
		Person person1 = createPerson(1, "aaa", "student", "xxx", 111);
		Person person2 = createPerson(2, "bbb", "studentbbb", "xxxbbb", 222);
		Person personSameID = createPerson(1, "aaa2", "student2", "xxx2", 333);

		try {
			transactionalBC.insertPersons(person1, person2, personSameID);
		} catch (TransactionException ex) {
			assertTrue(true);
		}

		List<Person> persons = transactionalBC.listPersons();
		assertNotNull(persons);
		assertTrue(persons.isEmpty());
	}

	public void testDeletePersons() {
		TransactionalBC transactionalBC = UserBeanContext.getInstance()
				.getBean("transactionalBC");
		deletePersons(transactionalBC);
	}

	public void testDeletePersonsTransactionByMethod() {
		TransactionByMethodBC transactionalBC = UserBeanContext.getInstance()
				.getBean("transactionByMethodBC");
		deletePersons(transactionalBC);
	}

	public void deletePersons(NoTransactionalBC transactionalBC) {
		Person person1 = createPerson(1, "aaa", "student", "xxx", 111);
		Person person2 = createPerson(2, "bbb", "studentbbb", "xxxbbb", 222);
		Person personSameID = createPerson(1, "aaa2", "student2", "xxx2", 333);

		try {
			transactionalBC.insertInsertDeleteInsertPerson(person1, person2,
					person2, personSameID);
		} catch (TransactionException ex) {
			assertTrue(true);
		}

		List<Person> persons = transactionalBC.listPersons();
		assertNotNull(persons);
		assertTrue(persons.isEmpty());
	}

	public void testUpdate() {
		TransactionalBC transactionalBC = UserBeanContext.getInstance()
				.getBean("transactionalBC");

		Person person1 = createPerson(1, "aaa", "student", "xxx", 111);
		Person personUpdate = createPerson(1, "bbb", "student", "xxx", 111);
		Person personSameID = createPerson(1, "aaa2", "student2", "xxx2", 333);

		try {
			try {
				transactionalBC.insertPersons(person1);
				transactionalBC.updateNickPersonAndInsertNewPerson(
						personUpdate, personSameID);
			} catch (TransactionException ex) {
				assertTrue(true);
			}

			List<Person> persons = transactionalBC.listPersons();
			assertNotNull(persons);
			assertTrue(persons.size() == 1);

			Person personReturned = persons.get(0);
			assertEquals(personReturned.getId(), new Integer(1));
			assertEquals(personReturned.getNickname(), "aaa");
		} finally {
			transactionalBC.deletePersons(person1);
		}
	}

	public void testUpdateByProcedure() {
		TransactionalBC transactionalBC = UserBeanContext.getInstance()
				.getBean("transactionalBC");

		Date dt = new Date();
		Person person1 = createPerson(1, "aaa", "student", "xxx", 111, dt);

		Person personUpdate = createPerson(1, "bbb", "student", "xxx", 111,
				new Date(1000));
		Person personSameID = createPerson(1, "aaa2", "student2", "xxx2", 333);

		try {
			try {
				transactionalBC.insertPersons(person1);
				transactionalBC
						.updateNickBirthDatePersonFromProcedureAndInsertNewPerson(
								personUpdate, personSameID);
			} catch (TransactionException ex) {
				assertTrue(true);
			}

			List<Person> persons = transactionalBC.listPersons();
			assertNotNull(persons);
			assertTrue(persons.size() == 1);

			Person personReturned = persons.get(0);
			assertEquals(personReturned.getId(), new Integer(1));
			assertEquals(personReturned.getNickname(), "aaa");

			Calendar calResult = Calendar.getInstance();
			calResult.setTime(personReturned.getBirthDate());

			Calendar updatedCal = Calendar.getInstance();
			calResult.setTime(dt);

			assertEquals(updatedCal.get(Calendar.YEAR), calResult
					.get(Calendar.YEAR));
			assertEquals(updatedCal.get(Calendar.MONTH), calResult
					.get(Calendar.MONTH));
			assertEquals(updatedCal.get(Calendar.DATE), calResult
					.get(Calendar.DATE));
		} finally {
			transactionalBC.deletePersons(person1);
		}
	}

}
