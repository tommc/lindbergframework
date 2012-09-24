package org.lindbergframework.persistence.sql;

/**
 * abstraction of sql command. Any database call command in lindberg persistence is a {@link SqlCommand}
 * 
 * @author Victor Lindberg
 *
 */
public abstract class SqlCommand {
	
    /**
     * command id.
     */
	private String id;
	
	public SqlCommand(){
		//
	}
	
	public SqlCommand(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Sql Command: "+id;
	}
	

}
