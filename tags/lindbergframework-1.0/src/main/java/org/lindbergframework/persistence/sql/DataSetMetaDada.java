package org.lindbergframework.persistence.sql;

import java.sql.SQLException;

/**
 * interface that defines the contract for data set meta data implementations.
 * 
 * @author Victor Lindberg
 *
 */
public interface DataSetMetaDada {
	
    /**
     * Get the number of columns from data set.
     * 
     * @return number of columns from data set.
     * 
     * @throws SQLException database access error or this method data set is closed.
     */
	public int getColumnCount() throws SQLException;
	
	/**
     * Get the real target meta data object from this meta data. 
     * Target meta data object is the object that represents the final meta data.
     * @param <E> expected type.
     * 
     * @return object that represents the final meta data.
     */
	public Object getTargetMetaData();
	
	/**
	 * Get the column name to specified index.
	 * 
	 * @param columnIndex index of column.
	 * 
	 * @return column name to specified index.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public String getColumnName(int columnIndex) throws SQLException;
	
	/**
	 * Get the column label to specified index.
	 * 
	 * @param columnIndex index of column.
	 * 
	 * @return column label to specified index.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public String getColumnLabel(int column) throws SQLException;
	
	/**
	 * Get the column's table's schema to specified index.
	 * 
	 * @param columnIndex index of column.
	 * 
	 * @return column's table's schema to specified index.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public String getSchemaName(int column) throws SQLException;
	
	/**
	 * Get the column's table to specified index.
	 * 
	 * @param columnIndex index of column.
	 * 
	 * @return column's table to specified index.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public String getTableName(int column) throws SQLException;
	
	/**
	 * Get the column's type to specified index.
	 * 
	 * @param columnIndex index of column.
	 * 
	 * @return SQL type from java.sql.Types to specified column.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public int getColumnType(int column) throws SQLException;
	
	/**
	 * Get the column's type to specified index.
	 * 
	 * @param columnIndex index of column. 1 to fisrt column;  to first column...
	 * 
	 * @return type name used by the database. If the column type is a user-defined type, 
	 * then a fully-qualified type name is returned.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public String getColumnTypeName(int column) throws SQLException;
	
	/**
	 * Get the column´s fully-qualified name of the Java class to specified index. 
	 * 
	 * @param columnIndex index of column. 1 to fisrt column;  to first column...
	 * 
	 * @return column´s fully-qualified name of the Java class to specified index.
	 * 
	 * @throws SQLException database access error or this method data set is closed.
	 */
	public String getColumnClassName(int column) throws SQLException;

}
