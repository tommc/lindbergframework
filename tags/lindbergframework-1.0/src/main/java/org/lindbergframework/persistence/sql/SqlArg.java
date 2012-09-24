package org.lindbergframework.persistence.sql;

/**
 * SQL argument for procedures and functions.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlArg {
	
    /**
     * argument name (parameter name in procedure or functions Signature).
     */
	private String name;
	
	/**
	 * argument value.
	 */
	private Object value;
	
	public SqlArg(){
		//
	}
	
	public SqlArg(String name, Object value) {
		setName(name);
		setValue(value);
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
