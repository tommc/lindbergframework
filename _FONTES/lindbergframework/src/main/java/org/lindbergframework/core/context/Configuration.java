package org.lindbergframework.core.context;

import org.lindbergframework.exception.InvalidConfigurationException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface Configuration {
	
	public void validate() throws InvalidConfigurationException;
	
	public <E> E getPropertyValue(String key);
	
}
