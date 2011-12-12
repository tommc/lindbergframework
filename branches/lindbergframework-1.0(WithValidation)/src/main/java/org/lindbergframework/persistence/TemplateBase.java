package org.lindbergframework.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.lindbergframework.core.context.LindbergBeanContext;
import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.exception.PersistenceException;
import org.lindbergframework.persistence.beans.BeanPopulator;
import org.lindbergframework.persistence.configuration.LinpConfiguration;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.persistence.sql.DataSet;
import org.lindbergframework.persistence.sql.SqlCommandResolver;

/**
 * abstract template base with main resources for all persistence template implementations.
 *   
 * @author Victor Lindberg
 *
 */
public abstract class TemplateBase implements PersistenceTemplate {
	
    /**
     * bean populator implementation to use.
     */
	private BeanPopulator beanPopulator;
	
	/**
	 * data source implementation to use.
	 */
	private DataSource dataSource;
	
	/**
	 * data source configuration to use.
	 */
	private DataSourceConfig dataSourceConfig;
	
	/**
	 * persistence context instance.
	 */
	protected LinpContext context = LinpContext.getInstance();
	
	/**
	 * Default Constructor that configures default bean populator and data source implementation.
	 */
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
	
	public TemplateBase(BeanPopulator populator, DataSourceConfig dsConfig){
        setBeanPopulator(populator);
        setDataSourceConfig(dsConfig);
    }

	/**
	 * {@inheritDoc}
	 */
	public void configureDefaultPopulator(){
		BeanPopulator beanPopulator = LindbergBeanContext.getInstance().getBean(LinpConfiguration.DEFAULT_BEAN_POPULATOR);
		setBeanPopulator(beanPopulator);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void configureDefaultDataSource(){
		setDataSourceConfig(context.getDataSourceConfig());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
	   if (dataSourceConfig == null)
		   throw new PersistenceException("DataSourceConfig can not to be null");
	   
	   this.dataSourceConfig = dataSourceConfig;
	   this.dataSource = dataSourceConfig.getDataSource();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public DataSourceConfig getDataSourceConfig() {
		return dataSourceConfig;
	}

	/**
	 * Populates the {@link DataSet} result as a list of beans using the configured bean populator
	 * implementation in this template.
	 * 
	 * @param <E> expected bean type.
	 * @param clazz bean class for population.
	 * @param ds {@link DataSet} implementation to populate.
	 * @return populated beans list.
	 * @throws SQLException error access {@link DataSet}.
	 * @throws BeanPopulateException population failed.
	 */
	public <E> List<E> populateBeans(Class<E> clazz, DataSet ds) throws SQLException, BeanPopulateException{
		ds.beforeFirst();
		List<E> list = new ArrayList<E>();
		
		boolean directValue = ds.getMetaData().getColumnCount() == 1;
		while (ds.next()){
		   E newBean;
		   if (directValue)
		      newBean = beanPopulator.populateDirectValue(clazz, ds);
		   else
		      newBean = beanPopulator.populate(clazz, ds);
		   list.add(newBean);
		}
		
		return list;
	}
	
	/**
	 * Populates a bean for unique result. Only first record from {@link DataSet} will be populated.
	 * 
	 * @param <E> expected bean type.
     * @param clazz bean class for population.
     * @param ds {@link DataSet} implementation to populate.
     * @return populated bean.
     * @throws SQLException error access {@link DataSet}.
     * @throws BeanPopulateException population failed.
	 */
	public <E> E populateBean(Class<E> clazz,DataSet ds) throws SQLException, BeanPopulateException{
		ds.first();
		
		return beanPopulator.populate(clazz, ds);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setBeanPopulator(BeanPopulator beanPopulator) {
		this.beanPopulator = beanPopulator;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public BeanPopulator getBeanPopulator() {
		return beanPopulator;
	}

	/**
	 * {@inheritDoc}
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public Connection getConnection() throws SQLException{
	   verifyDataSource();
		   
	   return getDataSource().getConnection();
	}
	
	/**
	 * Checks if the data source is configured.
	 */
	protected void verifyDataSource(){
		if (getDataSource() == null)
			throw new IllegalStateException("No DataSource defined. Use LinpContext class to configure the default context persistence parameters");
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SqlCommandResolver getSqlCommandResolver(){
		return context.getSqlCommandResolver();
	}
	
}
