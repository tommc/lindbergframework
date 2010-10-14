package org.lindbergframework.persistence.beans;

import java.sql.SQLException;

import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.persistence.sql.DataSet;

/**
 * Interface that defines the bean populator implementations contract.
 *  
 * @author Victor Lindberg
 *
 */
public interface BeanPopulator {

    /**
     * Creates and Populates a bean based on {@link DataSet} argument.
     * 
     * @param <E> bean type.
     * @param beanClass bean class to populate.
     * @param dataSet {@link DataSet} that will be used to populate the bean.
     * @return populated bean.
     * @throws SQLException accessing error {@link DataSet}.
     * @throws BeanPopulateException bean population failed.
     */
	public <E> E populate(Class<E> beanClass, DataSet dataSet) 
	 						throws SQLException, BeanPopulateException;
	
}
