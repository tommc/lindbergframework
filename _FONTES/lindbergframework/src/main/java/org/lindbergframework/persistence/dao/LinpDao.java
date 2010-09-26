package org.lindbergframework.persistence.dao;

import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.PersistBeans;
import org.lindbergframework.persistence.PersistenceTemplate;
import org.lindbergframework.persistence.beans.BeanPopulator;
import org.lindbergframework.persistence.context.LindbergPersistenceSpringBeanFactory;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LinpDao {
	
	private PersistenceTemplate persistTemplate = null;
	
	public LinpDao(){
		//
	}
	
	public LinpDao(PersistenceTemplate template){
		this.persistTemplate = template;
	}
	
	public LinpDao(PersistenceTemplate template, BeanPopulator populator, DataSourceConfig dsConfig){
		this.persistTemplate = template;
		template.setBeanPopulator(populator);
		template.setDataSourceConfig(dsConfig);
	}
	
	public LinpDao(BeanPopulator populator){
		persistTemplate = getTemplate(populator);
	}
	
	public LinpDao(DataSourceConfig dsConfig){
		persistTemplate = getTemplate(dsConfig);
	}
	
	public LinpDao(BeanPopulator populator, DataSourceConfig dsConfig){
		persistTemplate = getTemplate(populator,dsConfig);
	}
	
	private PersistenceTemplate getTemplate(Object... args){
		return LindbergPersistenceSpringBeanFactory.getInstance().getBean(PersistBeans.DEFAULT_LINP_TEMPLATE,args);
	}
	
	public PersistenceTemplate getPersistTemplate() {
		if (persistTemplate == null)
			persistTemplate = getTemplate();
		
		return persistTemplate;
	}

}
