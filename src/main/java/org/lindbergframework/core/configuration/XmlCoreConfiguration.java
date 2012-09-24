package org.lindbergframework.core.configuration;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.core.context.LindbergBeanContext;
import org.lindbergframework.core.context.xml.util.XmlUtil;
import org.lindbergframework.exception.BeanException;
import org.lindbergframework.exception.CoreConfigurationException;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.InvalidXmlDocumentException;
import org.lindbergframework.persistence.configuration.LinpConfiguration;
import org.lindbergframework.persistence.configuration.XmlLinpConfigurationInitializer;
import org.lindbergframework.schema.TconfigProperty;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp;

/**
 * Core configuration implementation to work with xml configuration based.
 * 
 * The XML schema  is defined in http://www.lindbergframework.org/schema/lindberg-config.xsd
 * 
 * @author Victor Lindberg
 *
 */
public class XmlCoreConfiguration extends AbstractCoreConfiguration implements ConfigurationInitializer{
    
    /**
     * XML Core node for this configuration.
     */
    private Core coreConfiguration;
    
    /**
     * XML root node for this configuration.
     */
    private LindbergConfiguration lindbergConfiguration;
    
    /**
     * Configuration properties that are automatically formatted to get bean instances, static final constantes... 
     */
    private static final String[] keysAutomaticallyFormatted = new String[] {CONFIG_PROPERTY_BEAN_FACTORY};
    
    
    public XmlCoreConfiguration(){
        //
    }
    
    /**
     * Create a XmlCoreConfiguration using {@link File}
     * 
     * @param xmlConfig configuration file.
     */
    public XmlCoreConfiguration(File xmlConfig){
       initialize(xmlConfig);
    }
    
    /**
     * Create a XmlCoreConfiguration using {@link URL}
     * 
     * @param xmlConfig configuration URL.
     */
    public XmlCoreConfiguration(URL xmlConfig){
        initialize(xmlConfig);
    }
    
    /**
     * Create a XmlCoreConfiguration using {@link InputStream}
     * 
     * @param xmlConfig configuration inputstream.
     */
    public XmlCoreConfiguration(InputStream xmlConfig){
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
     * load configuration document.
     * 
     * @param xmlConfig configuration document.
     */
    private void loadDocument(Object xmlConfig) {
        if (coreConfiguration != null)
               throw new IllegalStateException("Lindberg Core Configuration is already initialized");
        
        if (xmlConfig == null)
            throw new CoreConfigurationException(
                    "Invalid core xmlConfig. Configuration file is null or not found");

        try {
            this.lindbergConfiguration = XmlUtil.buildDocument(xmlConfig);
            this.coreConfiguration = lindbergConfiguration.getCore();
        } catch (Exception ex) {
            throw new CoreConfigurationException("Loading lindberg core xml settings failed",ex);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public BeanFactory getBeanFactory() {
        BeanFactory beanFactoryCache = super.getBeanFactory();
        if (beanFactoryCache != null)
            return beanFactoryCache;
        
        beanFactoryCache = getPropertyValue(CONFIG_PROPERTY_BEAN_FACTORY);
        if (beanFactoryCache == null)
            beanFactoryCache = CoreConfiguration.DEFAULT_BEAN_FACTORY;
        
        String basePackage = getDIBasePackage();
        if (basePackage == null)
            throw new IllegalArgumentException("The basePackages property must be defined. Configure the [lindberg.core.di-basepackage] configuration property");
        
        beanFactoryCache.loadBasepackage(basePackage);
        super.setBeanFactory(beanFactoryCache);
        
        return beanFactoryCache;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getDIBasePackage() {
        String diBasepackageCache = super.getDIBasePackage();
        if (diBasepackageCache != null)
            return diBasepackageCache;
        
        diBasepackageCache = getPropertyValue(CONFIG_PROPERTY_DI_BASEPACKAGE);
        super.setDiBasePackage(diBasepackageCache);
        
        return diBasepackageCache;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public LinpConfiguration getLinpConfiguration() {
        LinpConfiguration linpConfigCache = super.getLinpConfiguration();
        if (linpConfigCache != null)
            return linpConfigCache;
        
        if (lindbergConfiguration.getLinp() == null)
            return null;
        
        String strClassParser = getParserLinpConfig();
        if (strClassParser == null){
        	linpConfigCache = LindbergBeanContext.getInstance().getBean(LinpConfiguration.DEFAULT_ID_LINP_CONFIGURATION, lindbergConfiguration.getLinp());
        }else
           try{
              Class linpConfigClazz = Class.forName(strClassParser);
              linpConfigCache = BeanUtil.createInstance(linpConfigClazz);
              if (linpConfigCache instanceof XmlLinpConfigurationInitializer){
                  XmlLinpConfigurationInitializer linpInitializer = (XmlLinpConfigurationInitializer) linpConfigCache;
                  linpInitializer.initialize(lindbergConfiguration.getLinp());
              }else
                  throw new InvalidConfigurationException("Xml linp configuration parser does not implements XmlLinpConfigurationInitializer");
           }catch(Exception ex){
               throw new BeanException("Could not create Linp Configuration Parser",ex);
           }
        
        super.setLinpConfiguration(linpConfigCache);
        return linpConfigCache;
    }
    
    /**
     * Get the lindberg persistence configuration implementation parser.
     * 
     * @return lindberg persistence configuration implementation parser.
     */
    public String getParserLinpConfig(){
        Linp linp = lindbergConfiguration.getLinp();
        if (coreConfiguration != null && linp != null)
           return linp.getParser(); 
           
        return null;
    }
    
    /**
     * Get a {@link TconfigProperty} instance in this configuration for specified key.
     * 
     * @param key configuration property key.
     * @return {@link TconfigProperty} instance for specified key.
     */
    protected TconfigProperty getPropertyFromKey(String key){
        if (coreConfiguration != null){
                TconfigProperty[] properties = coreConfiguration.getConfigPropertyArray();
                TconfigProperty property = XmlUtil.getPropertyFromKey(key, properties);
                
                return property;
        }
        
        return null;
    }
    
    /**
     * get the configuration properties array in this configuration.
     * 
     * @return configuration properties array in this configuration.
     */
    protected TconfigProperty[] getConfigProperties(){
        return coreConfiguration.getConfigPropertyArray();
    }
    
    /**
     * {@inheritDoc}
     */
    public <E> E getPropertyValue(String key) {
        E value = (E) super.getPropertyValue(key);
        if (value != null)
            return value;
        
        TconfigProperty tconfigProperty = getPropertyFromKey(key);
        value = (E) XmlUtil.getPropertyValue(tconfigProperty, keysAutomaticallyFormatted);
        
        return value;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() throws InvalidConfigurationException {
        if (coreConfiguration == null)
            return;
        
        if (! coreConfiguration.validate())
           throw new InvalidXmlDocumentException("Lindberg Core XML configuration is invalid. Verify the xml configuration");
        verifyRequiredConfigProperties();
    }
    
    /**
     * checks required core configuration properties.
     */
    private void verifyRequiredConfigProperties(){
       if (StringUtils.isEmpty(getDIBasePackage()))
           throw new InvalidXmlDocumentException("Lindberg Core XML configuration is invalid. "+CoreConfiguration.CONFIG_PROPERTY_DI_BASEPACKAGE+" core property is not defined");
    }
    
}
