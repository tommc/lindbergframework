package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.exception.BeanNotFoundException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class BeanContext {
    
    private BeanFactory factory;
    
    public BeanContext(BeanFactory beanFactory){
        this.factory = beanFactory;
    }
    
    public <E> E getBean(String id) throws BeanNotFoundException{
        return factory.getBean(id);
    }
    
    public <E> E getBean(String id, Object[] args) throws BeanNotFoundException{
        return factory.getBean(id, args);
    }

    public BeanFactory getFactory() {
        return factory;
    }
    
    public boolean containsBean(String id){
        return factory.containsBean(id);
    }

    public void setFactory(BeanFactory factory) {
        this.factory = factory;
    }
    
}
