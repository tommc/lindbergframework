package org.lindbergframework.persistence.sql;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SqlArg {
	
	private String name;
	private Object value;
	
	public SqlArg(){
		//
	}
	

	public SqlArg(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public static SqlArg get(String name, Object value){
		return new SqlArg(name, value);
	}

}
