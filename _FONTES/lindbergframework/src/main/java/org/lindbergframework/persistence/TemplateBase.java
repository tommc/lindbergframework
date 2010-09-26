package org.lindbergframework.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.exception.PersistenceException;
import org.lindbergframework.persistence.beans.BeanPopulator;
import org.lindbergframework.persistence.context.LindbergPersistenceSpringBeanFactory;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.persistence.sql.DataSet;
import org.lindbergframework.persistence.sql.SqlCommandResolver;

/**
 * 
 * @author Victor Lindberg
 *
 */
public abstract class TemplateBase implements PersistenceTemplate {
	
	private BeanPopulator beanPopulator;
	private DataSource dataSource;
	private DataSourceConfig dataSourceConfig;
	protected LinpContext context = LinpContext.getInstance();
	
	public TemplateBase(){
		configureDefaultPopulator();
		configureDefaultDataSource();
	}
	
	public TemplateBase(BeanPopulator populator){
		setBeanPopulator(populator);
		configureDefaultDataSource();
	}
	
	public TemplateBase(DataSourceConfig dsConfig){
		setDataSourceConfig(dsConfig);
		configureDefaultPopulator();
	}
	
	public void configureDefaultPopulator(){
		setBeanPopulator((BeanPopulator) LindbergPersistenceSpringBeanFactory.getInstance()
		               .getBean(PersistBeans.MULT_LEVEL_BEAN_POPULATOR));
	}
	
	public void configureDefaultDataSource(){
		setDataSourceConfig(context.getDataSourceConfig());
	}
	
	public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
	   if (dataSourceConfig == null)
		   throw new PersistenceException("DataSourceConfig can not to be null");
	   
	   this.dataSourceConfig = dataSourceConfig;
	   this.dataSource = dataSourceConfig.getDataSource();
	}
	
	public DataSourceConfig getDataSourceConfig() {
		return dataSourceConfig;
	}
	
	public TemplateBase(BeanPopulator populator, DataSourceConfig dsConfig){
		setBeanPopulator(populator);
		setDataSourceConfig(dsConfig);
	}
	
	
	public <E> List<E> populateBeans(Class<E> clazz, DataSet ds) throws SQLException, BeanPopulateException{
		ds.beforeFirst();
		List<E> list = new ArrayList<E>();
		
		while (ds.next()){
			   E newBean = beanPopulator.populate(clazz, ds);
			   list.add(newBean);
			}
		
		return list;
	}
	
	public <E> E populateBean(Class<E> clazz,DataSet ds) throws SQLException, BeanPopulateException{
		ds.first();
		
		return beanPopulator.populate(clazz, ds);
	}
	
	public void setBeanPopulator(BeanPopulator beanPopulator) {
		this.beanPopulator = beanPopulator;
	}
	
	public BeanPopulator getBeanPopulator() {
		return beanPopulator;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
	
	public Connection getConnection() throws SQLException{
	   verifyDataSource();
		   
	   return getDataSource().getConnection();
	}
	
	protected void verifyDataSource(){
		if (getDataSource() == null)
			throw new IllegalStateException("No DataSource defined. Use LinpContext class to configure the default context persistence parameters");
	}
	
	protected SqlCommandResolver getSqlCommandResolver(){
		return context.getSqlCommandResolver();
	}
	
}
