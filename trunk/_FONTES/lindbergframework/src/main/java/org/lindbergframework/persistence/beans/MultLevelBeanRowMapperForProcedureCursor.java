package org.lindbergframework.persistence.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.persistence.sql.ResultDataSet;
import org.lindbergframework.persistence.sql.RowDataTree;
import org.lindbergframework.persistence.translate.SqlParametersTranslator;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class MultLevelBeanRowMapperForProcedureCursor extends MultLevelsBeanPopulator implements RowMapper{
	
	private Class clazz;
	
	public MultLevelBeanRowMapperForProcedureCursor(Class clazz) {
		this.clazz = clazz;
	}


	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			ResultDataSet dataSet = new ResultDataSet(rs);
			return populate(clazz, new RowDataTree(dataSet));
		} catch (BeanPopulateException e) {
			throw new SQLException(e.getMessage());
		}
    }
}
