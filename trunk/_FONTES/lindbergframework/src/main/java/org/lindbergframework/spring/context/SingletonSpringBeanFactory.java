package org.lindbergframework.spring.context;

import org.lindbergframework.exception.LindbergException;
import org.lindbergframework.spring.SpringBeanFactory;
import org.springframework.context.ApplicationContext;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class SingletonSpringBeanFactory extends SpringBeanFactory{
	
	private static SingletonSpringBeanFactory instance;
	
	private SingletonSpringBeanFactory(ApplicationContext appContext){
	   super(appContext);
	}
	
	public static SingletonSpringBeanFactory getInstance(){
		if (instance == null){
		   throw new LindbergException("N�o foi poss�vel acessar uma instancia de SingletonSpringBeanFactory. " +
		   		"� necess�ro que o context seja inicializado atrav�s do m�todo initContext");	
		}
		
		return instance;
	}
	
	public static SingletonSpringBeanFactory initContext(ApplicationContext applicationContext){
		instance = new SingletonSpringBeanFactory(applicationContext);
		
		return instance;
	}
	
}

