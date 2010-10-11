package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.AnnotationBeanFactory;

/**
 * Lindberg IOC context implementation to work with beans defined inside lindberg project.
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergBeanContext extends BeanContext{
	
    /**
     * instance of context.
     */
    private static LindbergBeanContext instance;
    
    private LindbergBeanContext(){
        super(new AnnotationBeanFactory("org.lindbergframework:schema.*"));
    }
    
    /**
     * get the instance of context.
     * @return context instance.
     */
    public static LindbergBeanContext getInstance(){
        if (instance == null)
            instance = new LindbergBeanContext();
        
        return instance;
    }

}
