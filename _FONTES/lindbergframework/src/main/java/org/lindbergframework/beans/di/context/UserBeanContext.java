package org.lindbergframework.beans.di.context;

import org.lindbergframework.core.context.BeanContext;
import org.lindbergframework.core.context.CoreContext;

/**
 * 
 * @author Victor Lindberg
 *
 */
public final class UserBeanContext extends BeanContext{
	
    private static UserBeanContext instance;
    
    private UserBeanContext(){
        super(CoreContext.getInstance().getBeanFactory());
    }
    
    public static UserBeanContext getInstance(){
        if (instance == null)
            instance = new UserBeanContext();
        
        return instance;
    }
	
    public void renew(){
	    instance = null;
	    getInstance();    
	}
	
}
