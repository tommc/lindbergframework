package org.lindbergframework.persistence.impl;

import javax.sql.DataSource;

import org.lindbergframework.persistence.sql.LinpPreparedStatementSetter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * lindberg spring jdbcTemplate extension that uses
 * LinpPreparedStatementSetter as PreparedStatementSetter implementation.
 *  
 * @author Victor Lindberg
 *
 */
public class LinpSpringJdbcTemplate extends JdbcTemplate{
	
	public LinpSpringJdbcTemplate(DataSource dataSource){
		super(dataSource);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int update(String sql, Object... params) throws DataAccessException {
		return update(sql, createPreparedStatementSetter(sql, params));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SqlRowSet queryForRowSet(String sql, Object... params) throws DataAccessException {
		return (SqlRowSet) query(sql, createPreparedStatementSetter(sql, params), new SqlRowSetResultSetExtractor());
	}

	/**
	 * Create lindberg PreparedStatementSetter implementation for specified sql and parameters.
	 * 
	 * @param sql sql for PreparedStatementSetter.
	 * @param params parameters for PreparedStatementSetter.
	 * @return lindberg PreparedStatementSetter implementation for specified sql and parameters.
	 */
	protected PreparedStatementSetter createPreparedStatementSetter(String sql, Object... params){
	   return new LinpPreparedStatementSetter(sql,params);	
	}

}
