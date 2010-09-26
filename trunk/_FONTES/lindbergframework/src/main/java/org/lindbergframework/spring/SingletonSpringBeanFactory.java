package org.lindbergframework.spring;

import org.lindbergframework.exception.LindbergException;
import org.springframework.context.ApplicationContext;


/**
 * Fábrica de beans do spring é um singleton que trabalha mantendo uma única instancia de si mesma.<br>
 * Para obter uma instancia dessa classe inicialize o <br>
 * contexto do spring usando o método {@link #initContext(ApplicationContext)} <br>
 * e a partir daí chame  o método {@link #getInstance()} para obter a instancia 
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
		   		"é necessáro que o context seja inicializado através do método initContext");	
		}
		
		return instance;
	}
	
	public static SingletonSpringBeanFactory initContext(ApplicationContext applicationContext){
		instance = new SingletonSpringBeanFactory(applicationContext);
		
		return instance;
	}
	
}

