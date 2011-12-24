package org.lindbergframework.beans.di;

import org.lindbergframework.exception.InjectionFailedException;


/**
 * Interface that defines the contract for a Dependency Manager inside of IOC context.
 * 
 * @author Victor Lindberg
 *
 */
public interface DependencyManager {
	
    /**
     * Resolve the dependecies for the bean.
     * 
     * @param <E> bean type.
     * @param bean bean instance.
     * @return bean with dependencies resolved.
     * 
     * @throws InjectionFailedException if injection dependency to fail.
     */
	public <E> E resolveDependecies(E bean) throws InjectionFailedException;
	
	/**
	 * Checks if a bean with the id defined contains the dependency for the class argument.
	 * 
	 * @param idBean bean id
	 * @param dependecy dependency class
	 * @return true if the bean with the defined id contains the dependency for the class argument.
	 */
	public boolean containsDependecy(String idBean, Class dependecy);

}
