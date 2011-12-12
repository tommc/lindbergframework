package org.lindbergframework.persistence.beans;

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
     * @throws BeanPopulateException bean population failed.
     */
	public <E> E populate(Class<E> beanClass, DataSet dataSet) throws BeanPopulateException;
	
	/**
	 * Creates and Populates a bean based on {@link DataSet} argument using the <i>beanClass</i> parameter
	 * as direct type. 
	 * <p>E.g: Result of Query with one column only of type Number, then {@link #populateDirectValue(Class, DataSet)} method
	 * with <i>beanClass</i> parameter equal Long or Integer could be used to populate the column value to direct value of type <i>beanClass</i></p>
	 *   
	 * @param <E> direct bean type.
     * @param beanClass bean class to populate.
     * @param dataSet {@link DataSet} that will be used to populate the bean.
     * @return populated bean.
     * @throws BeanPopulateException bean population failed.
	 */
	public <E> E populateDirectValue(Class<E> beanClass, DataSet dataSet) throws BeanPopulateException;
	
}
