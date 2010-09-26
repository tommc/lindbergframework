package org.lindbergframework.persistence.context;

import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.transaction.TransactionManager;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SimpleLinpConfiguration extends AbstractLinpConfiguration{
	
	public SimpleLinpConfiguration(){
		//
	}
	
	public void setCursorType(int cursorType) {
	   super.setCursorType(cursorType);
	}
	
	public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
	   super.setDataSourceConfig(dataSourceConfig);
	}
	
	public void setSqlCommandResolver(SqlCommandResolver sqlCommandResolver) {
	   super.setSqlCommandResolver(sqlCommandResolver);
	}
	
	public void setTransactionManager(
			TransactionManager transactionManager) {
	   super.setTransactionManager(transactionManager);
	}
	
	public void setDefaultSchema(String schema) {
	    super.setDefaultSchema(schema);
	}
	
}
