package org.lindbergframework.persistence.context;

import org.lindbergframework.spring.SpringBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergPersistenceSpringBeanFactory extends SpringBeanFactory{
	
    private static LindbergPersistenceSpringBeanFactory instance;
	
	private static final String[] defaultConf = new String[] {"org\\lindbergframework\\spring\\conf\\persistenceContext.xml"};
	
	private LindbergPersistenceSpringBeanFactory(ApplicationContext applicationContext){
		super(applicationContext);
	}
	
	/**
	 * retorna a instancia da fábrica 
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
	
	/**
	 * 
	 * Reinicializa o contexto configurado
	 * 
	 * @return
	 */
	public LindbergPersistenceSpringBeanFactory reInitContext(){
		instance = null;
		
		return getInstance();
	}
	
	
}
