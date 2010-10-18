package org.lindbergframework.persistence.context;

import org.lindbergframework.util.ResourceUtil;


/**
 * Linp configuration implementation for configuration file on class path.
 * 
 * @author Victor Lindberg
 *
 */
public class ClassPathXmlLinpConfiguration extends XmlLinpConfiguration{
	
	public ClassPathXmlLinpConfiguration(){
		//
	}
	
	/**
	 * Creates a ClassPathXmlLinpConfiguration using a xmlResource configuration on class path.
	 * 
	 * e.g. new ClassPathXmlLinpConfiguration(org/myproject/resource/lindberg-config.xml)
	 * e.g. new ClassPathXmlLinpConfiguration(org/myproject/resource/config-file-name.xml)
	 * 
	 * @param xmlResource configuration file on class path.
	 */
	public ClassPathXmlLinpConfiguration(String xmlResource){
		initialize(ResourceUtil.getInputStream(xmlResource));
	}
	
}
