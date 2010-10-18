package org.lindbergframework.persistence.context;

import org.lindbergframework.core.context.AllowIfContextActive;
import org.lindbergframework.core.context.ConfigurationRepository;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.transaction.TransactionManager;
import org.lindbergframework.validation.IExecutorValidationItems;
import org.lindbergframework.validation.Item;
import org.lindbergframework.validation.executors.factory.ExecutorFactory;
import org.lindbergframework.validation.factory.ValidationFactory;

/**
 * abstract lindberg persistence configuration base for linp configuration
 * implementations. This configuration base uses extends {@link ConfigurationRepository}
 * to do cache of property configurations.
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractLinpConfiguration extends ConfigurationRepository implements LinpConfiguration{

    /**
     * data source configuration property key on repository.
     */
    protected static final String DATA_SOURCE_KEY = "datasource";
	
	public AbstractLinpConfiguration(){
	   //	
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public Integer getCursorType() {
		return getConfigValue(CONFIG_PROPERTY_CURSOR_TYPE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public DataSourceConfig getDataSourceConfig() {
		return getConfigValue(DATA_SOURCE_KEY);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public SqlCommandResolver getSqlCommandResolver() {
		return getConfigValue(CONFIG_PROPERTY_SQL_COMMAND_RESOLVER);
	}

	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public TransactionManager getTransactionManager() {
		return getConfigValue(CONFIG_PROPERTY_TRANSACTION_MANAGER);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public String getDefaultSchema() {
	    return getConfigValue(CONFIG_PROPERTY_DEFAULT_SCHEMA);
	}
	
	protected void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
		registerProperty(DATA_SOURCE_KEY, dataSourceConfig);
	}

	protected void setCursorType(Integer cursorType) {
		registerProperty(CONFIG_PROPERTY_CURSOR_TYPE, cursorType);
	}

	protected void setSqlCommandResolver(SqlCommandResolver sqlCommandResolver) {
		registerProperty(CONFIG_PROPERTY_SQL_COMMAND_RESOLVER, sqlCommandResolver);
	}
	
	protected void setTransactionManager(
			TransactionManager transactionManager) {
		registerProperty(CONFIG_PROPERTY_TRANSACTION_MANAGER, transactionManager);
	}
	
	protected void setDefaultSchema(String schema){
	    registerProperty(CONFIG_PROPERTY_DEFAULT_SCHEMA, schema);
	}

	/**
	 * load configuration.
	 * 
	 * @param configuration configuration.
	 */
	protected void load(LinpConfiguration configuration){
		setCursorType(configuration.getCursorType());
		setDataSourceConfig(configuration.getDataSourceConfig());
		setSqlCommandResolver(configuration.getSqlCommandResolver());
		setTransactionManager(configuration.getTransactionManager());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public <E> E getPropertyValue(String key) {
	    return getConfigValue(key);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void validate() throws InvalidConfigurationException {
		IExecutorValidationItems engine = ExecutorFactory.newExecutorValidationItems();
		try{
		   engine.addValidationForSeveralItems(ValidationFactory.newNotNull(), 
				       new Item(getMapKeys().get(DATA_SOURCE_KEY), "DataSource configuration is not defined"),
				       new Item(getMapKeys().get(CONFIG_PROPERTY_SQL_COMMAND_RESOLVER), 
				                CONFIG_PROPERTY_SQL_COMMAND_RESOLVER+" linp configuration key is not defined"));
		   engine.execute();
		}catch(ValidationException ex){
			throw new InvalidConfigurationException("Invalid Configuration",ex);
		}
	}
	
	
}
