package org.lindbergframework.persistence.configuration;

import org.lindbergframework.core.configuration.ConfigurationRepository;
import org.lindbergframework.core.context.AllowIfContextActive;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.PersistenceTemplate;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.transaction.TransactionManager;

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
		return super.getPropertyValue(CONFIG_PROPERTY_CURSOR_TYPE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public DataSourceConfig getDataSourceConfig() {
		return super.getPropertyValue(DATA_SOURCE_KEY);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public SqlCommandResolver getSqlCommandResolver() {
		return super.getPropertyValue(CONFIG_PROPERTY_SQL_COMMAND_RESOLVER);
	}

	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public TransactionManager getTransactionManager() {
		return super.getPropertyValue(CONFIG_PROPERTY_TRANSACTION_MANAGER);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public PersistenceTemplate getPersistenceTemplate() {
		return super.getPropertyValue(CONFIG_PROPERTY_PERSISTENCE_TEMPLATE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public String getDefaultSchema() {
	    return super.getPropertyValue(CONFIG_PROPERTY_DEFAULT_SCHEMA);
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
	
	protected void setPersistenceTemplate(PersistenceTemplate persistenceTemplate){
		registerProperty(CONFIG_PROPERTY_PERSISTENCE_TEMPLATE, persistenceTemplate);
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
		setPersistenceTemplate(configuration.getPersistenceTemplate());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@AllowIfContextActive
	public <E> E getPropertyValue(String key) {
	    return super.getPropertyValue(key);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void validate() throws InvalidConfigurationException {
		InvalidConfigurationException ex = new InvalidConfigurationException();
		if (getMapKeys().get(DATA_SOURCE_KEY) == null)
			ex.addMessage("DataSource configuration is not defined");
		
		if (getMapKeys().get(CONFIG_PROPERTY_SQL_COMMAND_RESOLVER) == null)
			ex.addMessage(CONFIG_PROPERTY_SQL_COMMAND_RESOLVER+" linp configuration key is not defined");
		
		ex.throwIfContainsErrorMessages();
	}
	
	public void initializeContext() {
	    LinpContext.getInstance().loadConfiguration(this);
	}
}
