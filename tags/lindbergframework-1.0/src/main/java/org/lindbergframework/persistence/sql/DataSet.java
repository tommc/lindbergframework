package org.lindbergframework.persistence.sql;

import java.sql.SQLException;


/**
 * Interface that defines the contract for persistence data set results.
 *  
 * @author Victor Lindberg
 *
 */
public interface DataSet {
	
    /**
     * Moves the cursor forward one row from its current position.
     * 
     * @return true if the new current row is valid or  
     * false if there are no more rows.
     * 
     * @throws SQLException database access error or this method data set is closed.
     */
	public boolean next() throws SQLException;
	
	/**
	 * Moves the cursor previous one row from its current position.
	 * 
	 * @return true if the new current row is valid; 
	 * false if there are no more rows.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public boolean previous() throws SQLException;
	
	/**
	 * Close this data set.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public void close() throws SQLException;
	
	/**
	 * Get the value of specified colunm.
	 * 
	 * @param columnName column name.
	 * 
	 * @return column value.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public Object getValue(String columnName) throws SQLException;
	
	/**
	 * Get the value of specified colunm.
	 * 
	 * @param columnIndex coulmn index.
	 * 
	 * @return column value.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public Object getValue(int columnIndex) throws SQLException;
	
	/**
	 * Get the real target result object from this data set. 
	 * Target result object is the object that represents the final result.
	 * @param <E> expected type.
	 * 
	 * @return object that represents the final result.
	 */
	public <E> E getResultTarget();
	
	/**
	 * Checks if the cursor points to the before first position.
	 * 
	 * @return true if the cursor points to the before first position
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public boolean isBeforeFirst() throws SQLException;
    
	/**
	 * Checks if the cursor points to the after last position.
	 * 
	 * @return true if the cursor points to the after last position
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public boolean isAfterLast() throws SQLException;
 
	/**
	 * Checks if the cursor points to the first position.
	 * 
	 * @return true if the cursor points to the first position
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public boolean isFirst() throws SQLException;
 
	/**
	 * Checks if the cursor points to the last position.
	 * 
	 * @return true if the cursor points to the last position
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public boolean isLast() throws SQLException;
    
	/**
	 * Points the cursor on before first position.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public void beforeFirst() throws SQLException;

	/**
	 * Points the cursor on after last position.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public void afterLast() throws SQLException;

	/**
	 * Points the cursor on first position.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public boolean first() throws SQLException;

	/**
	 * Points the cursor on last position.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public boolean last() throws SQLException;

	/**
	 * Get the index of current row. The first row is number 1. 
	 * 
	 * @return index of current row. 0 if there is no current row
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public int getIndexRow() throws SQLException;
	
	/**
	 * Get meta data from this data set.
	 * 
	 * @return meta data from this data set.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public DataSetMetaDada getMetaData() throws SQLException;
    

}
