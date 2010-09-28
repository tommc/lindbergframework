package org.lindbergframework.core.context;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.core.context.xml.util.XmlUtil;
import org.lindbergframework.exception.BeanException;
import org.lindbergframework.exception.CoreConfigurationException;
import org.lindbergframework.exception.InvalidConfigurationException;
import org.lindbergframework.exception.InvalidXmlDocumentException;
import org.lindbergframework.persistence.context.LinpConfiguration;
import org.lindbergframework.persistence.context.XmlLinpConfiguration;
import org.lindbergframework.persistence.context.XmlLinpConfigurationInitializer;
import org.lindbergframework.schema.TconfigProperty;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Persistence;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class XmlCoreConfiguration extends AbstractCoreConfiguration implements ConfigurationInitializer{
     
    private Core coreConfiguration;
    
    private LindbergConfiguration lindbergConfiguration;
    
    private static final String[] keysAutomaticallyFormatted = new String[] {CONFIG_PROPERTY_BEAN_FACTORY};
    
    
    public XmlCoreConfiguration(){
        //
    }
    
    public XmlCoreConfiguration(File xmlConfig){
       initialize(xmlConfig);
    }
    
    public XmlCoreConfiguration(URL xmlConfig){
        initialize(xmlConfig);
    }
    
    public XmlCoreConfiguration(InputStream xmlConfig){
        initialize(xmlConfig);
    }
    
    public void initialize(File xmlConfig){
       loadDocument(xmlConfig);
    }
    
    public void initialize(URL xmlConfig){
        loadDocument(xmlConfig);
    }
    
    public void initialize(InputStream xmlConfig){
        loadDocument(xmlConfig);
    }
    
    private void loadDocument(Object xmlConfig) {
        if (coreConfiguration != null)
               throw new IllegalStateException("Lindberg Core Configuration is already initialized");
        
        if (xmlConfig == null)
            throw new CoreConfigurationException(
                    "Invalid core xmlConfig. Configuration File is Null");

        try {
            this.lindbergConfiguration = XmlUtil.buildDocument(xmlConfig);
            this.coreConfiguration = lindbergConfiguration.getCore();
        } catch (Exception ex) {
            throw new CoreConfigurationException("Loading lindberg core xml settings failed",ex);
        }
    }
    
    @Override
    public BeanFactory getBeanFactory() {
        BeanFactory beanFactoryCache = super.getBeanFactory();
        if (beanFactoryCache != null)
            return beanFactoryCache;
        
        beanFactoryCache = getPropertyValue(CONFIG_PROPERTY_BEAN_FACTORY);
        if (beanFactoryCache == null)
            beanFactoryCache = CoreConfiguration.DEFAULT_BEAN_FACTORY;
        beanFactoryCache.loadBasepackage(getDIBasePackage());
        super.setBeanFactory(beanFactoryCache);
        
        return beanFactoryCache;
    }
    
    @Override
    public String getDIBasePackage() {
        String diBasepackageCache = super.getDIBasePackage();
        if (diBasepackageCache != null)
            return diBasepackageCache;
        
        diBasepackageCache = getPropertyValue(CONFIG_PROPERTY_DI_BASEPACKAGE);
        super.setDiBasePackage(diBasepackageCache);
        
        return diBasepackageCache;
    }
    
    @Override
    public LinpConfiguration getLinpConfiguration() {
        LinpConfiguration linpConfigCache = super.getLinpConfiguration();
        if (linpConfigCache != null)
            return linpConfigCache;
        
        if (lindbergConfiguration.getPersistence() == null)
            return null;
        
        String strClassParser = getParserLinpConfig();
        if (strClassParser == null){
            linpConfigCache = new XmlLinpConfiguration(lindbergConfiguration.getPersistence());
        }else
           try{
              Class linpConfigClazz = Class.forName(strClassParser);
              linpConfigCache = BeanUtil.createInstance(linpConfigClazz);
              if (linpConfigCache instanceof XmlLinpConfigurationInitializer){
                  XmlLinpConfigurationInitializer linpInitializer = (XmlLinpConfigurationInitializer) linpConfigCache;
                  linpInitializer.initialize(lindbergConfiguration.getPersistence());
              }else
                  throw new InvalidConfigurationException("Xml linp configuration parser does not implements XmlLinpConfigurationInitializer");
           }catch(Exception ex){
               throw new BeanException("Could not create Linp Configuration Parser",ex);
           }
        
        super.setLinpConfiguration(linpConfigCache);
        return linpConfigCache;
    }
    
    public String getParserLinpConfig(){
        Persistence persistence = lindbergConfiguration.getPersistence();
        if (coreConfiguration != null && persistence != null)
           return persistence.getParser(); 
           
        return null;
    }
    
    protected TconfigProperty getPropertyFromKey(String key){
        if (coreConfiguration != null){
                TconfigProperty[] properties = coreConfiguration.getConfigPropertyArray();
                TconfigProperty property = XmlUtil.getPropertyFromKey(key, properties);
                
                return property;
        }
        
        return null;
    }
    
    
    protected TconfigProperty[] getConfigProperties(){
        return coreConfiguration.getConfigPropertyArray();
    }
    
    public <E> E getPropertyValue(String key) {
        E value = super.getPropertyValue(key);
        if (value != null)
            return value;
        
        TconfigProperty tconfigProperty = getPropertyFromKey(key);
        value = XmlUtil.getPropertyValue(tconfigProperty, keysAutomaticallyFormatted);
        
        return value;
    }
    
    @Override
    public void validate() throws InvalidConfigurationException {
        if (! coreConfiguration.validate())
           throw new InvalidXmlDocumentException("Lindberg Core XML configuration is invalid. Verify the xml configuration");
        verifyRequiredConfigProperties();
    }
    
    private void verifyRequiredConfigProperties(){
       if (StringUtils.isEmpty(getDIBasePackage()))
           throw new InvalidXmlDocumentException("Lindberg Core XML configuration is invalid. "+CoreConfiguration.CONFIG_PROPERTY_DI_BASEPACKAGE+" core property is not defined");
    }
    
}
