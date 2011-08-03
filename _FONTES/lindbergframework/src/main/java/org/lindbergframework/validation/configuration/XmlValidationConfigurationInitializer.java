package org.lindbergframework.validation.configuration;

import org.lindbergframework.core.configuration.ConfigurationInitializer;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Validation;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public interface XmlValidationConfigurationInitializer extends ConfigurationInitializer{
    
    /**
     * initializes the lindberg validation configuration.
     *  
     * @param validationConfig xml node.
     */
    public void initialize(Validation validationConfig);

}
