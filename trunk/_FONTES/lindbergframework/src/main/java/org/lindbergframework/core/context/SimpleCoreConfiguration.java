package org.lindbergframework.core.context;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.persistence.context.LinpConfiguration;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SimpleCoreConfiguration extends AbstractCoreConfiguration{
    
    public SimpleCoreConfiguration(){
        //
    }

    public LinpConfiguration getLinpConfiguration() {
        return null;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        super.setBeanFactory(beanFactory);
        if (getDIBasePackage() != null)
            beanFactory.loadBasepackage(getDIBasePackage());
    }
    
    @Override
    public void setDiBasePackage(String diBasePackage) {
        super.setDiBasePackage(diBasePackage);
        if (getBeanFactory() != null)
            getBeanFactory().loadBasepackage(diBasePackage);
    }
    
    @Override
    public void setLinpConfiguration(LinpConfiguration linpConfiguration) {
        super.setLinpConfiguration(linpConfiguration);
    }
}
