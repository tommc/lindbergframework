package org.lindbergframework.integration.flex.factory;

import org.lindbergframework.beans.di.context.BeanFactory;

import flex.messaging.FactoryInstance;
import flex.messaging.FlexFactory;
import flex.messaging.config.ConfigMap;

/**
 * 
 * @author Victor Lindberg
 *
 */
class LindbergFlexFactoryInstance extends FactoryInstance{
    
    private BeanFactory beanFactory;
    
    public LindbergFlexFactoryInstance(FlexFactory factory, String id,
        ConfigMap properties, BeanFactory beanFactory) {
        super(factory, id, properties);
        this.beanFactory = beanFactory;
    }
    
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
    
    public String toString()
    {
        return "LindbergFlexBeanFactory - id: "+getId()+" source: "+getSource()+" scope: " + getScope();
    }

    public Object lookup(){
       String idBean = getSource();
       return beanFactory.getBean(idBean);
    }

}
