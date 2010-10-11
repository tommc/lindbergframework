package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.persistence.context.LinpConfiguration;

/**
 * Core configuration implementation to define programmatically the core configuration.
 * 
 * @author Victor Lindberg
 *
 */
public class SimpleCoreConfiguration extends AbstractCoreConfiguration{
    
    public SimpleCoreConfiguration(){
        //
    }

    /**
     * {@inheritDoc}
     */
    public LinpConfiguration getLinpConfiguration() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        super.setBeanFactory(beanFactory);
        if (getDIBasePackage() != null)
            beanFactory.loadBasepackage(getDIBasePackage());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setDiBasePackage(String diBasePackage) {
        super.setDiBasePackage(diBasePackage);
        if (getBeanFactory() != null)
            getBeanFactory().loadBasepackage(diBasePackage);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setLinpConfiguration(LinpConfiguration linpConfiguration) {
        super.setLinpConfiguration(linpConfiguration);
    }
}
