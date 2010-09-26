package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.persistence.context.LinpConfiguration;
import org.lindbergframework.validation.IExecutorValidationItems;
import org.lindbergframework.validation.Item;
import org.lindbergframework.validation.executors.factory.ExecutorFactory;
import org.lindbergframework.validation.factory.ValidationFactory;

/**
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractCoreConfiguration extends ConfigurationRepository implements CoreConfiguration{
    
    protected static final String LINP_CONFIGURATION_KEY = "linpConfiguration";
    
    public AbstractCoreConfiguration(){
        //
    }

    @AllowIfContextActive
    public String getDIBasePackage() {
        return getConfigValue(CONFIG_PROPERTY_DI_BASEPACKAGE);
    }

    @AllowIfContextActive
    public BeanFactory getBeanFactory() {
        return getConfigValue(CONFIG_PROPERTY_BEAN_FACTORY);
    }
    
    @AllowIfContextActive
    public LinpConfiguration getLinpConfiguration() {
        return getConfigValue(LINP_CONFIGURATION_KEY);
    }
    
    protected void setDiBasePackage(String diBasePackage) {
        registerProperty(CONFIG_PROPERTY_DI_BASEPACKAGE, diBasePackage);
    }

    protected void setBeanFactory(BeanFactory beanFactory) {
        registerProperty(CONFIG_PROPERTY_BEAN_FACTORY, beanFactory);
    }
    
    protected void setLinpConfiguration(LinpConfiguration linpConfiguration){
        registerProperty(LINP_CONFIGURATION_KEY, linpConfiguration);
    }
    
    public <E> E getPropertyValue(String key) {
        return getConfigValue(key);
    }
    
    public void validate() throws InvalidConfigurationException {
        //
    }

}
