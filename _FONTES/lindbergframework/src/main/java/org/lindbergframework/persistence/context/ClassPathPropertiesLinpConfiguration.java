package org.lindbergframework.persistence.context;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ClassPathPropertiesLinpConfiguration extends AbstractLinpConfiguration 
									implements LinpConfiguration{
	private String propertiesConfigLocation;
	
	public ClassPathPropertiesLinpConfiguration(String propertiesConfigLocation){
		this.propertiesConfigLocation = propertiesConfigLocation;
	}
	
	public Object getPropertyValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
