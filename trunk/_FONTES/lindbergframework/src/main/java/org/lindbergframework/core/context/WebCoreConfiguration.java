package org.lindbergframework.core.context;

import javax.servlet.ServletContext;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface WebCoreConfiguration extends CoreConfiguration{
    
    public static final String CONFIG_LOCATION_PARAM = "lindbergConfigLocation";
    public static final String CONFIG_CLASS_PARAM = "lindbergConfigClass";
    public static final String DEFAULT_CONFIG_LOCATION = "lindberg-config.xml"; 
    
    
    public WebCoreConfiguration initialize(String configResource, ServletContext servletContext);

}
