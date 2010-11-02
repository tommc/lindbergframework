package org.lindbergframework.spring.context;

import org.lindbergframework.exception.LindbergException;
import org.springframework.context.ApplicationContext;

/**
 * Spring bean factory that works as singleton instance.
 * 
 * @author Victor Lindberg
 *
 */
public class SingletonSpringBeanFactory extends SpringBeanFactory{
    
	/**
	 * singleton instance.
	 */
    private static SingletonSpringBeanFactory instance;
    
    private SingletonSpringBeanFactory(ApplicationContext appContext){
       super(appContext);
    }
    
    /**
     * get the singleton instance of factory.
     * @return singleton instance of factory.
     */
    public static SingletonSpringBeanFactory getInstance(){
		if (instance == null){
		   throw new LindbergException("Unable to access an instance of SingletonSpringBeanFactory. " +
		   		"Is necessary that the context is initialized by the initContext method");	
		}
		
		return instance;
	}
    
    /**
     * initializes the factory with the specified ApplicationContext.
     * @param applicationContext spring context.
     * @return singleton instance of factory.
     */
    public static SingletonSpringBeanFactory initContext(ApplicationContext applicationContext){
        instance = new SingletonSpringBeanFactory(applicationContext);
        
        return instance;
    }
    
}

