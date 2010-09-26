package org.lindbergframework.core.context;

import org.lindbergframework.util.ResourceUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ClassPathXmlCoreConfiguration extends XmlCoreConfiguration{
    
    public static final String DEFAULT_CLASS_PATH_XML_CORE_CONFIG = "lindberg-config.xml";
    
    public ClassPathXmlCoreConfiguration(){
        //
    }
    
    public ClassPathXmlCoreConfiguration(String xmlResource){
        initialize(ResourceUtil.getInputStream(xmlResource));
    }

}
