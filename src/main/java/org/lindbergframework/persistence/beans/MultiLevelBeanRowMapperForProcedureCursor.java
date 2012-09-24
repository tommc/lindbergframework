package org.lindbergframework.persistence.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.persistence.sql.ResultDataSet;
import org.lindbergframework.persistence.sql.RowDataTree;
import org.springframework.jdbc.core.RowMapper;

/**
 * MultiLevelsBeanPopulator extension that implements {@link RowMapper} interface
 * to work with Procedure and Function cursors.
 * 
 * @author Victor Lindberg
 *
 */
public class MultiLevelBeanRowMapperForProcedureCursor extends MultiLevelsBeanPopulator implements RowMapper{
	
    /**
     * Bean class to populate.
     */
	private Class clazz;
	
	public MultiLevelBeanRowMapperForProcedureCursor(Class clazz) {
		this.clazz = clazz;
	}


	/**
	 * Executes the mult level population for {@link ResultSet} argument
	 * creating and populating the bean.
	 */
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			ResultDataSet dataSet = new ResultDataSet(rs);
			return populate(clazz, new RowDataTree(dataSet));
		} catch (BeanPopulateException e) {
			throw new SQLException(e.getMessage());
		}
    }
}
