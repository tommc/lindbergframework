package org.lindbergframework.persistence.sql;

import java.sql.SQLException;


/**
 * 
 * @author Victor Lindberg
 *
 */
public interface DataSet {
	
	public boolean next() throws SQLException;
	
	public boolean previous() throws SQLException;
	
	public void close() throws SQLException;
	
	public Object getValue(String columnName) throws SQLException;
	
	public Object getValue(int columnIndex) throws SQLException;
	
	public <E> E getResultTarget();
	
	public boolean isBeforeFirst() throws SQLException;
    
	public boolean isAfterLast() throws SQLException;
 
	public boolean isFirst() throws SQLException;
 
	public boolean isLast() throws SQLException;
    
	public void beforeFirst() throws SQLException;

	public void afterLast() throws SQLException;

	public boolean first() throws SQLException;

	public boolean last() throws SQLException;

	public int getIndexRow() throws SQLException;
	
	public DataSetMetaDada getMetaData() throws SQLException;
    

}
