package org.lindbergframework.persistence.context;

import java.sql.Types;

import org.lindbergframework.core.context.Configuration;
import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.sql.XmlSqlCommandResolver;
import org.lindbergframework.persistence.transaction.TransactionManager;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface LinpConfiguration extends Configuration{
	
    //config properties
	public static final String CONFIG_PROPERTY_CURSOR_TYPE =  "lindberg.persistence.IntegerCursorType";
	public static final String CONFIG_PROPERTY_TRANSACTION_MANAGER =  "lindberg.persistence.TransactionManager";
	public static final String CONFIG_PROPERTY_SQL_COMMAND_RESOLVER =  "lindberg.persistence.SqlCommandResolver";
	public static final String CONFIG_PROPERTY_DEFAULT_SCHEMA =  "lindberg.persistence.DefaultSchema";
	
	//default values
	public static final Integer DEFAULT_INTEGER_CURSOR_TYPE = Types.OTHER;
	public static final SqlCommandResolver DEFAULT_SQL_COMMAND_RESOLVER = new XmlSqlCommandResolver();
	public static final String DEFAULT_ID_TRANSACTION_MANAGER = "defaultLinpTransactionManager";
	
	public DataSourceConfig getDataSourceConfig();
	
	public Integer getCursorType();
	
	public TransactionManager getTransactionManager();
	
	public SqlCommandResolver getSqlCommandResolver();
	
	public String getDefaultSchema();
	
}
