package org.lindbergframework.persistence.sql;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class ResultSetColumn {
    
    private String name;
    private Object value;
    private int index;
    
	public ResultSetColumn(String name, Object value, int index) {
		this.name = name;
		this.value = value;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

}
