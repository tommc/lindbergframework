package org.lindbergframework.core.configuration;

import java.util.ArrayList;
import java.util.List;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.core.context.AllowIfContextActive;
import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.persistence.configuration.LinpConfiguration;
import org.lindbergframework.validation.configuration.ValidationConfiguration;

/**
 * Abstract core configuration class that provides the base operations for core configuration implementations.
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractCoreConfiguration extends ConfigurationRepository implements CoreConfiguration{
    
    /**
     * lindberg persistence key in the values configurations repository. 
     */
    protected static final String LINP_CONFIGURATION_KEY = "linpConfiguration";
    
    /**
     * lindberg validation key in the values configurations repository. 
     */
    protected static final String VALIDATION_CONFIGURATION_KEY = "validationConfiguration";
    
    public AbstractCoreConfiguration(){
        //
    }

    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public String getDIBasePackage() {
        return super.getPropertyValue(CONFIG_PROPERTY_DI_BASEPACKAGE);
    }

    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public BeanFactory getBeanFactory() {
        return super.getPropertyValue(CONFIG_PROPERTY_BEAN_FACTORY);
    }
    
    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public LinpConfiguration getLinpConfiguration() {
        return super.getPropertyValue(LINP_CONFIGURATION_KEY);
    }
    
    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public ValidationConfiguration getValidationConfiguration() {
        return super.getPropertyValue(VALIDATION_CONFIGURATION_KEY);
    }

    protected void setDiBasePackage(String diBasePackage) {
        registerProperty(CONFIG_PROPERTY_DI_BASEPACKAGE, diBasePackage);
    }

    protected void setBeanFactory(BeanFactory beanFactory) {
        registerProperty(CONFIG_PROPERTY_BEAN_FACTORY, beanFactory);
    }
    
    public void setLinpConfiguration(LinpConfiguration linpConfiguration){
        registerProperty(LINP_CONFIGURATION_KEY, linpConfiguration);
    }
    
    public void setValidationConfiguration(ValidationConfiguration validationConfiguration){
        registerProperty(VALIDATION_CONFIGURATION_KEY, validationConfiguration);
    }
    
    /**
     * {@inheritDoc}
     */
    public void validate() throws InvalidConfigurationException {
        //
    }
    
    public void initializeContext() {
        CoreContext.getInstance().loadConfiguration(this);
    }
    
    public Configuration[] getModules() {
        List<Configuration> configurations = new ArrayList<Configuration>();
        Configuration linpConfiguration = getLinpConfiguration();
        if (linpConfiguration != null)
            configurations.add(linpConfiguration);
        
        Configuration valConfiguration = getValidationConfiguration();
        if (valConfiguration != null)
            configurations.add(valConfiguration);
        
        return configurations.toArray(new Configuration[configurations.size()]);
    }

}
