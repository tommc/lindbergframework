package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.core.configuration.Configuration;
import org.lindbergframework.core.configuration.CoreConfiguration;
import org.lindbergframework.exception.CoreConfigurationException;
import org.lindbergframework.exception.IllegalStateContextException;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.PersistenceConfigurationException;
import org.lindbergframework.util.LogUtil;
import org.lindbergframework.util.ProxyUtil;

/**
 * Core configuration context implementation.
 * 
 * @author Victor Lindberg
 *
 */
public class CoreContext implements ComponentContext<CoreConfiguration>, CoreConfiguration{
   
    /**
     * core context instance.
     */
    private static CoreContext instance;
    
    /**
     * configuration instance.
     */
    private CoreConfiguration configuration;
    
    protected CoreContext(){
        //
    }
    
    /**
     * get the instance of context.
     * 
     * @return context instance.
     */
    public static CoreContext getInstance(){
        if (instance == null){
           try{
              Class clazz = CoreContext.class;
              instance = ProxyUtil.createProxy(CoreContext.class, new ContextProxy());
           }catch(Exception ex){
               throw new PersistenceConfigurationException("Init CoreContext Failed",ex);
           }
        }
    
        return instance;
    }
    
    /**
     * {@inheritDoc}
     */
    public void initialize(CoreConfiguration configuration){
        if (configuration == null)
            throw new IllegalStateException("Could not to set core configuration. Configuration is null");
            
        CoreContext context = getInstance();
        if (context != null && context.isActive())
            throw new CoreConfigurationException("The core context can not be configured if it is active. " +
                    "Close the core context calling the close method before of to load a new configuration");
            
        context.activate(configuration);
    }
    
    protected void activate(CoreConfiguration configuration){
        LogUtil.logInfo("Initializing Lindberg Core Context");
        configuration.validate();
        loadModules(configuration);
        this.configuration = configuration;
        LogUtil.logInfo("Lindberg Core Context initialized");
    }

    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public BeanFactory getBeanFactory() {
        return configuration.getBeanFactory();
    }
    
    @AllowIfContextActive
    public Configuration[] getModules() {
        return configuration.getModules();
    }

    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public String getDIBasePackage() {
        return configuration.getDIBasePackage();
    }

    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public <E> E getPropertyValue(String key) {
        return (E) configuration.getPropertyValue(key);
    }

    /**
     * {@inheritDoc}
     */
    public void validate() throws InvalidConfigurationException {
        if (configuration == null)
            throw new InvalidConfigurationException("Core Configuration must be not null");
        
        configuration.validate();
    }
    
    /**
	 * {@inheritDoc}
	 */
    public void finalize() {
    	if (! isActive())
    		return;
    	
    	Configuration[] modules = configuration.getModules();
    	for (Configuration module : modules){
    		ComponentContext context = module.getParentContext();
    		if (context.isActive())
    			context.finalize();
    	}
        
        configuration = null;
        LogUtil.logInfo("Lindberg Core Context finalized");
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isActive() {
        return getInstance().configuration != null;
    }
    
    /**
     * {@inheritDoc}
     */
    public void verifyContext() throws IllegalStateContextException{
        if (! isActive())
            throw new IllegalStateContextException("Core Context is not active. Call loadConfiguration static method in CoreContext or initializeContext static method in CoreConfiguration to active it");
    }
    
    /**
     * loads the other modules defined in configuration.
     * 
     * @param configuration configuration instance to load modules.
     */
    private void loadModules(CoreConfiguration configuration){
        Configuration[] configurations = configuration.getModules();
        for (Configuration moduleConfiguration : configurations)
            moduleConfiguration.initializeContext();
    }
    
    /**
	 * {@inheritDoc}
	 */
    public void initializeContext() {
        throw new UnsupportedOperationException("CoreContext must be initialized from the CoreConfiguration");
    }
    
    /**
	 * {@inheritDoc}
	 */
    public ComponentContext<?> getParentContext() {
    	return this;
    }

}
