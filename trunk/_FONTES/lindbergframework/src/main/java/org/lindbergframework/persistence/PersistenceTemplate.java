package org.lindbergframework.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.lindbergframework.persistence.beans.BeanPopulator;
import org.lindbergframework.persistence.beans.MultLevelsBeanPopulator;
import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.sql.SqlFunction;
import org.lindbergframework.persistence.sql.SqlProcedure;

/**
 * interface that defines the persistente template contract.
 *  
 * @author Victor Lindberg
 *
 */
public interface PersistenceTemplate {
	
	//query
    /**
     * Executes a sql command for query.
     * 
     * @param clazz bean type expected for result mapping.
     * @param sqlId sql command id for query.
     * @param params arguments for query.
     * 
     * @return list with bean instances populated of clazz argument type.
     * 
     * @see BeanPopulator
     * @see MultLevelsBeanPopulator
     */
	public <E> List<E> execQuery(Class<E> clazz,String sqlId, Object... params);
	
	/**
	 * Executes a sql query.
	 * 
	 * @param clazz bean type expected for result mapping.
	 * @param sql sql query statement.
	 * @param params arguments for query.
	 * 
	 * @return list with bean instances populated of clazz argument type.
	 * 
	 * @see BeanPopulator
	 * @see MultLevelsBeanPopulator
	 */
	public <E> List<E> execSqlQuery(Class<E> clazz,String sql, Object... params);
	
	/**
	 * Executes a sql query for unique object as result.
	 * 
	 * @param clazz bean type expected for result mapping.
	 * @param sqlId sql command id for query.
	 * @param params arguments for query.
	 * 
	 * @return bean instance populated of clazz argument type or null if the result is empty.
	 * 
	 * @see BeanPopulator
	 * @see MultLevelsBeanPopulator
	 */
    public <E> E execQueryForObject(Class<E> clazz,String sqlId, Object... params);
	
    /**
     * Executes a sql query for unique object as result.
     * 
     * @param clazz bean type expected for result mapping.
     * @param sql sql query statement.
     * @param params arguments for query.
     * 
     * @return bean instance populated of clazz argument type or null if the result is empty.
     * 
     * @see BeanPopulator
     * @see MultLevelsBeanPopulator
     */
	public <E> E execSqlQueryForObject(Class<E> clazz,String sql, Object... params);
	
	//update
	/**
     * Executes a sql command for update.
     * 
     * @param sqlId sql command id for query.
     * @param params arguments for update.
     * 
     * @return number of affected records.
     */
	public int execUpdate(String sqlId, Object... args);
	
	/**
	 * Executes a sql update.
	 * 
	 * @param sql sql update statement.
	 * @param params arguments for update.
	 * 
	 * @return number of affected records.
	 */
	public int execSqlUpdate(String sql, Object... args);
	
	//callProcedure sqlId
	/**
	 * Call a sql command for a stored procedure.
	 * @param sqlId sql command id for stored procedure.
	 * @param args 'in' procedure arguments.
	 * 
	 * @return a map with out procedure parameters with the parameter name as key and the parameter value as map value.
	 */
	public Map callProcedure(String sqlId, SqlArg... args);
	
	/**
	 * Call a sql command for a stored procedure.
	 * @param sqlId sql command id for stored procedure.
	 * @param args map with 'in' procedure arguments the parameter name as key and the parameter value as map value. 
	 * 
	 * @return a map with out procedure parameters with the parameter name as key and the parameter value as map value.
	 */
	public Map callProcedure(String sqlId, Map<String, Object> args);
	
	
	////callProcedure SqlProcedure
	/**
	 * Call a stored procedure.
	 * 
	 * @param procedure instance of {@link SqlProcedure} to call. 
	 * @param args 'in' procedure arguments. 
	 * 
	 * @return a map with out procedure parameters with the parameter name as key and the parameter value as map value.
	 */
    public Map callProcedure(SqlProcedure procedure, SqlArg... args);
	
    /**
     * Call a stored procedure.
     * 
     * @param procedure instance of {@link SqlProcedure} to call. 
     * @param args map with 'in' procedure arguments the parameter name as key and the parameter value as map value. 
     * 
     * @return a map with out procedure parameters with the parameter name as key and the parameter value as map value.
     */
	public Map callProcedure(SqlProcedure procedure, Map<String, Object> args);
	
	
    //callFunction sqlId
	/**
     * Call a sql command for a stored function.
     * @param sqlId sql command id for stored function.
     * @param args 'in' function arguments.
     * 
     * @return a map with out function parameters with the parameter name as key and the parameter value as map value. 
     * The default function result object key in result map is SqlFunction.DEFAULT_RESULT_NAME constant.
     */
	public Map callFunction(String sqlId, SqlArg... args);
	
	/**
	 * Call a sql command for a stored function.
	 * @param sqlId sql command id for stored function.
	 * @param args map with 'in' procedure arguments the parameter name as key and the parameter value as map value.
	 * 
	 * @return a map with out function parameters with the parameter name as key and the parameter value as map value. 
	 * The default function result object key in result map is SqlFunction.DEFAULT_RESULT_NAME constant.
	 */
	public Map callFunction(String sqlId, Map<String, Object> args);
	
	
	////callFunction SqlProcedure
	/**
     * Call a sql stored function.
     * @param function instante of {@link SqlFunction} to call.
     * @param args 'in' function arguments.
     * 
     * @return a map with out function parameters with the parameter name as key and the parameter value as map value. 
     * The default function result object key in result map is SqlFunction.DEFAULT_RESULT_NAME constant.
     */
    public Map callFunction(SqlFunction function, SqlArg... args);
	
    /**
     * Call a sql stored function.
     * @param function instante of {@link SqlFunction} to call.
     * @param args map with 'in' procedure arguments the parameter name as key and the parameter value as map value.
     * 
     * @return a map with out function parameters with the parameter name as key and the parameter value as map value. 
     * The default function result object key in result map is SqlFunction.DEFAULT_RESULT_NAME constant.
     */
	public Map callFunction(SqlFunction function, Map<String, Object> args);
	
    ////configure
	/**
	 * configures in this template the default bean populator implementation.
	 */
	public void configureDefaultPopulator();
	
	/**
	 * configures in this template the default data source defined in linp configuration.
	 */
	public void configureDefaultDataSource();
	
	/**
	 * configures the data source to be used by this template .
	 * 
	 * @param dataSourceConfig data souce configuration to use.
	 */
	public void setDataSourceConfig(DataSourceConfig dataSourceConfig);
	
	/**
	 * get the data source configuration in this template.
	 * 
	 * @return data source configuration in this template.
	 */
	public DataSourceConfig getDataSourceConfig();
	
	/**
	 * Get the data source implementation that this template uses.
	 * 
	 * @return data source implementation that this template uses.
	 */
	public DataSource getDataSource();
	
	/**
	 * Configures the bean populator implementation to be used by this template.
	 * 
	 * @param beanPopulator bean populator implementation to use.
	 */
	public void setBeanPopulator(BeanPopulator beanPopulator);
	
	/**
	 * get the bean populator implementation that this template uses.
	 * 
	 * @return the bean populator implementation that this template uses
	 */
	public BeanPopulator getBeanPopulator();
	
	/**
	 * Get a {@link Connection} from configured data source.
	 *  
	 * @return connection instance.
	 * 
	 * @throws SQLException could not get connection.
	 */
	public Connection getConnection() throws SQLException;
	
	/**
	 * Get the configured {@link SqlCommandResolver} implementation.
	 * 
	 * @return the configured {@link SqlCommandResolver} implementation.
	 */
	public SqlCommandResolver getSqlCommandResolver();

}
