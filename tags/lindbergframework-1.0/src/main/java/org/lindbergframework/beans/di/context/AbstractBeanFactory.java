package org.lindbergframework.beans.di.context;

import org.lindbergframework.beans.di.BeanMapper;
import org.lindbergframework.beans.di.DependencyManager;

/**
 * Abstract lindberg bean factory that provides base services
 * for real implementations of BeanFactory interface.
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractBeanFactory implements BeanFactory{
	
    /**
     * Bean mapper implementation.
     */
	private BeanMapper beanMapper;
	
	/**
	 * Dependency manager implementation to resolve bean dependencies.
	 */
	private DependencyManager dependencyManager;
	
	public AbstractBeanFactory(){
		//
	}

	public AbstractBeanFactory(BeanMapper beanMapper,DependencyManager dependencyManager){
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDependencyManager(DependencyManager dependencyManager) {
       this.dependencyManager = dependencyManager;		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public DependencyManager getDependencyManager() {
		return dependencyManager;
	}

	public BeanMapper getBeanMapper() {
		return beanMapper;
	}

	public void setBeanMapper(BeanMapper beanMapper) {
		this.beanMapper = beanMapper;
	}

}
