package org.lindbergframework.persistence.sql;

import java.util.List;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *
 */
public class ResultSetRow {
	
	private int index;
	
	private List<ResultSetColumn> columns;

	public ResultSetRow(int index, List<ResultSetColumn> columns) {
		this.index = index;
		this.columns = columns;
	}
	
	public int getIndex() {
		return index;
	}
	
	public List<ResultSetColumn> getColumns() {
		return columns;
	}
	
	public ResultSetColumn getColumn(int index){
		return columns.get(index);
	}
	
}
