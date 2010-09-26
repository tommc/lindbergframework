package org.lindbergframework.persistence.impl;

import javax.sql.DataSource;

import org.lindbergframework.persistence.sql.LinpPreparedStatementSetter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LinpSpringJdbcTemplate extends JdbcTemplate{
	
	public LinpSpringJdbcTemplate(DataSource dataSource){
		super(dataSource);
	}
	
	public int update(String sql, Object... params) throws DataAccessException {
		return update(sql, createPreparedStatementSetter(sql, params));
	}
	
	public SqlRowSet queryForRowSet(String sql, Object... params) throws DataAccessException {
		return (SqlRowSet) query(sql, createPreparedStatementSetter(sql, params), new SqlRowSetResultSetExtractor());
	}
	
	protected PreparedStatementSetter createPreparedStatementSetter(String sql, Object... params){
	   return new LinpPreparedStatementSetter(sql,params);	
	}

}
