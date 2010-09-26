package org.lindbergframework.beans.di;

import org.lindbergframework.exception.InjectionFailedException;


/**
 * 
 * @author Victor Lindberg
 *
 */
public interface DependencyManager {
	
	public <E> E resolveDependecies(E bean) throws InjectionFailedException;
	
	public boolean containsDependecy(String idBean, Class dependecy);

}
