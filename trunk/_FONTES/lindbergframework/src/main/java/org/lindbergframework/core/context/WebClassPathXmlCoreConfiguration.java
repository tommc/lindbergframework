package org.lindbergframework.core.context;

import javax.servlet.ServletContext;

import org.lindbergframework.util.ResourceUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class WebClassPathXmlCoreConfiguration extends ClassPathXmlCoreConfiguration 
       implements WebCoreConfiguration{
    
    public WebClassPathXmlCoreConfiguration(){
        //
    }
    
    public WebClassPathXmlCoreConfiguration initialize(String configResource,
        ServletContext servletContext) {
       initialize(ResourceUtil.getInputStream(configResource));
       return this;
    }

}
