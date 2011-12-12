package org.lindbergframework.persistence.sql;

import org.lindbergframework.exception.InvalidSqlMappingException;
import org.lindbergframework.exception.NoSuchSqlCommandException;

/**
 * Interface that defines the contract for sql command resolver implementations.
 * 
 * @author Victor Lindberg
 *
 */
public interface SqlCommandResolver {
	
    /**
     * Get the {@link SqlStatement} with the specified id.
     * 
     * @param id {@link SqlStatement} id to search.
     * @return {@link SqlStatement} with the specified id.
     * 
     * @throws NoSuchSqlCommandException there are no sql statement for specified id.
     */
	public SqlStatement getSqlStatement(String id) throws NoSuchSqlCommandException;
	
	/**
	 * Get the {@link SqlProcedure} with the specified id.
	 * 
	 * @param id {@link SqlProcedure} id to search.
	 * @return {@link SqlProcedure} with the specified id.
	 * 
	 * @throws NoSuchSqlCommandException there are no sql procedure for specified id.
	 */
	public SqlProcedure getSqlProcedure(String id) throws NoSuchSqlCommandException;
	
	/**
	 * Get the {@link SqlFunction} with the specified id.
	 * 
	 * @param id {@link SqlFunction} id to search.
	 * @return {@link SqlFunction} with the specified id.
	 * 
	 * @throws NoSuchSqlCommandException there are no sql functions for specified id.
	 */
	public SqlFunction getSqlFunction(String id) throws NoSuchSqlCommandException;
	
	/**
	 * Validates the sql mapping configured on this sql command resolver.
	 * 
	 * @throws InvalidSqlMappingException invalid sql mapping.
	 */
	public void validate() throws InvalidSqlMappingException;
	
}
