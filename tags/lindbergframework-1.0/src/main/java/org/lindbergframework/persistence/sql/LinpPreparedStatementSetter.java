package org.lindbergframework.persistence.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lindbergframework.persistence.util.JdbcUtil;
import org.springframework.jdbc.core.ParameterDisposer;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;

/**
 * Lindberg PreparedStatementSetter implementation.
 * 
 * @author Victor Lindberg
 *
 */
public class LinpPreparedStatementSetter implements PreparedStatementSetter, ParameterDisposer{
	
	public PreparedStatementSetter preparedStatementSetter;
	
	public LinpPreparedStatementSetter(String sql, Object... params){
		int[] paramsSqlTypes = JdbcUtil.javaTypesToSqlParameterTypes(params);
		PreparedStatementCreatorFactory creator = new PreparedStatementCreatorFactory(sql,paramsSqlTypes);
		
		preparedStatementSetter = creator.newPreparedStatementSetter(params);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setValues(PreparedStatement ps) throws SQLException {
		preparedStatementSetter.setValues(ps);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void cleanupParameters() {
	   ((ParameterDisposer) preparedStatementSetter).cleanupParameters();	
	}

}
