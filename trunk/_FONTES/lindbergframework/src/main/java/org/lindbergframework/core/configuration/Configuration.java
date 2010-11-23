package org.lindbergframework.core.configuration;

import org.lindbergframework.exception.InvalidConfigurationException;

/**
 * Interface that defines the contract for lindberg configuration.
 * 
 * @author Victor Lindberg
 *
 */
public interface Configuration {
	
    /**
     * validate the configuration.
     * 
     * @throws InvalidConfigurationException configuration is not valid.
     */
	public void validate() throws InvalidConfigurationException;
	
	/**
	 * Get a configuration property value.
	 * @param <E> configuration property value expected.
	 * @param key key of configuration property.
	 * @return configuration property value.
	 */
	public <E> E getPropertyValue(String key);
	
}
