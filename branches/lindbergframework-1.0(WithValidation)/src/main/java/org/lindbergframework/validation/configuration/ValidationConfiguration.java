package org.lindbergframework.validation.configuration;

import org.lindbergframework.core.configuration.Configuration;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public interface ValidationConfiguration extends Configuration{
    
    //config properties
    /**
     * Configuration property name for extension file of spring beans to validation.
     */
    public static final String CONFIG_PROPERTY_EXTENSION_FILE_PATH_EXTERNAL_BEANS_VALIDATION =  "lindberg.validation.extensionFilePathBeansValidation";
    
    public String getExtensionFilePathToExternalBeansValidation();

}
