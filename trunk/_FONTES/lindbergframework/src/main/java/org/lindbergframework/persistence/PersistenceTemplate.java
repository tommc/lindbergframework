package org.lindbergframework.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.lindbergframework.persistence.beans.BeanPopulator;
import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlFunction;
import org.lindbergframework.persistence.sql.SqlOutCursorParam;
import org.lindbergframework.persistence.sql.SqlProcedure;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface PersistenceTemplate {
	
	//query
	public <E> List<E> execQuery(Class<E> clazz,String sqlId, Object... params);
	
	public <E> List<E> execSqlQuery(Class<E> clazz,String sql, Object... params);
	
    public <E> E execQueryForObject(Class<E> clazz,String sqlId, Object... params);
	
	public <E> E execSqlQueryForObject(Class<E> clazz,String sql, Object... params);
	
	//update
	public int execUpdate(String sqlId, Object... args);
	
	public int execSqlUpdate(String sql, Object... args);
	
	//callProcedure sqlId
	
	public Map callProcedure(String sqlId, SqlArg... args);
	
	public Map callProcedure(String sqlId, Map<String, Object> args);
	
	
	////callProcedure SqlProcedure
	
    public Map callProcedure(SqlProcedure procedure, SqlArg... args);
	
	public Map callProcedure(SqlProcedure procedure, Map<String, Object> args);
	
	
    //callFunction sqlId
	
	public Map callFunction(String sqlId, SqlArg... args);
	
	public Map callFunction(String sqlId, Map<String, Object> args);
	
	
	////callFunction SqlProcedure
	
    public Map callFunction(SqlFunction function, SqlArg... args);
	
	public Map callFunction(SqlFunction function, Map<String, Object> args);
	
    ////configure
	
	public void configureDefaultPopulator();
	
	public void configureDefaultDataSource();
	
	public void setDataSourceConfig(DataSourceConfig dataSourceConfig);
	
	public DataSourceConfig getDataSourceConfig();
	
	public DataSource getDataSource();
	
	public void setBeanPopulator(BeanPopulator beanPopulator);
	
	public BeanPopulator getBeanPopulator();
	
	public Connection getConnection() throws SQLException;

}
