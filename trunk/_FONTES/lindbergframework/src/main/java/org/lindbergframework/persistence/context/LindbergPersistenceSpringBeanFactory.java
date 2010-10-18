package org.lindbergframework.persistence.context;

import org.lindbergframework.spring.SpringBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring bean factory extension for lindberg persistence module.
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergPersistenceSpringBeanFactory extends SpringBeanFactory{
	
    /**
     * singleton instance of factory.
     */
    private static LindbergPersistenceSpringBeanFactory instance;
	
    /**
     * default spring persistence configuration file.
     */
	private static final String[] defaultConf = new String[] {"org\\lindbergframework\\spring\\conf\\persistenceContext.xml"};
	
	private LindbergPersistenceSpringBeanFactory(ApplicationContext applicationContext){
		super(applicationContext);
	}
	
	/**
	 * Get singleton instance of facotry.
	 * 
	 * @return singleton instance of factory.
	 */
	public static LindbergPersistenceSpringBeanFactory getInstance(){
	   if (instance == null){
		   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(defaultConf);
		   instance = new LindbergPersistenceSpringBeanFactory(context);
	   }
	   
	   return instance;
	}
	
	public static LindbergPersistenceSpringBeanFactory initDefaultContext(){
		return getInstance();
	}
	
	public LindbergPersistenceSpringBeanFactory reInitContext(){
		instance = null;
		
		return getInstance();
	}
	
	
}
