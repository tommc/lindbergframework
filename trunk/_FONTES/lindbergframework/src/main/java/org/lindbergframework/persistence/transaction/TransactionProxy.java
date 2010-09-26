package org.lindbergframework.persistence.transaction;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.lindbergframework.exception.TransactionFailureException;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.persistence.util.TransactionUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class TransactionProxy implements MethodInterceptor{
	

	public TransactionProxy(){
	  //
	}
	
	public Object intercept(final Object obj, Method method,
			final Object[] args, final MethodProxy proxy) throws Throwable {
		if (! TransactionUtil.isTransactional(method)
				&& ((Enhancer.isEnhanced(obj.getClass()) && ! TransactionUtil.isTransactional(obj.getClass().getSuperclass())) &&
				    ! TransactionUtil.isTransactional(obj.getClass())))
			return proxy.invokeSuper(obj, args);
		else {
			TransactionManager transactionManager = LinpContext.getInstance().getTransactionManager();
            return transactionManager.execute(new TransactionalContext() {
                public Object call() {
                    try {
                        return proxy.invokeSuper(obj, args);
                    } catch (Throwable ex) {
                        throw new TransactionFailureException(ex);
                    }
                }
            });
		}
	}
		
}
	


