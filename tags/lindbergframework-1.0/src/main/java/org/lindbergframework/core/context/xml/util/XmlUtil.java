package org.lindbergframework.core.context.xml.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlException;
import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.exception.LindbergException;
import org.lindbergframework.exception.LoadXmlPropertyException;
import org.lindbergframework.schema.LindbergConfigurationDocument;
import org.lindbergframework.schema.TconfigProperty;
import org.lindbergframework.schema.Tproperty;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration;
import org.lindbergframework.util.ConfigUtil;
import org.lindbergframework.util.LogUtil;

/**
 * Utilitary class for XML operations.
 * 
 * @author Victor Lindberg
 *
 */
public final class XmlUtil {
    
    /**
     * Build a {@link LindbergConfiguration} instance of configuration document.
     * 
     * @param xmlConfig configuration file.
     * @return {@link LindbergConfiguration} instance of configuration document.
     * 
     * @throws IOException configuration file failed.
     * @throws XmlException xml parse failed.
     */
    public static LindbergConfiguration buildDocument(Object xmlConfig) throws IOException, XmlException {
        LindbergConfigurationDocument doc = null;
        
        if (xmlConfig instanceof File)
            doc = LindbergConfigurationDocument.Factory.parse((File) xmlConfig);
        else 
            if (xmlConfig instanceof URL)
               doc = LindbergConfigurationDocument.Factory.parse((URL) xmlConfig);
            else 
               if (xmlConfig instanceof InputStream) {
                  InputStream inputStreamConfig = (InputStream) xmlConfig;
                  doc = LindbergConfigurationDocument.Factory.parse((InputStream) xmlConfig);
               }
               else
                  throw new IllegalStateException("invalid configuration file : "+xmlConfig);
        
        return doc.getLindbergConfiguration();
    }
    
    /**
     * Get {@link TconfigProperty} instance of configuration property with id specified in the properties array.
     * 
     * @param key configuration property key.
     * @param properties properties array.
     * @return {@link TconfigProperty} instance for key argument specified or null if property not found.
     */
    public static TconfigProperty getPropertyFromKey(String key,TconfigProperty[] properties){
        for (TconfigProperty property : properties)
            if (property.getName().equalsIgnoreCase(key))
                return property;
        
        return null;
     }
    
    /**
     * Get {@link TconfigProperty} value and format it if necessary.
     * @param <E> value type expected.
     * @param property {@link TconfigProperty} instance.
     * @param keysAutomaticallyFormatted keys that are Automatically Formatted.
     * @return {@link TconfigProperty} value.
     */
    public static <E> E getPropertyValue(TconfigProperty property,String... keysAutomaticallyFormatted) {
        if (property != null) {
            String value = property.getValue();

            if (value != null){
                if (ArrayUtils.contains(keysAutomaticallyFormatted, property.getName()))
                    value = formatInstanceProperty(value);
                
                E bean =  (E) ConfigUtil.getValueObject(value,getConstructorArg(property));
                try {
                    loadTProperties(bean, property.getName(),property.getPropertyArray());
                    return bean;
                } catch (BeanPopulateException ex) {
                    throw new LindbergException("Erro loading properties in "+bean,ex);
                }
            }
        }

        return null;
    }
    
    /**
     * format a configuration property value.
     * 
     * @param property property value.
     * @return value formatted.
     */
    public static String formatInstanceProperty(String property){
        if (! property.startsWith("#"))
            property = "#" + property;
        
        return property;
    }
    
    /**
     * loads all {@link Tproperty} in bean instance specified.
     * 
     * @param bean bean instance to load.
     * @param configPropertyName configuration property name.
     * @param tproperties properties values.
     * @throws LoadXmlPropertyException bean loading failed.
     */
    public static void loadTProperties(Object bean,String configPropertyName,Tproperty[] tproperties) throws BeanPopulateException{
        for (Tproperty tproperty : tproperties){
           if (! tproperty.getConstructorArg()){
              if (StringUtils.isNotEmpty(tproperty.getName()))
                 BeanUtil.loadProperty(bean, tproperty.getName(), getValueTproperty(tproperty));
              else
                 LogUtil.logWarning("Lindberg Config Property ["+configPropertyName+"] contains declared inner properties with constructor-arg " +
                 		"attribute equal false but without name defined. These properties are ignored"); 
           }
        }
    }
    
    /**
     * Get property values that are constructor argument.
     * @param property configuration property.
     * @return constructor arguments.
     */
    public static Object[] getConstructorArg(TconfigProperty property){
        return getConstructorArg(property.getPropertyArray());
    }
    
    /**
     * Get property values that are constructor argument.
     * @param tproperties configuration properties.
     * @return constructor arguments.
     */
    public static Object[] getConstructorArg(Tproperty[] tproperties){
        List<Object> list = new ArrayList<Object>();
        for (Tproperty tproperty : tproperties){
            if (tproperty.getConstructorArg())
                list.add(getValueTproperty(tproperty));
        }
        
        return list.toArray();
        
    }
    
    /**
     * Get {@link Tproperty} value.
     * 
     * @param tproperty configuration property.
     * @return property value.
     */
    public static Object getValueTproperty(Tproperty tproperty){
        if (tproperty.getValue() == null){
            if (tproperty.getArray() != null)
               return ConfigUtil.stringToArray(tproperty.getArray());
            else
               if (tproperty.getList() != null)
                   return ConfigUtil.stringToList(tproperty.getList());
        }
        
        return ConfigUtil.getValueObject(tproperty.getValue());
    }

}
