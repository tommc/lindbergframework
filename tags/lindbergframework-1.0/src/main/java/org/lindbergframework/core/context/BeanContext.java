package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.exception.BeanNotFoundException;

/**
 * Lindberg IOC context base class.
 * 
 * @author Victor Lindberg
 *
 */
public class BeanContext {
   
    /**
     * Bean factory implementation.
     */
    private BeanFactory factory;
    
    /**
     * Create a BeanContext for bean factory implementation specified.
     * 
     * @param beanFactory bean factory implementation.
     */
    public BeanContext(BeanFactory beanFactory){
        this.factory = beanFactory;
    }
    
    /**
     * Get a instance bean from lindberg IOC context.
     * 
     * @param <E> type of bean expected.
     * @param id bean id.
     * @param constructorArgs bean contructor args.
     * @return instance of bean.
     * @throws BeanNotFoundException bean with specified id not found.
     */
    public <E> E getBean(String id,Object... constructorArgs) throws BeanNotFoundException{
        return (E) factory.getBean(id,constructorArgs);
    }
    
    /**
     * Get the bean factory implementation.
     * 
     * @return bean factory implementation.
     */
    public BeanFactory getFactory() {
        return factory;
    }
    
    /**
     * Checks if this context contains the bean with the specified id.
     * 
     * @param id bean id.
     * @return true if this context contains a bean with the specified id.
     */
    public boolean containsBean(String id){
        return factory.containsBean(id);
    }

    public void setFactory(BeanFactory factory) {
        this.factory = factory;
    }
    
}
