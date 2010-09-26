package org.lindbergframework.core.context;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ContextProxy implements MethodInterceptor{
	
    private Method[] noProxyMethods;
    
	public ContextProxy(Method... noProxyMethods){
		this.noProxyMethods = noProxyMethods;
	}
	
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		if (method.getAnnotation(AllowIfContextActive.class) != null){
			Context configuration = (Context) obj;
			configuration.verifyContext();
		}
		
		return proxy.invokeSuper(obj, args);
	}
	
}
