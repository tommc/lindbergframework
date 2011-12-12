package org.lindbergframework.integration.flex.factory;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.beans.di.context.UserBeanContext;

import flex.messaging.FactoryInstance;
import flex.messaging.FlexFactory;
import flex.messaging.config.ConfigMap;

/**
 * Lindberg flex factory implementation to integrate
 * the flex layer with a business layer that uses lindbergframework IOC.
 *   
 * @author Victor Lindberg
 *
 */
public class LindbergFlexBeanFactory implements FlexFactory{
    
    private BeanFactory beanFactory;
    
    public LindbergFlexBeanFactory(){
        //
    }
    
    /**
     * Initializes the lindberg bean factory defined in core configuration from {@link UserBeanContext}. 
     */
    public void initialize(String id, ConfigMap configMap){
        beanFactory = UserBeanContext.getInstance().getFactory();
    }

    /**
     * Creates and configures Lindberg {@link FactoryInstance} implementation. 
     */
    public FactoryInstance createFactoryInstance(String id, ConfigMap properties){
        LindbergFlexFactoryInstance factoryInstance = new LindbergFlexFactoryInstance(this, id, properties,beanFactory);
        factoryInstance.setSource(properties.getPropertyAsString(SOURCE, factoryInstance.getId()));
        return factoryInstance;
    }

    /**
     * Get the bean from lindberg IOC context.
     */
    public Object lookup(FactoryInstance inst){
        LindbergFlexFactoryInstance factoryInstance = (LindbergFlexFactoryInstance) inst;
        return factoryInstance.lookup(); 
    }
    
}
