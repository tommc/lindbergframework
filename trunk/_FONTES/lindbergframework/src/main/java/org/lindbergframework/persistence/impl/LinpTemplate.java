package org.lindbergframework.persistence.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.exception.MappingProcedureFailedExcpetion;
import org.lindbergframework.exception.NoSuchSqlCommandException;
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
import org.lindbergframework.persistence.util.TranslateUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * LinpTemplate (Lindberg Template)
 * 
 * @author Victor Lindberg
 *
 */
@Component("defaultLinpTemplate")
@Scope("prototype")
public class LinpTemplate extends TemplateBase 
									implements PersistenceTemplate{
	
	private LinpSpringJdbcTemplate jdbcTemplate;
	
	public LinpTemplate(){
	   configureJdbcTemplate();
	}
	
	public LinpTemplate(BeanPopulator populator){
		super(populator);
		configureJdbcTemplate();
	}
	
	public LinpTemplate(DataSourceConfig dsConfig){
		super(dsConfig);
		configureJdbcTemplate();
	}
	
	public LinpTemplate(BeanPopulator populator, DataSourceConfig dsConfig){
		super(populator,dsConfig);
		configureJdbcTemplate();
	}
	
	@Override
	public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
		super.setDataSourceConfig(dataSourceConfig);
		
		configureJdbcTemplate();
	}
	
	private void configureJdbcTemplate(){
		jdbcTemplate = new LinpSpringJdbcTemplate(getDataSource());
	}
	
	@SuppressWarnings("unchecked")
	public <E> List<E> execSqlQuery(Class<E> clazz,String sql, Object... params) {
		sql = TranslateUtil.translateString(sql, new SqlSelectFieldsTranslator());
		try {
			SqlRowSet sqlRs = jdbcTemplate.queryForRowSet(sql, params);
			return populateBeans(clazz, new SqlRowDataSet(sqlRs));
		} catch (SQLException ex) {
			throw new PersistenceException(ex);
		} catch (BeanPopulateException ex) {
			throw new PersistenceException(ex);
		}
	}

	public <E> E execSqlQueryForObject(Class<E> clazz,String sql, Object... params) {
		List<E> listResult = execSqlQuery(clazz, sql, params);
		if (listResult.isEmpty())
			return null;
		
		return listResult.get(0);
	}

	public int execSqlUpdate(String sql, Object... params) {
		return jdbcTemplate.update(sql, params);
	}

	public <E> List<E> execQuery(Class<E> clazz, String sqlId, Object... params) {
		try {
			String sql = getSqlCommandResolver().getSqlStatement(sqlId).getStatement();
			return execSqlQuery(clazz, sql, params); 
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}

	public <E> E execQueryForObject(Class<E> clazz,String sqlId, Object... params) {
		try {
			String sql = getSqlCommandResolver().getSqlStatement(sqlId).getStatement();
			return execSqlQueryForObject(clazz, sql, params); 
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}

	public int execUpdate(String sqlId, Object... params) {
		try {
			String sql = getSqlCommandResolver().getSqlStatement(sqlId).getStatement();
			return execSqlUpdate(sql, params); 
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}
	
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
	
	//FUNCTION sqlFunction
	public Map callFunction(SqlFunction function, Map<String, Object> args) {
		return createLinpProcedure(function).execute(args, function.getSqlOutCursorParams());
	}
	
	public Map callFunction(SqlFunction function, SqlArg... args) {
		return createLinpProcedure(function).execute(args,function.getSqlOutCursorParams());
	}
	
	// FUNCTION - sqlId
	public Map callFunction(String sqlId, Map<String, Object> args) {
		try {
			SqlFunction function = getSqlCommandResolver().getSqlFunction(sqlId);
			return callFunction(function, args);
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);	
		}
	}
	
	public Map callFunction(String sqlId, SqlArg... args) {
		try {
			SqlFunction function = getSqlCommandResolver().getSqlFunction(sqlId);
			return callFunction(function, args);
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}
	
	// PROCEDURE - SqlProcedure
	public Map callProcedure(SqlProcedure procedure, Map<String, Object> args) {
		return createLinpProcedure(procedure).execute(args,procedure.getSqlOutCursorParams());
	}
	
	public Map callProcedure(SqlProcedure procedure, SqlArg... args) {
		return createLinpProcedure(procedure).execute(args,procedure.getSqlOutCursorParams());
	}
	
	
	//PROCEDURE - SqlId
	public Map callProcedure(String sqlId, Map<String, Object> args) {
		try {
			SqlProcedure procedure = getSqlCommandResolver().getSqlProcedure(sqlId);
			return callProcedure(procedure, args);
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}
	
	public Map callProcedure(String sqlId, SqlArg... args) {
		try {
			SqlProcedure procedure = getSqlCommandResolver().getSqlProcedure(sqlId);
			return callProcedure(procedure, args);
		} catch (NoSuchSqlCommandException ex) {
			throw new PersistenceException(ex);
		}
	}
	
	@Override
	public DataSource getDataSource() {
		return super.getDataSource();
	}
	
}
