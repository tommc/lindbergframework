package org.lindbergframework.beans.di;

import org.lindbergframework.exception.BeanMappingNotFoundException;
import org.lindbergframework.exception.MappingFailedException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface BeanMapper {
	
	public void map() throws MappingFailedException;
	
	public BeanMapping getBeanMapping(String id) throws BeanMappingNotFoundException;
	
	public int getLengthBeanMapping();

}
