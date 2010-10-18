package org.lindbergframework.persistence.context;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.sql.DataSource;

import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.core.context.LindbergBeanContext;
import org.lindbergframework.core.context.xml.util.XmlUtil;
import org.lindbergframework.exception.BeanException;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.InvalidXmlDocumentException;
import org.lindbergframework.exception.PersistenceConfigurationException;
import org.lindbergframework.exception.PersistenceException;
import org.lindbergframework.persistence.DataSourceConfig;
import org.lindbergframework.persistence.sql.SqlCommandResolver;
import org.lindbergframework.persistence.transaction.TransactionManager;
import org.lindbergframework.schema.TconfigProperty;
import org.lindbergframework.schema.TdataSource;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Persistence;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Persistence.ConfigProperties;
import org.lindbergframework.util.ConfigUtil;

/**
 * Lindberg persistence configuration to work with XML configuration.
 * 
 * The XML schema  is defined in http://www.lindbergframework.org/schema/lindberg-config.xsd
 * 
 * @author Victor Lindberg
 *
 */
public class XmlLinpConfiguration extends AbstractLinpConfiguration implements XmlLinpConfigurationInitializer{
	
    /**
     * Persistence xml node.
     */
	private Persistence configuration;
	
	/**
	 * configuration keys automatically formatted.
	 */
	private static final String[] keysAutomaticallyFormatted = new String[] {CONFIG_PROPERTY_SQL_COMMAND_RESOLVER,
		                                                                    CONFIG_PROPERTY_TRANSACTION_MANAGER};
	
	
	public XmlLinpConfiguration(){
		//
	}
	
	/**
	 * Creates a XmlLinpConfiguration using a Persistence xml node.
	 * 
	 * @param persistenceConfig xml node.
	 */
	public XmlLinpConfiguration(Persistence persistenceConfig){
	    initialize(persistenceConfig);
	}
	
	/**
     * Creates a XmlLinpConfiguration using a File of configuration.
     * 
     * @param xmlConfig File of configuration.
     */
	public XmlLinpConfiguration(File xmlConfig){
       initialize(xmlConfig);
	}
	
	/**
	 * Creates a XmlLinpConfiguration using a URL to File of configuration.
	 * 
	 * @param xmlConfig URL to File of configuration.
	 */
	public XmlLinpConfiguration(URL xmlConfig){
	    initialize(xmlConfig);
	}
	
	/**
	 * Creates a XmlLinpConfiguration using a inputstream with the File of configuration.
	 * 
	 * @param xmlConfig inputstream with the File of configuration.
	 */
	public XmlLinpConfiguration(InputStream xmlConfig){
	    initialize(xmlConfig);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(File xmlConfig){
	   loadDocument(xmlConfig);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(URL xmlConfig){
		loadDocument(xmlConfig);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(InputStream xmlConfig){
		loadDocument(xmlConfig);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(Persistence persistenceConfig) {
	   buildConfiguration(persistenceConfig);    
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getCursorType() {
		Integer cursorTypeCache = super.getCursorType();
		if (cursorTypeCache != null)
			return cursorTypeCache;
		
		Object cursorType = getPropertyValue(CONFIG_PROPERTY_CURSOR_TYPE);
		
		if (cursorType == null)
			return DEFAULT_INTEGER_CURSOR_TYPE;
		
		try{
		   setCursorType(Integer.parseInt(cursorType.toString()));	
		}catch(NumberFormatException ex){
		   throw new InvalidXmlDocumentException("Property "+CONFIG_PROPERTY_CURSOR_TYPE+" not correspond to an integer" +
			   		" or int type. Use the '#' character int the xml configuration file preceding " +
			   		"the value for static methods and final properties. Eg. #java.sql.Types.OTHER",ex);
		}
			
		return super.getCursorType();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataSourceConfig getDataSourceConfig() {
		DataSourceConfig dsConfig = super.getDataSourceConfig();
		if (dsConfig != null)
			return dsConfig;
		
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		TdataSource tdataSource = configuration.getDataSource();
		
		try{
		   Class dataSourceClazz = Class.forName(tdataSource.getClass1());
		   DataSource dataSource = (DataSource) BeanUtil.createInstance(dataSourceClazz, XmlUtil.getConstructorArg(tdataSource.getPropertyArray()));
		   XmlUtil.loadTProperties(dataSource, "DataSource",tdataSource.getPropertyArray());
		   
		   Object driverValue = ConfigUtil.getValueObject(tdataSource.getDriver());
		   if (driverValue != null){
		      String driverPropertyName = tdataSource.getDriverPropertyName();
		   
		      if (driverValue instanceof String){
		    	  try{
		             Class driverClass = Class.forName(driverValue.toString());
		             dataSourceConfig.setDriver(driverClass);
		    	  }catch(ClassNotFoundException ex){
		    		  throw new PersistenceException("Driver class not found : "+driverValue.toString());
		    	  }
		      }else
		         dataSourceConfig.setDriver(driverValue.getClass());
		      
		      BeanUtil.loadProperty(dataSource, driverPropertyName, driverValue);
		      
		      dataSourceConfig.setDataSource(dataSource);
		      
		      setDataSourceConfig(dataSourceConfig);
		      return dataSourceConfig;
		   }
		}catch(Exception ex){
			throw new BeanException("Could not create DataSource",ex);
		}
		
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public SqlCommandResolver getSqlCommandResolver() {
		SqlCommandResolver commandResolver = super.getSqlCommandResolver();
		if (commandResolver != null)
			return commandResolver;
		
		Object sqlCommandResolver = getPropertyValue(CONFIG_PROPERTY_SQL_COMMAND_RESOLVER);
		
		if (sqlCommandResolver == null)
		      sqlCommandResolver = DEFAULT_SQL_COMMAND_RESOLVER;
		
		setSqlCommandResolver((SqlCommandResolver) sqlCommandResolver);
		return super.getSqlCommandResolver();
	} 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TransactionManager getTransactionManager() {
		TransactionManager transactionManagerCached = super.getTransactionManager();
		if (transactionManagerCached != null)
			return transactionManagerCached;
		
		Object transactionManager = getPropertyValue(CONFIG_PROPERTY_TRANSACTION_MANAGER);
		
		if (transactionManager == null)
	       transactionManager = LindbergBeanContext.getInstance().getBean(DEFAULT_ID_TRANSACTION_MANAGER);
			
		setTransactionManager((TransactionManager) transactionManager);
		return super.getTransactionManager();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDefaultSchema() {
	    String defaultSchemaCache = super.getDefaultSchema();
        if (defaultSchemaCache != null)
            return defaultSchemaCache;
        
        Object defaultSchema = getPropertyValue(CONFIG_PROPERTY_DEFAULT_SCHEMA);
        
        if (defaultSchema == null)
            return null;
        
        if (! (defaultSchema instanceof String))
            setDefaultSchema(defaultSchema.toString());
            
        return super.getDefaultSchema();
	}
	

	/**
	 * Get a {@link TconfigProperty} with the defined key.
	 * 
	 * @param key {@link TconfigProperty} key to search.
	 * 
	 * @return {@link TconfigProperty} instance with the defined key or null if {@link TconfigProperty} not found..
	 */
	protected TconfigProperty getPropertyFromKey(String key){
		if (configuration != null){
			ConfigProperties configProperties = configuration.getConfigProperties();
			if (configProperties != null){
				TconfigProperty[] properties = configProperties.getConfigPropertyArray();
				TconfigProperty property = XmlUtil.getPropertyFromKey(key, properties);
				
				return property;
			}
		}
		
		return null;
	}
	
	/**
	 * loads the configuration document.
	 * 
	 * @param xmlConfig xml configuration object. This argument must to be a File, URL or InputStream.
	 */
	private void loadDocument(Object xmlConfig) {
		verifyConfiguration();
		
		if (xmlConfig == null)
			throw new PersistenceConfigurationException(
					"Invalid linp xmlConfig");
        
		try {
            buildConfiguration(XmlUtil.buildDocument(xmlConfig).getPersistence());
        } catch (PersistenceConfigurationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new PersistenceConfigurationException(ex); 
        }
	}
	
	/**
	 * checks this configuration.
	 */
	private void verifyConfiguration(){
	    if (configuration != null)
            throw new IllegalStateException("Configuration is already initialized");
	}
	
	/**
	 * Build configuration based on persistence node.
	 * 
	 * @param persistence xml node.
	 */
	public void buildConfiguration(Persistence persistence){
	    verifyConfiguration();
	    
	    try {
            this.configuration = persistence;
        } catch (Exception ex) {
            throw new PersistenceConfigurationException("Loading linp xml settings failed",ex);
        }
	}
	
	/**
	 * {@inheritDoc}
	 */
	public <E> E getPropertyValue(String key) {
	    E value = super.getPropertyValue(key);
	    if (value != null)
	        return value;
	    
	    TconfigProperty tconfigProperty = getPropertyFromKey(key);
	    value = XmlUtil.getPropertyValue(tconfigProperty, keysAutomaticallyFormatted);
	    
	    return value;
	}
	
	/**
	 * {@inheritDoc}
	 */
    @Override
    public void validate() throws InvalidConfigurationException {
    	if (! configuration.validate())
     	   throw new InvalidXmlDocumentException("Persistence XML configuration is invalid. Verify the xml configuration");
    }
    
}
