package org.lindbergframework.persistence.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

import org.lindbergframework.persistence.transaction.TransactionProxy;
import org.lindbergframework.persistence.transaction.annotation.Transax;
import org.lindbergframework.util.ProxyUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class TransactionUtil {
	
	public static <E> E createTransactionProxy(Class clazz,Object... args){
        return ProxyUtil.createProxy(clazz, new TransactionProxy(), args);   	
	}
	
	public static boolean isTransactional(Class clazz){
		return clazz.getAnnotation(Transax.class) != null;
	}
	
	public static boolean isTransactional(Method method){
		return method.getAnnotation(Transax.class) != null;
	}
	
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
