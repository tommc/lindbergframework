package org.lindbergframework.persistence.sql;

/**
 * Implementation of sql command for sql statements.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlStatement extends SqlCommand{
	
    /**
     * sql command statement.
     */
	private String statement;
	
	/**
	 * default constructor of {@link SqlStatement}.
	 */
	public SqlStatement(){
		//
	}
	
	/**
	 * creates a {@link SqlStatement} with the specified sql statement and command id.
	 * 
	 * @param statement sql statement.
	 * @param id command id.
	 */
	public SqlStatement(String statement,String id){
		this.statement = statement;
		setId(id);
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	

}
