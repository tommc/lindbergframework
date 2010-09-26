package org.lindbergframework.persistence.context;

import org.lindbergframework.util.ResourceUtil;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class ClassPathXmlLinpConfiguration extends XmlLinpConfiguration{
	
	public ClassPathXmlLinpConfiguration(){
		//
	}
	
	public ClassPathXmlLinpConfiguration(String xmlResource){
		initialize(ResourceUtil.getInputStream(xmlResource));
	}
	
	
}
