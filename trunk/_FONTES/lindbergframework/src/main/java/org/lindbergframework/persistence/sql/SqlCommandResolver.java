package org.lindbergframework.persistence.sql;

import org.lindbergframework.exception.InvalidSqlMappingException;
import org.lindbergframework.exception.NoSuchSqlCommandException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface SqlCommandResolver {
	
	public SqlStatement getSqlStatement(String id) throws NoSuchSqlCommandException;
	
	public SqlProcedure getSqlProcedure(String id) throws NoSuchSqlCommandException;
	
	public SqlFunction getSqlFunction(String id) throws NoSuchSqlCommandException;
	
	public void validate() throws InvalidSqlMappingException;
	
}
