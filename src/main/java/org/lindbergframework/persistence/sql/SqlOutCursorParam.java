package org.lindbergframework.persistence.sql;

/**
 * Output parameter from stored procedures and functions.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlOutCursorParam {
	
    /**
     * bean class to map.
     */
	private Class beanClass;
	
	public SqlOutCursorParam(){
		//
	}
	
	public SqlOutCursorParam(Class beanClass) {
		this.beanClass = beanClass;
	}


	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

}
