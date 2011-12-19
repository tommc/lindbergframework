package org.lindbergframework.test.beans;

import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.persistence.beans.MultLevelsBeanPopulator;
import org.lindbergframework.persistence.sql.DataSet;
import org.lindbergframework.util.ReflectionUtil;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class BeanPopulatorIDOnly extends MultLevelsBeanPopulator{

	/**
	 * Default Constructor.
	 */
	public BeanPopulatorIDOnly() {
		//
	}
	
	public <E> E populate(Class<E> beanClass, DataSet dataSet)
			throws BeanPopulateException {
		try{
			E bean = super.populate(beanClass, dataSet);
			E copy = (E) BeanUtil.createInstance(beanClass);
			Object id = ReflectionUtil.getValueByReflection("id", bean);
			ReflectionUtil.setValueByReflection("id", copy, id);
			return copy;
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
	
	public <E> E populateDirectValue(Class<E> beanClass, DataSet dataSet)
			throws BeanPopulateException {
		return null;
	}
}
