package br.com.lindbergframework.spring;

import org.springframework.context.ApplicationContext;

import br.com.lindbergframework.exception.LindbergException;
import br.com.lindbergframework.spring.SpringBeanFactory;

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
		   throw new LindbergException("Não foi possível acessar uma instancia de SingletonSpringBeanFactory. " +
		   		"É necessáro que o context seja inicializado através do método initContext");	
		}
		
		return instance;
	}
	
	public static SingletonSpringBeanFactory initContext(ApplicationContext applicationContext){
		instance = new SingletonSpringBeanFactory(applicationContext);
		
		return instance;
	}
	
}

