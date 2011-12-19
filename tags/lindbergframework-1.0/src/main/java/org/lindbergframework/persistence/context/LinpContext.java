package org.lindbergframework.persistence.context;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import org.lindbergframework.core.context.AllowIfContextActive;
import org.lindbergframework.core.context.ComponentContext;
import org.lindbergframework.core.context.ContextProxy;
import org.lindbergframework.exception.IllegalStateContextException;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.PersistenceConfigurationException;
import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.PersistenceTemplate;
import org.lindbergframework.persistence.configuration.LinpConfiguration;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.transaction.TransactionManager;
import org.lindbergframework.util.LogUtil;
import org.lindbergframework.util.ProxyUtil;

/**
 * Context implementation for lindberg persistence. This context provides the resources
 * referring to persistence configurations and is used throughout the persistence module.
 * 
 * This context implementation is a singleton.
 * 
 * @author Victor Lindberg
 *
 */
public class LinpContext implements ComponentContext<LinpConfiguration>, LinpConfiguration{
	
    /**
     * singleton instance of context.
     */
	private static LinpContext instance;
	
	/**
	 * lindberg persistence configuration on this context.
	 */
	private LinpConfiguration configuration;
		
	protected LinpContext(){
		//
	}
	
	/**
	 * get singleton instance from this context.
	 * 
	 * @return singleton instance from this context.
	 */
	public static LinpContext getInstance(){
		if (instance == null){
		    try{
		       Class clazz = LinpContext.class;
			   instance = ProxyUtil.createProxy(LinpContext.class, new ContextProxy());
		    }catch(Exception ex){
		        throw new PersistenceConfigurationException("Init LinpContext Failed",ex);
		    }
		}
	
		return instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(LinpConfiguration configuration){
		if (configuration == null)
			throw new IllegalStateException("Could not to set linp configuration. Configuration is null");
			
		LinpContext context = getInstance();
		if (context != null && context.isActive())
			throw new PersistenceConfigurationException("The linp context can not be configured if it is active. " +
					"Close the linp context calling the close method before of to load a new configuration");
			
		context.activate(configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public Object getPropertyValue(String key) {
		return configuration.getPropertyValue(key);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isActive(){
		return getInstance().configuration != null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void finalize() {
		configuration = null;
		LogUtil.logInfo("Lindberg Persistence Context finalized");
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void verifyContext() throws IllegalStateContextException{
		if (! isActive())
			throw new IllegalStateContextException("Linp Context is not active. Call loadConfiguration static method in LinpContext to active it");
	}
	
	/**
	 * activates this context.
	 * 
	 * @param configuration configuration to active this context.
	 */
	protected void activate(LinpConfiguration configuration){
	    LogUtil.logInfo("Initializing Lindberg Persistence Context");
		configuration.validate();
		
		this.configuration = configuration;
		LogUtil.logInfo("Lindberg Persistence Context initialized");
	}

	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public Integer getCursorType() {
		return configuration.getCursorType();
	}

	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public DataSourceConfig getDataSourceConfig() {
		return configuration.getDataSourceConfig();
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public TransactionManager getTransactionManager(){
		return configuration.getTransactionManager();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public PersistenceTemplate getPersistenceTemplate() {
		return configuration.getPersistenceTemplate();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public String getDefaultSchema() {
	    return configuration.getDefaultSchema();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void validate() throws InvalidConfigurationException {
		if (configuration == null)
			throw new InvalidConfigurationException("Linp Configuration must be not null");
		
		configuration.validate();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initializeContext() {
	    throw new UnsupportedOperationException();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ComponentContext<?> getParentContext() {
		return this;
	}
}
