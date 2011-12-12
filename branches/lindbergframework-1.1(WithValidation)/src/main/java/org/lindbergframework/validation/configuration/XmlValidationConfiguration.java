package org.lindbergframework.validation.configuration;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.lindbergframework.core.context.xml.util.XmlUtil;
import org.lindbergframework.exception.PersistenceConfigurationException;
import org.lindbergframework.exception.ValidationConfigurationException;
import org.lindbergframework.schema.TconfigProperty;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linv;




/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class XmlValidationConfiguration extends AbstractValidationConfigurarion implements XmlValidationConfigurationInitializer{

    private Linv configuration;
    
    public XmlValidationConfiguration(){
        //
    }
   
    public XmlValidationConfiguration(Linv validation) {
        initialize(validation);
    }
    
    public XmlValidationConfiguration(File xmlConfig){
       initialize(xmlConfig);
    }
    
    public XmlValidationConfiguration(URL xmlConfig){
        initialize(xmlConfig);
    }
    
    public XmlValidationConfiguration(InputStream xmlConfig){
        initialize(xmlConfig);
    }

    public void initialize(Linv validationConfig) {
        buildConfiguration(validationConfig);
    }

    public void initialize(File xmlConfig) {
        loadDocument(xmlConfig);
    }

    public void initialize(URL xmlConfig) {
        loadDocument(xmlConfig);
    }

    public void initialize(InputStream xmlConfig) {
        loadDocument(xmlConfig);
    }
    
    @Override
    public String getExtensionFilePathToExternalBeansValidation() {
        String extensionFilePathToExternalBeansValidation = super.getExtensionFilePathToExternalBeansValidation();
        if (extensionFilePathToExternalBeansValidation != null)
            return extensionFilePathToExternalBeansValidation;
        
        extensionFilePathToExternalBeansValidation = getPropertyValue(CONFIG_PROPERTY_EXTENSION_FILE_PATH_EXTERNAL_BEANS_VALIDATION);
        
        if (extensionFilePathToExternalBeansValidation == null)
            return null;
        
        setExtensionFilePathToExternalBeansValidation(extensionFilePathToExternalBeansValidation);
            
        return extensionFilePathToExternalBeansValidation;
    }
    
    private void loadDocument(Object xmlConfig) {
        verifyConfiguration();
        
        if (xmlConfig == null)
            throw new PersistenceConfigurationException(
                    "Invalid validation xmlConfig");
        
        try {
            buildConfiguration(XmlUtil.buildDocument(xmlConfig).getLinv());
        } catch (PersistenceConfigurationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ValidationConfigurationException(ex); 
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public <E> E getPropertyValue(String key) {
        E value = super.getPropertyValue(key);
        if (value != null)
            return value;
        
        TconfigProperty tconfigProperty = getPropertyFromKey(key);
        value = XmlUtil.getPropertyValue(tconfigProperty);
        
        return value;
    }
    
    protected TconfigProperty getPropertyFromKey(String key){
        if (configuration != null){
                TconfigProperty[] properties = configuration.getConfigPropertyArray();
                TconfigProperty property = XmlUtil.getPropertyFromKey(key, properties);
                
                return property;
        }
        
        return null;
    }
    
    private void verifyConfiguration(){
        if (configuration != null)
            throw new IllegalStateException("Configuration is already initialized");
    }
    
    private void buildConfiguration(Linv validation){
        verifyConfiguration();
        
        try {
            this.configuration = validation;
        } catch (Exception ex) {
            throw new PersistenceConfigurationException("Loading validation xml settings failed",ex);
        }
    }
    
}
