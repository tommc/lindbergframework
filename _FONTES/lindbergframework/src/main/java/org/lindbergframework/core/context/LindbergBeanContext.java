package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.AnnotationBeanFactory;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergBeanContext extends BeanContext{
	
    private static LindbergBeanContext instance;
    
    private LindbergBeanContext(){
        super(new AnnotationBeanFactory("org.lindbergframework:schema.*"));
    }
    
    public static LindbergBeanContext getInstance(){
        if (instance == null)
            instance = new LindbergBeanContext();
        
        return instance;
    }

}
