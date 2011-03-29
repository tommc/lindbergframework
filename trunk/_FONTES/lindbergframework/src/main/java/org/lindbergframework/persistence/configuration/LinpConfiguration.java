package org.lindbergframework.persistence.configuration;

import java.sql.Types;

import org.lindbergframework.core.configuration.Configuration;
import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.transaction.TransactionManager;

/**
 * 
 * Configuration interface extension of lindberg persistence.
 *  
 * @author Victor Lindberg
 *
 */
public interface LinpConfiguration extends Configuration{
	
    //config properties
    /**
     * Configuration property name for cursor type.
     */
	public static final String CONFIG_PROPERTY_CURSOR_TYPE =  "lindberg.persistence.IntegerCursorType";
	
	/**
	 * Configuration property name for transaction manager.
	 */
	public static final String CONFIG_PROPERTY_TRANSACTION_MANAGER =  "lindberg.persistence.TransactionManager";
	
	/**
	 * Configuration property name for sql command resolver.
	 */
	public static final String CONFIG_PROPERTY_SQL_COMMAND_RESOLVER =  "lindberg.persistence.SqlCommandResolver";
	
	/**
	 * Configuration property name for default schema.
	 */
	public static final String CONFIG_PROPERTY_DEFAULT_SCHEMA =  "lindberg.persistence.DefaultSchema";
	
	//default values
	/**
	 * default cursor type.
	 */
	public static final Integer DEFAULT_INTEGER_CURSOR_TYPE = Types.OTHER;
	
	/**
	 * default sql command resolver bean id.
	 */
	public static final String DEFAULT_SQL_COMMAND_RESOLVER_ID = "defaultSqlCommandResolver";
	
	/**
	 * default transaction manager bean id on spring linp context.
	 */
	public static final String DEFAULT_ID_TRANSACTION_MANAGER = "defaultLinpTransactionManager";
	
	/**
	 * Get the DataSourceConfig for this configuration.
	 * 
	 * @return dataSourceConfig instance configured.
	 */
	public DataSourceConfig getDataSourceConfig();
	
	/**
	 * Get the cursor type defined on this configuration.
	 * 
	 * @return the cursor type defined.
	 */
	public Integer getCursorType();
	
	/**
	 * Get the transaction manager defined on this configuration.
	 * 
	 * @return the transaction manager type defined.
	 */
	public TransactionManager getTransactionManager();
	
	/**
	 * Get the sql command resolver defined on this configuration.
	 * 
	 * @return the sql command resolver type defined.
	 */
	public SqlCommandResolver getSqlCommandResolver();
	
	/**
	 * Get the default schema defined on this configuration.
	 * 
	 * @return the default schema type defined.
	 */
	public String getDefaultSchema();
	
}
