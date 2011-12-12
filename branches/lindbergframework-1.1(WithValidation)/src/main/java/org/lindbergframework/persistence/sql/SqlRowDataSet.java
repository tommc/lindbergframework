package org.lindbergframework.persistence.sql;

import java.sql.SQLException;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

/**
 * Data set implementation to work with {@link SqlRowSet}.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlRowDataSet implements DataSet{
	
    /**
     * encapsulated SqlRowSet.
     */
    private SqlRowSet rs;
	
	public SqlRowDataSet(SqlRowSet rs){
		this.rs = rs;
	}

	/**
	 * {@inheritDoc}
	 */
	public void afterLast() throws SQLException {
       rs.afterLast();		
	}

	/**
	 * {@inheritDoc}
	 */
	public void beforeFirst() throws SQLException {
	   rs.beforeFirst();	
	}

	/**
	 * {@inheritDoc}
	 */
	public void close() throws SQLException {
	   throw new UnsupportedOperationException("Close operation is not supported. A SqlRowDataSet is a disconnected DataSet");
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean first() throws SQLException {
		return rs.first();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getIndexRow() throws SQLException {
		return rs.getRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <E> E getResultTarget() {
		return (E) rs;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValue(String columnName) throws SQLException {
		return rs.getObject(columnName);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValue(int columnIndex) throws SQLException{
		return rs.getObject(columnIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAfterLast() throws SQLException {
		return rs.isAfterLast();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isBeforeFirst() throws SQLException {
		return rs.isBeforeFirst();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isFirst() throws SQLException {
		return rs.isFirst();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLast() throws SQLException {
		return rs.isLast();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean last() throws SQLException {
		return rs.last();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean next() throws SQLException {
		return rs.next();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean previous() throws SQLException {
		return rs.previous();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public DataSetMetaDada getMetaData() throws SQLException {
		return new SqlRowDataSetMetaData(rs.getMetaData());
	}

	/**
     * DataSetMetaDada implementation for SqlRowSet.
     * 
     * @author Victor Lindberg
     *
     */
	private class SqlRowDataSetMetaData implements DataSetMetaDada {
		private SqlRowSetMetaData md;

		public SqlRowDataSetMetaData(SqlRowSetMetaData md) {
			this.md = md;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getColumnClassName(int column) throws SQLException {
			return md.getColumnClassName(column);
		}

		/**
		 * {@inheritDoc}
		 */
		public int getColumnCount() throws SQLException {
			return md.getColumnCount();
		}

		/**
		 * {@inheritDoc}
		 */
		public String getColumnName(int columnIndex) throws SQLException {
			return md.getColumnName(columnIndex);
		}
		
		/**
		 * {@inheritDoc}
		 */
		public String getColumnLabel(int column) throws SQLException {
			return md.getColumnLabel(column);
		}

		/**
		 * {@inheritDoc}
		 */
		public int getColumnType(int column) throws SQLException {
			return md.getColumnType(column);
		}

		/**
		 * {@inheritDoc}
		 */
		public String getColumnTypeName(int column) throws SQLException {
			return md.getColumnTypeName(column);
		}

		/**
		 * {@inheritDoc}
		 */
		public String getSchemaName(int column) throws SQLException {
			return md.getSchemaName(column);
		}

		/**
		 * {@inheritDoc}
		 */
		public String getTableName(int column) throws SQLException {
			return md.getTableName(column);
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getTargetMetaData() {
			return md;
		}

	}
	


}
