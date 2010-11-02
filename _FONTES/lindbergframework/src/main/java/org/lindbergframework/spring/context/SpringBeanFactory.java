package org.lindbergframework.spring.context;

import org.springframework.context.ApplicationContext;

/**
 * Spring Bean factory. 
 * 
 * 
 * @author Victor Lindberg
 * 
 */
public class SpringBeanFactory {

	/**
	 * spring bean context.
	 */
	private ApplicationContext applicationContext;

	/**
	 * creates a SpringBeanFactory with the specified ApplicationContext.
	 * 
	 * @param appContext spring application context.
	 */
	public SpringBeanFactory(ApplicationContext appContext) {
		applicationContext = appContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public boolean isContextConfigured(){
		return applicationContext != null;
	}

	/**
	 * Get a bean with the specified id.
	 * 
	 * @param beanId bean id.
	 * @return bean with the specified id.
	 */
	@SuppressWarnings("unchecked")
	public <E> E getBean(String beanId) {
	   return (E) applicationContext.getBean(beanId);
	}
	
	/**
	 * Get a bean with the specified id and constructor arguments.
	 * 
	 * @param beanId bean id.
	 * @param args constructor arguments.
	 * @return bean with the specified id.
	 */
	@SuppressWarnings("unchecked")
	public <E> E getBean(String beanId, Object... args) {
		   return (E) applicationContext.getBean(beanId,args);
		}
}
