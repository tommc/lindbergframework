package org.lindbergframework.beans.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.exception.LoadXmlPropertyException;
import org.lindbergframework.util.ReflectionUtil;


/**
 * Utilitary class for bean operations.
 * 
 * @author Victor Lindberg
 *
 */
public class BeanUtil {
	
    /**
     * Populate a bean with properties and values mapped in map argument.
     * 
     * @param bean bean to populate.
     * @param properties properties and values map.
     * @throws BeanPopulateException population failed.
     */
	public static void populate(Object bean, Map properties) throws BeanPopulateException{
		try {
			BeanUtils.populate(bean, properties);
		} catch (IllegalAccessException ex) {
			throw new BeanPopulateException(ex);
		} catch (InvocationTargetException ex) {
			throw new BeanPopulateException(ex);
		}	
	}
	
	/**
	 * load a property in the bean. 
	 * 
	 * @param bean bean instance.
	 * @param property property to populate.
	 * @param value value to populate in the property.
	 * @throws LoadXmlPropertyException property loading failed.
	 */
	public static void loadProperty(Object bean, String property, Object value) throws BeanPopulateException{
		try {
			MultLevelPropertyUtilsBean propertyUtilsBean = new MultLevelPropertyUtilsBean(bean.getClass());
			
			BeanUtilsBean beanUtils = new BeanUtilsBean(new ConvertUtilsBean(),propertyUtilsBean);
			beanUtils.copyProperty(bean, property, value);
		} catch (Exception ex) {
			throw new BeanPopulateException(ex);
		} 
	}
	
	/**
	 * instantiates a bean.
	 * 
	 * @param <E> bean type expected.
	 * @param clazz bean class.
	 * @param args contructor arguments.
	 * @return bean instance.
	 * 
	 * @throws NoSuchMethodException constructor for arguments specified not found.
	 * @throws IllegalAccessException class or constructor accesss failed.
	 * @throws InvocationTargetException invocation failed.
	 * @throws InstantiationException bean instantiation failed.
	 */
	public static <E> E createInstance(Class clazz,Object... args) 
	                  throws NoSuchMethodException, IllegalAccessException, 
	                         InvocationTargetException, InstantiationException{
		return (E) ConstructorUtils.invokeConstructor(clazz, args);
	}
	
	/**
	 * Copy properties from source to target bean.
	 * @param source source bean.
	 * @param target target bean.
	 * @throws IllegalArgumentException copy property failed.
	 * @throws IllegalAccessException property access failed. 
	 */
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
