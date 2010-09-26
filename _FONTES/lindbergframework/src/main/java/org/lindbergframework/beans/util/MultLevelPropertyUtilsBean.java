package org.lindbergframework.beans.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.lindbergframework.util.ReflectionUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
class MultLevelPropertyUtilsBean extends PropertyUtilsBean{
	
	private Class clazz;
	
	public MultLevelPropertyUtilsBean(Class clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public Method getWriteMethod(PropertyDescriptor descriptor) {
		return ReflectionUtil.getSetterMethod(clazz, descriptor.getName(), descriptor.getPropertyType(), true);
	}

}
