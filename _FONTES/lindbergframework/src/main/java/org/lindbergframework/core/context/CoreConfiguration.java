package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.AnnotationBeanFactory;
import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.persistence.context.LinpConfiguration;


/**
 * 
 * @author Victor Lindberg
 *
 */
public interface CoreConfiguration extends Configuration{
    
    public static final String CONFIG_PROPERTY_DI_BASEPACKAGE =  "lindberg.core.di-basepackage";
    public static final String CONFIG_PROPERTY_BEAN_FACTORY =  "lindberg.core.beanfactory";
    
    public static final BeanFactory DEFAULT_BEAN_FACTORY = new AnnotationBeanFactory();
    
    public LinpConfiguration getLinpConfiguration();
    
    public String getDIBasePackage();
    
    public BeanFactory getBeanFactory();

}
