package org.lindbergframework.util;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * Utilitary class to proxy operations.
 * 
 * @author Victor Lindberg
 *
 */
public class ProxyUtil {
	
	/**
	 * create a proxy based on specified class, {@link Callback} and constructor arguments.
	 * @return proxy instance of class argument.
	 */
	public static <E> E createProxy(Class clazz,Callback callback,Object... constructorArgs){
		Enhancer e = new Enhancer();

		e.setSuperclass(clazz);
		e.setCallback(callback);
		
		Class[] arrayClazz = new Class[constructorArgs.length];
		
		for (int i = 0;i < arrayClazz.length;i++)
			arrayClazz[i] = constructorArgs[i].getClass();
		
		return (E) e.create(arrayClazz,constructorArgs);   	
	}

}
