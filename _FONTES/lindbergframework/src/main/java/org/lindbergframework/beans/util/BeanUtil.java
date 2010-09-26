package org.lindbergframework.beans.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.exception.LoadPropertyException;
import org.lindbergframework.util.ReflectionUtil;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class BeanUtil {
	
	public static void populate(Object bean, Map properties) throws BeanPopulateException{
		try {
			BeanUtils.populate(bean, properties);
		} catch (IllegalAccessException ex) {
			throw new BeanPopulateException(ex);
		} catch (InvocationTargetException ex) {
			throw new BeanPopulateException(ex);
		}	
	}
	
	public static void loadProperty(Object bean, String property, Object value) throws LoadPropertyException{
		try {
			MultLevelPropertyUtilsBean propertyUtilsBean = new MultLevelPropertyUtilsBean(bean.getClass());
			
			BeanUtilsBean beanUtils = new BeanUtilsBean(new ConvertUtilsBean(),propertyUtilsBean);
			beanUtils.copyProperty(bean, property, value);
		} catch (Exception ex) {
			throw new LoadPropertyException(ex);
		} 
	}
	
	public static <E> E createInstance(Class clazz,Object... args) 
	                  throws NoSuchMethodException, IllegalAccessException, 
	                         InvocationTargetException, InstantiationException{
		return (E) ConstructorUtils.invokeConstructor(clazz, args);
	}
	
	
  	public static void copyProperties(Object source, Object target)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fieldsSource = source.getClass().getDeclaredFields();
		
		ReflectionUtil.makeAttributesAccessible(fieldsSource);

		for (Field field : fieldsSource) {
			Object valueField = field.get(source);
			field.set(target, valueField);
		}
	}

}
