package org.lindbergframework.persistence.beans;

import java.sql.SQLException;

import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.persistence.sql.DataSet;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface BeanPopulator {

	public <E> E populate(Class<E> bean, DataSet dataSet) 
	 						throws SQLException, BeanPopulateException;
	
}
