package org.lindbergframework.beans.di.context;

import org.lindbergframework.beans.di.DependencyManager;
import org.lindbergframework.exception.BeanNotFoundException;

/**
 * 
 * Interfaces defines a factory that creates and returns bean instances 
 * with its dependencies solved and injected
 * 
 * @author Victor Lindberg
 *
 */
public interface BeanFactory {
	
	public <E> E getBean(String id) throws BeanNotFoundException;
	
	public <E> E getBean(String id, Object[] args) throws BeanNotFoundException;
	
	public boolean containsBean(String id);
	
	public boolean isSingleton(String id) throws BeanNotFoundException;
	
	public Class getType(String id) throws BeanNotFoundException;
	
	public void setDependencyManager(DependencyManager dependencyManager);
	
	public DependencyManager getDependencyManager();
	
	public void loadBasepackage(String... basePackages);
	

}
