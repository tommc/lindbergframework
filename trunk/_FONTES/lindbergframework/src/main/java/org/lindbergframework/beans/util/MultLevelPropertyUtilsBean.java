package org.lindbergframework.beans.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.lindbergframework.util.ReflectionUtil;

/**
 * Extension of {@link PropertyUtilsBean} that works with reflection. 
 * 
 * @author Victor Lindberg
 *
 */
class MultLevelPropertyUtilsBean extends PropertyUtilsBean{
	
	private Class clazz;
	
	public MultLevelPropertyUtilsBean(Class clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * Get the {@link Method} instance using reflection.
	 */
	@Override
	public Method getWriteMethod(PropertyDescriptor descriptor) {
		return ReflectionUtil.getSetterMethod(clazz, descriptor.getName(), descriptor.getPropertyType(), true);
	}

}
