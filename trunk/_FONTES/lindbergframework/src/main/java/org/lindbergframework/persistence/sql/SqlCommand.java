package org.lindbergframework.persistence.sql;

/**
 * 
 * @author Victor Lindberg
 *
 */
public abstract class SqlCommand {
	
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
	
	@Override
	public String toString() {
		return "Id: "+id;
	}
	

}
