package org.lindbergframework.persistence.sql;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SqlOutCursorParam {
	
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
