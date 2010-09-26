package org.lindbergframework.beans.di.context;

import org.lindbergframework.beans.di.BeanMapper;
import org.lindbergframework.beans.di.DependencyManager;

/**
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractBeanFactory implements BeanFactory{
	
	private BeanMapper beanMapper;
	private DependencyManager dependencyManager;
	
	public AbstractBeanFactory(){
		//
	}
	
	public AbstractBeanFactory(BeanMapper beanMapper,DependencyManager dependencyManager){
		
	}
	
	public void setDependencyManager(DependencyManager dependencyManager) {
       this.dependencyManager = dependencyManager;		
	}
	
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
