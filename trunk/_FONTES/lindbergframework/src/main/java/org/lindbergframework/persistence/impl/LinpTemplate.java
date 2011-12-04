package org.lindbergframework.persistence.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.exception.MappingProcedureFailedExcpetion;
import org.lindbergframework.exception.NoSuchSqlCommandException;
import org.lindbergframework.exception.NonUniqueRowException;
import org.lindbergframework.exception.PersistenceException;
import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.PersistenceTemplate;
import org.lindbergframework.persistence.TemplateBase;
import org.lindbergframework.persistence.beans.BeanPopulator;
import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlFunction;
import org.lindbergframework.persistence.sql.SqlProcedure;
import org.lindbergframework.persistence.sql.SqlRowDataSet;
import org.lindbergframework.persistence.translate.SqlSelectFieldsTranslator;
import org.lindbergframework.persistence.util.SqlTranslateUtil;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * Default Lindberg persistence template implementation. 
 * 
 * @author Victor Lindberg
 *
 */
@Bean("defaultLinpTemplate")
public class LinpTemplate extends TemplateBase 
									implements PersistenceTemplate{
	
	private LinpSpringJdbcTemplate jdbcTemplate;
	
	/**
	 * Creates a LinpTemplate with configured default values.
	 */
	public LinpTemplate(){
	   configureJdbcTemplate();
	}
	
	/**
	 * Creates a LinpTemplate with the specified {@link BeanPopulator}
	 * @param populator BeanPopulator implementation.
	 */
	public LinpTemplate(BeanPopulator populator){
		super(populator);
		configureJdbcTemplate();
	}
	
	/**
	 * Creates a LinpTemplate with the specified data source configuration.
	 * @param dsConfig data source configuration.
	 */
	public LinpTemplate(DataSourceConfig dsConfig){
		super(dsConfig);
		configureJdbcTemplate();
	}
	
	/**
	 * Creates a LinpTemplate with the specified bean populator and data source configuration.
	 * @param populator bean populator implementation.
	 * @param dsConfig data source configuration.
	 */
	public LinpTemplate(BeanPopulator populator, DataSourceConfig dsConfig){
		super(populator,dsConfig);
		configureJdbcTemplate();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
		super.setDataSourceConfig(dataSourceConfig);
		
		configureJdbcTemplate();
	}
	
	/**
	 * configures the default JdbcTemplate.
	 */
	private void configureJdbcTemplate(){
		jdbcTemplate = new LinpSpringJdbcTemplate(getDataSource());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <E> List<E> execSqlQuery(Class<E> clazz,String sql, Object... params) {
		sql = SqlTranslateUtil.translateSqlString(sql, new SqlSelectFieldsTranslator());
		try {
			SqlRowSet sqlRs = jdbcTemplate.queryForRowSet(sql, params);
			return populateBeans(clazz, new SqlRowDataSet(sqlRs));
		} catch (SQLException ex) {
			throw new PersistenceException(ex);
		} catch (BeanPopulateException ex) {
			throw new PersistenceException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public <E> E execSqlQueryForObject(Class<E> clazz,String sql, Object... params) throws NonUniqueRowException{
		List<E> listResult = execSqlQuery(clazz, sql, params);
		if (listResult.isEmpty())
			return null;
		
		if (listResult.size() != 1)
		    throw new NonUniqueRowException("Query returned more that one row, but it was expected only one");

		return listResult.get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	public int execSqlUpdate(String sql, Object... params) {
		return jdbcTemplate.update(sql, params);
	}

	/**
	 * {@inheritDoc}
	 */
	public <E> List<E> execQuery(Class<E> clazz, String sqlId, Object... params) {
		try {
			String sql = getSqlCommandResolver().getSqlStatement(sqlId).getStatement();
			return execSqlQuery(clazz, sql, params); 
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public <E> E execQueryForObject(Class<E> clazz,String sqlId, Object... params) throws NonUniqueRowException{
		try {
			String sql = getSqlCommandResolver().getSqlStatement(sqlId).getStatement();
			return execSqlQueryForObject(clazz, sql, params); 
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int execUpdate(String sqlId, Object... params) {
		try {
			String sql = getSqlCommandResolver().getSqlStatement(sqlId).getStatement();
			return execSqlUpdate(sql, params); 
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}
	
	/**
	 * Creates a {@link LinpProcedure} based on {@link SqlProcedure} parameter.
	 * 
	 * @param procedure {@link SqlProcedure} to create the {@link LinpProcedure}
	 * 
	 * @return {@link LinpProcedure} based on {@link SqlProcedure} parameter.
	 */
	public LinpProcedure createLinpProcedure(SqlProcedure procedure){
		try {
			if (procedure instanceof SqlFunction)
			   return new LinpProcedure(getDataSource(),(SqlFunction)procedure);
			else
				return new LinpProcedure(getDataSource(),procedure);
		} catch (SQLException ex) {
			MappingProcedureFailedExcpetion procedureFailedExcpetion = 
				new MappingProcedureFailedExcpetion("Mapping from Procedure or Function failed");
			procedureFailedExcpetion.addMessage(ex.getMessage());
			
			throw procedureFailedExcpetion;
		}
	}
	
	////////Procedures e Functions calls
	
	/**
	 * {@inheritDoc}
	 */
	//FUNCTION sqlFunction
	public Map callFunction(SqlFunction function, Map<String, Object> args) {
		return createLinpProcedure(function).execute(args, function.getSqlOutCursorParams());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Map callFunction(SqlFunction function, SqlArg... args) {
		return createLinpProcedure(function).execute(args,function.getSqlOutCursorParams());
	}
	
	/**
	 * {@inheritDoc}
	 */
	// FUNCTION - sqlId
	public Map callFunction(String sqlId, Map<String, Object> args) {
		try {
			SqlFunction function = getSqlCommandResolver().getSqlFunction(sqlId);
			return callFunction(function, args);
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);	
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Map callFunction(String sqlId, SqlArg... args) {
		try {
			SqlFunction function = getSqlCommandResolver().getSqlFunction(sqlId);
			return callFunction(function, args);
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	// PROCEDURE - SqlProcedure
	public Map callProcedure(SqlProcedure procedure, Map<String, Object> args) {
		return createLinpProcedure(procedure).execute(args,procedure.getSqlOutCursorParams());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Map callProcedure(SqlProcedure procedure, SqlArg... args) {
		return createLinpProcedure(procedure).execute(args,procedure.getSqlOutCursorParams());
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	//PROCEDURE - SqlId
	public Map callProcedure(String sqlId, Map<String, Object> args) {
		try {
			SqlProcedure procedure = getSqlCommandResolver().getSqlProcedure(sqlId);
			return callProcedure(procedure, args);
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Map callProcedure(String sqlId, SqlArg... args) {
		try {
			SqlProcedure procedure = getSqlCommandResolver().getSqlProcedure(sqlId);
			return callProcedure(procedure, args);
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataSource getDataSource() {
		return super.getDataSource();
	}
	
}
