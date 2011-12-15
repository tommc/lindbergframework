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
	
	public ContextProxy(){
		//
	}
	
	/**
	 * Intercepts the context methods and invokes verifyContext method 
	 * in context to verify the context status. 
	 */
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		if (method.getAnnotation(AllowIfContextActive.class) != null){
			ComponentContext configuration = (ComponentContext) obj;
			configuration.verifyContext();
		}
		
		return proxy.invokeSuper(obj, args);
	}
	
}
