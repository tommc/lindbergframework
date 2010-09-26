package org.lindbergframework.persistence.sql;

import java.sql.SQLException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface DataSetMetaDada {
	
	public int getColumnCount() throws SQLException;
	
	public Object getTargetMetaData();
	
	public String getColumnName(int column) throws SQLException;
	
	public String getColumnLabel(int column) throws SQLException;
	
	public String getSchemaName(int column) throws SQLException;
	
	public String getTableName(int column) throws SQLException;
	
	public int getColumnType(int column) throws SQLException;
	
	public String getColumnTypeName(int column) throws SQLException;
	
	public String getColumnClassName(int column) throws SQLException;

}
