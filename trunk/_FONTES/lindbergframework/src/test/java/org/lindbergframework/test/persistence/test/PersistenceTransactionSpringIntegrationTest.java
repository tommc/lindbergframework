package org.lindbergframework.test.persistence.test;

import static org.lindbergframework.test.persistence.util.BeansUtil.createPerson;

import java.util.List;

import junit.framework.TestCase;

import org.lindbergframework.core.configuration.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.configuration.CoreConfiguration;
import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.exception.TransactionFailureException;
import org.lindbergframework.test.beans.SpringTransactionalBC;
import org.lindbergframework.test.testBeans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class PersistenceTransactionSpringIntegrationTest extends TestCase{

	private CoreConfiguration configuration;

    private String configResourceLocation;
    
    private ApplicationContext springContext;

    public PersistenceTransactionSpringIntegrationTest(String configResourceLocation) {
        this.configResourceLocation = configResourceLocation;
    }

    @Override
    protected void setUp() throws Exception {
        if (!CoreContext.getInstance().isActive()) {
            configuration = new ClassPathXmlCoreConfiguration(
                configResourceLocation);
            configuration.initializeContext();
            springContext = new ClassPathXmlApplicationContext("org/lindbergframework/test/persistence/resource/springContext.xml");
        }
    }

    @Override
    protected void tearDown() throws Exception {
        CoreContext.getInstance().close();
    }
    
    public void testTransactionFail(){
    	Person person1 = createPerson(1, "nick1", "prof1", "st1", 111);
    	Person person2 = createPerson(2/*SAME ID*/, "nick2", "prof2", "st2", 222);//same id (transaction will fail)
    	Person person3 = createPerson(2/*SAME ID*/, "nick3", "prof3", "st3", 333);//same id (transaction will fail)
    	try{
    		getBC().insertPersons(person1,person2,person3);
    		fail("Should have thrown exception");
    	}catch(TransactionFailureException ex){
    		List<Person> list = getBC().listPersons();
    		assertTrue("Rollback failure", list.isEmpty());
    	}catch(Exception ex){
    		fail(ex.getMessage());
    	}
    }
    
    public void testTransactionSuccess(){
    	Person person1 = createPerson(1, "nick1", "prof1", "st1", 111);
    	Person person2 = createPerson(2, "nick2", "prof2", "st2", 222);
    	Person person3 = createPerson(3, "nick3", "prof3", "st3", 333);
    	try{
    		getBC().insertPersons(person1,person2,person3);
    		List<Person> list = getBC().listPersons();
    		assertTrue("Commit failure", list.size() == 3);
    	}catch(Exception ex){
    		fail("Should have made ​​successful operation");
    		ex.printStackTrace();
    	}
    	
    	//remove persons
    	getBC().deletePerson(person1.getId());
    	getBC().deletePerson(person2.getId());
    	getBC().deletePerson(person3.getId());
    }
    
    private SpringTransactionalBC getBC(){
    	return (SpringTransactionalBC) springContext.getBean("bc");
    }
}
