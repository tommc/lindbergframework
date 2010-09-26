package org.lindbergframework.core.context;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.exception.CoreConfigurationException;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.PersistenceConfigurationException;
import org.lindbergframework.persistence.context.LinpConfiguration;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.util.LogUtil;
import org.lindbergframework.util.ProxyUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class CoreContext implements Context<CoreContext,CoreConfiguration>, CoreConfiguration{
    
    private static CoreContext instance;
    private CoreConfiguration configuration;
    
    protected CoreContext(){
        //
    }
    
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

    @AllowIfContextActive
    public BeanFactory getBeanFactory() {
        return configuration.getBeanFactory();
    }

    @AllowIfContextActive
    public String getDIBasePackage() {
        return configuration.getDIBasePackage();
    }

    @AllowIfContextActive
    public LinpConfiguration getLinpConfiguration() {
        return configuration.getLinpConfiguration();
    }

    @AllowIfContextActive
    public <E> E getPropertyValue(String key) {
        return configuration.getPropertyValue(key);
    }

    public void validate() throws InvalidConfigurationException {
        if (configuration == null)
            throw new InvalidConfigurationException("Core Configuration must be not null");
        
        configuration.validate();
    }
    
    public void close() {
       if (LinpContext.getInstance().isActive()){
           LinpContext.getInstance().close();
       }
       
       configuration = null;
       LogUtil.logInfo("Lindberg Core Context finalized");
       
    }
    
    
    public boolean isActive() {
        return getInstance().configuration != null;
    }
    
    public void verifyContext() {
        if (! isActive())
            throw new CoreConfigurationException("Core Context is not active. Call loadConfiguration static method in CoreContext to active it");
    }
    
    private void loadModules(CoreConfiguration configuration){
        LinpConfiguration linpConfiguration = configuration.getLinpConfiguration();
        if (linpConfiguration != null)
           LinpContext.getInstance().loadConfiguration(linpConfiguration);
    }

}
