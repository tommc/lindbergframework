package org.lindbergframework.beans.di;

import org.lindbergframework.exception.BeanMappingNotFoundException;
import org.lindbergframework.exception.MappingFailedException;

/**
 * Interface that defines the contract for Bean Mappers inside of IOC context.
 * 
 * @author Victor Lindberg
 *
 */
public interface BeanMapper {
	
    /**
     * Executes the bean mapping loading all necessary informations for IOC container.
     * 
     * @throws MappingFailedException throwed when mapping to fail. 
     */
	public void map() throws MappingFailedException;
	
	/**
	 * To get {@link BeanMapping} for a bean with the ID defined equal the id argument.
	 * 
	 * @param id bean id.
	 * 
	 * @return instance of {@link BeanMapping} for bean with id equal the id argument.
	 * 
	 * @throws BeanMappingNotFoundException throwed when {@link BeanMapping} for bean id argument not found.
	 */
	public BeanMapping getBeanMapping(String id) throws BeanMappingNotFoundException;
	
	/**
	 * To get Bean mapping Length. 
	 * @return
	 */
	public int getLengthBeanMapping();

}
