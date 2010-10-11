package org.lindbergframework.core.context;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Proxy to verify if the context is active based in annotated method that using 
 * {@link AllowIfContextActive} annotation.
 * 
 * @author Victor Lindberg
 *
 */
public class ContextProxy implements MethodInterceptor{
	
    /**
     * No proxy methods.
     */
    private Method[] noProxyMethods;
    
	public ContextProxy(Method... noProxyMethods){
		this.noProxyMethods = noProxyMethods;
	}
	
	/**
	 * Intercepts the context methods and invokes verifyContext method 
	 * in context to verify the context status. 
	 */
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		if (method.getAnnotation(AllowIfContextActive.class) != null){
			Context configuration = (Context) obj;
			configuration.verifyContext();
		}
		
		return proxy.invokeSuper(obj, args);
	}
	
}
