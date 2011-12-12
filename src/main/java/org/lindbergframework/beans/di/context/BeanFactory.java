package org.lindbergframework.beans.di.context;

import org.lindbergframework.beans.di.DependencyManager;
import org.lindbergframework.exception.BeanNotFoundException;

/**
 * 
 * Interfaces that defines a factory that creates and returns bean instances 
 * with dependencies solved and injected.
 * 
 * @author Victor Lindberg
 *
 */
public interface BeanFactory {
	
    /**
     * Get a instance bean from lindberg IOC context.
     * 
     * @param <E> type of bean expected.
     * @param id bean id.
     * @param constructorArgs bean contructor args.
     * @return instance of bean.
     * @throws BeanNotFoundException bean with specified id not found.
     */
	public <E> E getBean(String id, Object... constructorArgs) throws BeanNotFoundException;
	
	/**
	 * Checks if this factory constains a bean with the specified id.
	 * 
	 * @param id bean id.
	 * 
	 * @return true if contains bean with the specified id.
	 */
	public boolean containsBean(String id);
	
	/**
	 * Checks if the bean with the id specified is a singleton.
	 * 
	 * @param id bean id.
	 * @return true if the bean with the id specified is a singleton.
	 * @throws BeanNotFoundException bean with specified id not found.
	 */
	public boolean isSingleton(String id) throws BeanNotFoundException;
	
	/**
	 * Get class type of bean with the specified id.
	 * 
	 * @param id bean id.
	 * 
	 * @return class type of bean eith the specified id.
	 * 
	 * @throws BeanNotFoundException bean with specified id not found.
	 */
	public Class getType(String id) throws BeanNotFoundException;
	
	/**
	 * Configures the dependency manager implementation.
	 * 
	 * @param dependencyManager dependency manager implementation for this factory.
	 */
	public void setDependencyManager(DependencyManager dependencyManager);
	
	/**
	 * Get the dependency manager implementation for this factory.
	 * 
	 * @return dependency manager implementation.
	 */
	public DependencyManager getDependencyManager();
	
	/**
	 * configures the bean base packages in the lindberg IOC context for this bean factory.
	 * 
	 * @param basePackages bean basepackages of lindberg IOC context.
	 */
	public void loadBasepackage(String... basePackages);
	

}
