package org.lindbergframework.web.core.configuration;

import javax.servlet.ServletContext;

import org.lindbergframework.core.configuration.CoreConfiguration;

/**
 * interface that defines the contract for core configuration implementation to work in the web context.
 * 
 * @author Victor Lindberg
 *
 */
public interface WebCoreConfiguration extends CoreConfiguration{
    
    /**
     * deployment descriptor param key for lindberg configuration file location.
     */
    public static final String CONFIG_LOCATION_PARAM = "lindbergConfigLocation";
    
    /**
     * deployment descriptor param key for lindberg configuration implementation.
     */
    public static final String CONFIG_CLASS_PARAM = "lindbergConfigClass";
    
    /**
     * deployment descriptor param key for default lindberg configuration file name.
     */
    public static final String DEFAULT_CONFIG_FILE_NAME = "lindberg-config.xml"; 
    
   
    /**
     * initialize the configuration based in {@link ServletContext}.
     *  
     * @param configResource configuration file resource.
     * @param servletContext servlet context.
     * @return instance of initialized {@link WebCoreConfiguration}
     */
    public WebCoreConfiguration initialize(String configResource, ServletContext servletContext);

}
