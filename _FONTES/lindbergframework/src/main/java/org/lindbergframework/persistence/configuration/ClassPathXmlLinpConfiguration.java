package org.lindbergframework.persistence.configuration;

import org.lindbergframework.util.ResourceUtil;


/**
 * Linp configuration implementation for configuration file on class path.
 * 
 * The XML schema  is defined in http://www.lindbergframework.org/schema/lindberg-config.xsd
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
