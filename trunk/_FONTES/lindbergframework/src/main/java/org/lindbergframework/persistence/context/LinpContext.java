package org.lindbergframework.persistence.context;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.lindbergframework.core.context.AllowIfContextActive;
import org.lindbergframework.core.context.Context;
import org.lindbergframework.core.context.ContextProxy;
import org.lindbergframework.exception.IllegalStateContextException;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.PersistenceConfigurationException;
import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.transaction.TransactionManager;
import org.lindbergframework.util.LogUtil;
import org.lindbergframework.util.ProxyUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LinpContext implements Context<LinpContext,LinpConfiguration>, LinpConfiguration{
	
	private static LinpContext instance;
	private LinpConfiguration configuration;
		
	protected LinpContext(){
		//
	}
	
	public static LinpContext getInstance(){
		if (instance == null){
		    try{
		       Class clazz = LinpContext.class;
		       Method[] noProxyMethods = new Method[]{
		                            clazz.getDeclaredMethod("getInstance"),
                                    clazz.getDeclaredMethod("loadConfiguration", LinpConfiguration.class),
                                    clazz.getDeclaredMethod("verifyContext"),
                                    clazz.getDeclaredMethod("isActive"),
                                    clazz.getDeclaredMethod("validate"),
                                    clazz.getDeclaredMethod("close")};
		    
			   instance = ProxyUtil.createProxy(LinpContext.class, new ContextProxy(noProxyMethods));
		    }catch(Exception ex){
		        throw new PersistenceConfigurationException("Init LinpContext Failed",ex);
		    }
		}
	
		return instance;
	}
	
	public LinpContext loadConfiguration(LinpConfiguration configuration){
		if (configuration == null)
			throw new IllegalStateException("Could not to set linp configuration. Configuration is null");
			
		LinpContext context = getInstance();
		if (context != null && context.isActive())
			throw new PersistenceConfigurationException("The linp context can not be configured if it is active. " +
					"Close the linp context calling the close method before of to load a new configuration");
			
		context.activate(configuration);
		
		return context;
	}

	@AllowIfContextActive
	public Object getPropertyValue(String key) {
		return configuration.getPropertyValue(key);
	}
	
	public boolean isActive(){
		return getInstance().configuration != null;
	}
	
	public void close(){
		configuration = null;
		LogUtil.logInfo("Lindberg Persistence Context finalized");
	}
	
	public void verifyContext() throws IllegalStateContextException{
		if (! isActive())
			throw new IllegalStateContextException("Linp Context is not active. Call loadConfiguration static method in LinpContext to active it");
	}
	
	protected void activate(LinpConfiguration configuration){
	    LogUtil.logInfo("Initializing Lindberg Persistence Context");
		configuration.validate();
		
		this.configuration = configuration;
		LogUtil.logInfo("Lindberg Persistence Context initialized");
	}

	@AllowIfContextActive
	public Integer getCursorType() {
		return configuration.getCursorType();
	}

	@AllowIfContextActive
	public DataSourceConfig getDataSourceConfig() {
		return configuration.getDataSourceConfig();
	}

	@AllowIfContextActive
	public SqlCommandResolver getSqlCommandResolver() {
		return configuration.getSqlCommandResolver();
	}

	@AllowIfContextActive
	public DataSource getDataSource(){
		DataSourceConfig dataSourceConfig = getDataSourceConfig();
		if (dataSourceConfig  == null)
			throw new IllegalStateException("DataSourceConfig must be not null");
		
		return dataSourceConfig.getDataSource();
	}
	
	@AllowIfContextActive
	public TransactionManager getTransactionManager(){
		return configuration.getTransactionManager();
	};
	
	@AllowIfContextActive
	public String getDefaultSchema() {
	    return configuration.getDefaultSchema();
	}
	
	public void validate() throws InvalidConfigurationException {
		if (configuration == null)
			throw new InvalidConfigurationException("Linp Configuration must be not null");
		
		configuration.validate();
	}
}
