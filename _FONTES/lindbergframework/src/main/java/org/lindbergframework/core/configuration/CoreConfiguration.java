package org.lindbergframework.core.configuration;

import org.lindbergframework.beans.di.context.AnnotationBeanFactory;
import org.lindbergframework.beans.di.context.BeanFactory;


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
     * get the modules to initialize.
     * 
     * @return lindberg modules to initialize.
     */
    public Configuration[] getModules();
    
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
