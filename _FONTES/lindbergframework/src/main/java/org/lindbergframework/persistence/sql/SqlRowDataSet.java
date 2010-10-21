package org.lindbergframework.persistence.sql;

import java.sql.SQLException;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SqlRowDataSet implements DataSet{
	
    private SqlRowSet rs;
	
	public SqlRowDataSet(SqlRowSet rs){
		this.rs = rs;
	}

	public void afterLast() throws SQLException {
       rs.afterLast();		
	}

	public void beforeFirst() throws SQLException {
	   rs.beforeFirst();	
	}

	public void close() throws SQLException {
	   throw new UnsupportedOperationException("Close operation is not supported. A SqlRowDataSet is a disconnected DataSet");
	}

	public boolean first() throws SQLException {
		return rs.first();
	}

	public int getIndexRow() throws SQLException {
		return rs.getRow();
	}

	@SuppressWarnings("unchecked")
	public <E> E getResultTarget() {
		return (E) rs;
	}

	public Object getValue(String columnName) throws SQLException {
		return rs.getObject(columnName);
	}

	public Object getValue(int columnIndex) throws SQLException{
		return rs.getObject(columnIndex);
	}

	public boolean isAfterLast() throws SQLException {
		return rs.isAfterLast();
	}

	public boolean isBeforeFirst() throws SQLException {
		return rs.isBeforeFirst();
	}

	public boolean isFirst() throws SQLException {
		return rs.isFirst();
	}

	public boolean isLast() throws SQLException {
		return rs.isLast();
	}

	public boolean last() throws SQLException {
		return rs.last();
	}

	public boolean next() throws SQLException {
		return rs.next();
	}

	public boolean previous() throws SQLException {
		return rs.previous();
	}
	
	public DataSetMetaDada getMetaData() throws SQLException {
		return new SqlRowDataSetMetaData(rs.getMetaData());
	}
	
	private class SqlRowDataSetMetaData implements DataSetMetaDada {
		private SqlRowSetMetaData md;

		public SqlRowDataSetMetaData(SqlRowSetMetaData md) {
			this.md = md;
		}

		public String getColumnClassName(int column) throws SQLException {
			return md.getColumnClassName(column);
		}

		public int getColumnCount() throws SQLException {
			return md.getColumnCount();
		}

		public String getColumnName(int columnIndex) throws SQLException {
			return md.getColumnName(columnIndex);
		}
		
		public String getColumnLabel(int column) throws SQLException {
			return md.getColumnLabel(column);
		}

		public int getColumnType(int column) throws SQLException {
			return md.getColumnType(column);
		}

		public String getColumnTypeName(int column) throws SQLException {
			return md.getColumnTypeName(column);
		}

		public String getSchemaName(int column) throws SQLException {
			return md.getSchemaName(column);
		}

		public String getTableName(int column) throws SQLException {
			return md.getTableName(column);
		}

		public Object getTargetMetaData() {
			return md;
		}

	}
	


}
