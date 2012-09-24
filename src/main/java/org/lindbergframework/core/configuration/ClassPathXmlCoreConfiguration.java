package org.lindbergframework.core.configuration;

import org.lindbergframework.util.ResourceUtil;

/**
 * Extension of Xml Core Configuration that to work with class path recoursces.
 * 
 * The XML schema  is defined in http://www.lindbergframework.org/schema/lindberg-config.xsd
 * 
 * @author Victor Lindberg
 *
 */
public class ClassPathXmlCoreConfiguration extends XmlCoreConfiguration{
   
    /**
     * Default configuration file name in the class path for lindberg configuration.
     */
    public static final String DEFAULT_CLASS_PATH_XML_CORE_CONFIG = "lindberg-config.xml";
    
    public ClassPathXmlCoreConfiguration(){
        //
    }
    
    /**
     * create a ClassPathXmlCoreConfiguration
     * @param xmlResource lindberg configuration file in the class path.
     */
    public ClassPathXmlCoreConfiguration(String xmlResource){
        initialize(ResourceUtil.getInputStream(xmlResource));
    }

}
