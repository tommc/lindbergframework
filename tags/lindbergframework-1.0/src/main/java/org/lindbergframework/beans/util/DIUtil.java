package org.lindbergframework.beans.util;

import org.lindbergframework.beans.di.annotation.Bean;

/**
 * Utilitary class for Dependency Injection operations.
 * 
 * @author Victor Lindberg
 *
 */
public class DIUtil {
	
    /**
     * Extracts bean id from class.
     * 
     * @param clazz class for extraction.
     * 
     * @return bean id specified in class argument.
     */
	public static String extractBeanIdFromClass(Class clazz){
		Bean beanAnnot = (Bean) clazz.getAnnotation(Bean.class);
		
		if (beanAnnot == null)
			return null;
		
		return beanAnnot.value();
	}
	
}
