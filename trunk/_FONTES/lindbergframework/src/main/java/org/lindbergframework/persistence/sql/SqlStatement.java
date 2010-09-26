package org.lindbergframework.persistence.sql;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SqlStatement extends SqlCommand{
	
	private String statement;
	
	public SqlStatement(){
		//
	}
	
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
