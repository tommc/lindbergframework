package org.lindbergframework.persistence.util;

import java.lang.reflect.Method;

import org.lindbergframework.persistence.transaction.TransactionProxy;
import org.lindbergframework.persistence.transaction.annotation.Transax;
import org.lindbergframework.util.ProxyUtil;

/**
 * Utilitary class to transaction operations.
 *  
 * @author Victor Lindberg
 *
 */
public class TransactionUtil {
	
    /**
     * creates a transaction proxy based on specified class using the constructor arguments to instanciate the target object.
     * 
     * @param <E> type of expected object.
     * @param clazz target object class.
     * @param constructorArgs constructor arguments to instanciate the target object.
     * @return proxy instance.
     */
	public static <E> E createTransactionProxy(Class clazz,Object... constructorArgs){
        return ProxyUtil.createProxy(clazz, new TransactionProxy(), constructorArgs);   	
	}
	
	/**
	 * checks if the specified class is annotated with {@link Transax} annotation.
	 * 
	 * @param clazz class to check.
	 * @return true if the specified class is annotated with {@link Transax} annotation or false otherwise.
	 */
	public static boolean isTransactional(Class clazz){
		return clazz.getAnnotation(Transax.class) != null;
	}
	
	/**
	 * checks if the specified method is annotated with {@link Transax} annotation.
	 * 
	 * @param method method to check.
	 * @return true if the specified method is annotated with {@link Transax} annotation or false otherwise.
	 */
	public static boolean isTransactional(Method method){
		return method.getAnnotation(Transax.class) != null;
	}
	
	/**
     * checks if the specified class or some method is annotated with {@link Transax} annotation.
     * 
     * @param clazz class to check.
     * @return true if the specified class or some method is annotated with {@link Transax} annotation or false otherwise.
     */
	public static boolean isSomeMethodOrClassTransactional(Class clazz){
		if (isTransactional(clazz))
			return true;
		
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods)
			if (isTransactional(method))
				return true;
		
		return false;
	}

}
