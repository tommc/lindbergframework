package org.lindbergframework.beans.util;

import org.lindbergframework.beans.di.annotation.Bean;

/**
 * Dependency Injection Utilities
 * 
 * @author Victor Lindberg
 *
 */
public class DIUtil {
	
	public static String extractBeanIdFromClass(Class clazz){
		Bean beanAnnot = (Bean) clazz.getAnnotation(Bean.class);
		
		if (beanAnnot == null)
			return null;
		
		return beanAnnot.value();
	}
	
}
