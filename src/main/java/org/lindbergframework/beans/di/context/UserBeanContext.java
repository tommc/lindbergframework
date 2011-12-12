package org.lindbergframework.beans.di.context;

import org.lindbergframework.core.context.BeanContext;
import org.lindbergframework.core.context.CoreContext;

/**
 * Bean context of lindbergframework user.
 * 
 * @author Victor Lindberg
 *
 */
public final class UserBeanContext extends BeanContext{
	
    /**
     * instance of bean context of user.
     */
    private static UserBeanContext instance;
    
    private UserBeanContext(){
        super(CoreContext.getInstance().getBeanFactory());
    }
    
    /**
     * get instance of bean context.
     * @return
     */
    public static UserBeanContext getInstance(){
        if (instance == null)
            instance = new UserBeanContext();
        
        return instance;
    }
	
    /**
     * Reconfigures the bean context.
     */
    public void renew(){
	    instance = null;
	    getInstance();    
	}
	
}
