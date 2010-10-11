package org.lindbergframework.core.context;

import java.lang.reflect.Method;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.exception.CoreConfigurationException;
import org.lindbergframework.exception.IllegalStateContextException;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.PersistenceConfigurationException;
import org.lindbergframework.persistence.context.LinpConfiguration;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.util.LogUtil;
import org.lindbergframework.util.ProxyUtil;

/**
 * Core configuration context implementation.
 * 
 * @author Victor Lindberg
 *
 */
public class CoreContext implements Context<CoreContext,CoreConfiguration>, CoreConfiguration{
   
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
              Method[] noProxyMethods = new Method[]{
                                 clazz.getDeclaredMethod("getInstance"),
                                 clazz.getDeclaredMethod("loadConfiguration", CoreConfiguration.class),
                                 clazz.getDeclaredMethod("verifyContext"),
                                 clazz.getDeclaredMethod("isActive"),
                                 clazz.getDeclaredMethod("validate"),
                                 clazz.getDeclaredMethod("close")};
              instance = ProxyUtil.createProxy(CoreContext.class, new ContextProxy(noProxyMethods));
           }catch(Exception ex){
               throw new PersistenceConfigurationException("Init CoreContext Failed",ex);
           }
        }
    
        return instance;
    }
    
    /**
     * {@inheritDoc}
     */
    public CoreContext loadConfiguration(CoreConfiguration configuration){
        if (configuration == null)
            throw new IllegalStateException("Could not to set core configuration. Configuration is null");
            
        CoreContext context = getInstance();
        if (context != null && context.isActive())
            throw new CoreConfigurationException("The core context can not be configured if it is active. " +
                    "Close the core context calling the close method before of to load a new configuration");
            
        context.activate(configuration);
        
        return context;
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
    public LinpConfiguration getLinpConfiguration() {
        return configuration.getLinpConfiguration();
    }

    /**
     * {@inheritDoc}
     */
    @AllowIfContextActive
    public <E> E getPropertyValue(String key) {
        return configuration.getPropertyValue(key);
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
    public void close() {
       if (LinpContext.getInstance().isActive()){
           LinpContext.getInstance().close();
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
            throw new IllegalStateContextException("Core Context is not active. Call loadConfiguration static method in CoreContext to active it");
    }
    
    /**
     * loads the other modules defined in configuration.
     * 
     * @param configuration configuration instance to load modules.
     */
    private void loadModules(CoreConfiguration configuration){
        LinpConfiguration linpConfiguration = configuration.getLinpConfiguration();
        if (linpConfiguration != null)
           LinpContext.getInstance().loadConfiguration(linpConfiguration);
    }

}
