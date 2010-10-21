package org.lindbergframework.core.context;

import javax.servlet.ServletContext;

import org.lindbergframework.util.ResourceUtil;

/**
 * Core configuration extension to work in the web context.
 * 
 * The XML schema  is defined in http://www.lindbergframework.org/schema/lindberg-config.xsd
 * 
 * @author Victor Lindberg
 *
 */
public class WebClassPathXmlCoreConfiguration extends ClassPathXmlCoreConfiguration 
       implements WebCoreConfiguration{
    
    public WebClassPathXmlCoreConfiguration(){
        //
    }
    
    /**
     * {@inheritDoc}
     */
    public WebClassPathXmlCoreConfiguration initialize(String configResource,
        ServletContext servletContext) {
       initialize(ResourceUtil.getInputStream(configResource));
       return this;
    }

}
