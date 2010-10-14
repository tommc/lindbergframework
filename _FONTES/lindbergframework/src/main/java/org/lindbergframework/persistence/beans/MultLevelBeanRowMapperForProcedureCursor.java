package org.lindbergframework.persistence.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.persistence.sql.ResultDataSet;
import org.lindbergframework.persistence.sql.RowDataTree;
import org.springframework.jdbc.core.RowMapper;

/**
 * MultLevelsBeanPopulator extension that implements {@link RowMapper} interface
 * to work with Procedure and Function cursors.
 * 
 * @author Victor Lindberg
 *
 */
public class MultLevelBeanRowMapperForProcedureCursor extends MultLevelsBeanPopulator implements RowMapper{
	
    /**
     * Bean class to populate.
     */
	private Class clazz;
	
	public MultLevelBeanRowMapperForProcedureCursor(Class clazz) {
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
