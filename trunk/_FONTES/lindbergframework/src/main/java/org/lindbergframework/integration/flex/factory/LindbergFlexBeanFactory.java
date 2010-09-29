package org.lindbergframework.integration.flex.factory;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.beans.di.context.UserBeanContext;

import flex.messaging.FactoryInstance;
import flex.messaging.FlexFactory;
import flex.messaging.config.ConfigMap;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergFlexBeanFactory implements FlexFactory{
    
    private BeanFactory beanFactory;
    
    public LindbergFlexBeanFactory(){
        //
    }
    
    public void initialize(String id, ConfigMap configMap){
        beanFactory = UserBeanContext.getInstance().getFactory();
    }

    public FactoryInstance createFactoryInstance(String id, ConfigMap properties){
        LindbergFlexFactoryInstance factoryInstance = new LindbergFlexFactoryInstance(this, id, properties,beanFactory);
        factoryInstance.setSource(properties.getPropertyAsString(SOURCE, factoryInstance.getId()));
        return factoryInstance;
    }

    public Object lookup(FactoryInstance inst){
        LindbergFlexFactoryInstance factoryInstance = (LindbergFlexFactoryInstance) inst;
        return factoryInstance.lookup(); 
    }


}
