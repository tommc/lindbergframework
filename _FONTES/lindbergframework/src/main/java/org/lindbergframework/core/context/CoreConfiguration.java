package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.AnnotationBeanFactory;
import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.persistence.context.LinpConfiguration;


/**
 * Interface that defines the contract for core configuration implementations.
 * 
 * @author Victor Lindberg
 *
 */
public interface CoreConfiguration extends Configuration{
   
    /**
     * lindberg core IOC basepackage key in the values configurations repository. 
     */
    public static final String CONFIG_PROPERTY_DI_BASEPACKAGE =  "lindberg.core.di-basepackage";
    
    /**
     * lindberg core IOC bean factory key in the values configurations repository. 
     */
    public static final String CONFIG_PROPERTY_BEAN_FACTORY =  "lindberg.core.beanfactory";
    
    /**
     * default bean factory implementation. 
     */
    public static final BeanFactory DEFAULT_BEAN_FACTORY = new AnnotationBeanFactory();
    
    /**
     * get the lindberg persistence configuration implementation.
     * 
     * @return lindberg persistence implementation configured in this core configuration.
     */
    public LinpConfiguration getLinpConfiguration();
    
    /**
     * get the IOC base package.
     * @return
     */
    public String getDIBasePackage();

    /**
     * get the bean factory implementation.
     *  
     * @return bean factory implementation.
     */
    public BeanFactory getBeanFactory();

}
