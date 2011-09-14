package org.lindbergframework.persistence.dao;

import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.PersistBeans;
import org.lindbergframework.persistence.PersistenceTemplate;
import org.lindbergframework.persistence.beans.BeanPopulator;
import org.lindbergframework.persistence.context.LindbergPersistenceSpringBeanFactory;

/**
 * 
 * Lindberg DAO. This DAO provides main resouces for persistence operantions
 * for DAO classes that uses linp.
 * 
 * This DAO provides a template for persistence operantions.
 * 
 * @author Victor Lindberg
 *
 */
public class LinpDAO {
    
    /**
     * template for persistence operations.
     */
    private PersistenceTemplate persistTemplate = null;
    
    public LinpDAO(){
        //
    }
    
    /**
     * creates a LinpDAO with the specified template.
     * 
     * @param template template for persistence operations.
     */
    public LinpDAO(PersistenceTemplate template){
        this.persistTemplate = template;
    }
    
    /**
     * creates a LinpDAO with the specified template, bean populator and data source configuration.
     * 
     * @param template template for persistence operations.
     * @param populator bean populator implementation
     * @param dsConfig data source configuration
     */
    public LinpDAO(PersistenceTemplate template, BeanPopulator populator, DataSourceConfig dsConfig){
        this.persistTemplate = template;
        template.setBeanPopulator(populator);
        template.setDataSourceConfig(dsConfig);
    }
    
    /**
     * creates a LinpDAO with the specified bean populator.
     * 
     * @param populator bean populator implementation
     */
    public LinpDAO(BeanPopulator populator){
        persistTemplate = getDefaultTemplate(populator);
    }
    
    /**
     * creates a LinpDAO with the specified data source configuration.
     * 
     * @param dsConfig data source configuration.
     */
    public LinpDAO(DataSourceConfig dsConfig){
        persistTemplate = getDefaultTemplate(dsConfig);
    }
    
    /**
     * creates a LinpDAO with the specified bean populator and data source configuration.
     * 
     * @param populator bean populator implementation
     * @param dsConfig data source configuration.
     */
    public LinpDAO(BeanPopulator populator, DataSourceConfig dsConfig){
        persistTemplate = getDefaultTemplate(populator,dsConfig);
    }
    
    /**
     * get the default persitence template implementation.
     * 
     * @param constructorArgs template constructor args
     * 
     * @return default template instance
     */
    private PersistenceTemplate getDefaultTemplate(Object... constructorArgs){
        return LindbergPersistenceSpringBeanFactory.getInstance().getBean(PersistBeans.DEFAULT_PERSISTENCE_TEMPLATE,constructorArgs);
    }
    
    /**
     * Get the instance of configured template for persistence operations.
     * 
     * This method always returns the same template instance.
     * 
     * @return configured persistence template.
     */
    public PersistenceTemplate getPersistTemplate() {
        if (persistTemplate == null)
            persistTemplate = getDefaultTemplate();
        
        return persistTemplate;
    }

}
