package org.lindbergframework.util;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Proxy;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ProxyUtil {
	
	public static <E> E createProxy(Class clazz,Callback callback,Object... args){
		Enhancer e = new Enhancer();

		e.setSuperclass(clazz);
		e.setCallback(callback);
		
		Class[] arrayClazz = new Class[args.length];
		
		for (int i = 0;i < arrayClazz.length;i++)
			arrayClazz[i] = args[i].getClass();
		
		return (E) e.create(arrayClazz,args);   	
	}

}
