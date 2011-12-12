package org.lindbergframework.validation.configuration;

import java.io.InputStream;

import org.lindbergframework.core.configuration.ConfigurationRepository;
import org.lindbergframework.core.context.AllowIfContextActive;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.util.ArrayUtil;
import org.lindbergframework.util.LogUtil;
import org.lindbergframework.util.ResourceUtil;
import org.lindbergframework.validation.context.LindbergSpringValidationsBeanFactory;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public abstract class AbstractValidationConfigurarion extends ConfigurationRepository implements ValidationConfiguration{
    
    public AbstractValidationConfigurarion() {
        //
    }

    public void setExtensionFilePathToExternalBeansValidation(String extensionFilePathToExternalBeansValidation) {
        registerProperty(CONFIG_PROPERTY_EXTENSION_FILE_PATH_EXTERNAL_BEANS_VALIDATION, 
                            extensionFilePathToExternalBeansValidation);
    }
    
    @AllowIfContextActive
    public String getExtensionFilePathToExternalBeansValidation() {
        return super.getPropertyValue(CONFIG_PROPERTY_EXTENSION_FILE_PATH_EXTERNAL_BEANS_VALIDATION);
    }
    
    public void validate() throws InvalidConfigurationException {
        String extensionFilePathBeansValidation = getExtensionFilePathToExternalBeansValidation();
        if (extensionFilePathBeansValidation != null){
            InputStream input = ResourceUtil.getInputStream(extensionFilePathBeansValidation);
            if (input == null)
                throw new InvalidConfigurationException("Invalid extension file path to external beans validation");
        }
    }
    
    public void initializeContext() {
        LogUtil.logInfo("Initializing Lindberg Validation Context");
        validate();
        String extensionFilePathBeansValidation = getExtensionFilePathToExternalBeansValidation();
        if (extensionFilePathBeansValidation != null)
            LindbergSpringValidationsBeanFactory.initAdditionalContext(ArrayUtil.toArray(extensionFilePathBeansValidation));
        LogUtil.logInfo("Lindberg Validation Context initialized");
    }
    
}
