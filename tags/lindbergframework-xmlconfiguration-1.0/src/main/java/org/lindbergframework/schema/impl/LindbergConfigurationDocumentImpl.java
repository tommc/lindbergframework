/*
 * An XML document type.
 * Localname: lindberg-configuration
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.LindbergConfigurationDocument
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema.impl;
/**
 * A document containing one lindberg-configuration(@http://www.lindbergframework.org/schema) element.
 *
 * This is a complex type.
 */
public class LindbergConfigurationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.LindbergConfigurationDocument
{
    private static final long serialVersionUID = 1L;
    
    public LindbergConfigurationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LINDBERGCONFIGURATION$0 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "lindberg-configuration");
    
    
    /**
     * Gets the "lindberg-configuration" element
     */
    public org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration getLindbergConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration target = null;
            target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration)get_store().find_element_user(LINDBERGCONFIGURATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "lindberg-configuration" element
     */
    public void setLindbergConfiguration(org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration lindbergConfiguration)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration target = null;
            target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration)get_store().find_element_user(LINDBERGCONFIGURATION$0, 0);
            if (target == null)
            {
                target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration)get_store().add_element_user(LINDBERGCONFIGURATION$0);
            }
            target.set(lindbergConfiguration);
        }
    }
    
    /**
     * Appends and returns a new empty "lindberg-configuration" element
     */
    public org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration addNewLindbergConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration target = null;
            target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration)get_store().add_element_user(LINDBERGCONFIGURATION$0);
            return target;
        }
    }
    /**
     * An XML lindberg-configuration(@http://www.lindbergframework.org/schema).
     *
     * This is a complex type.
     */
    public static class LindbergConfigurationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration
    {
        private static final long serialVersionUID = 1L;
        
        public LindbergConfigurationImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CORE$0 = 
            new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "core");
        private static final javax.xml.namespace.QName LINP$2 = 
            new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "linp");
        
        
        /**
         * Gets the "core" element
         */
        public org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core getCore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core target = null;
                target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core)get_store().find_element_user(CORE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "core" element
         */
        public boolean isSetCore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CORE$0) != 0;
            }
        }
        
        /**
         * Sets the "core" element
         */
        public void setCore(org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core core)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core target = null;
                target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core)get_store().find_element_user(CORE$0, 0);
                if (target == null)
                {
                    target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core)get_store().add_element_user(CORE$0);
                }
                target.set(core);
            }
        }
        
        /**
         * Appends and returns a new empty "core" element
         */
        public org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core addNewCore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core target = null;
                target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core)get_store().add_element_user(CORE$0);
                return target;
            }
        }
        
        /**
         * Unsets the "core" element
         */
        public void unsetCore()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CORE$0, 0);
            }
        }
        
        /**
         * Gets the "linp" element
         */
        public org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp getLinp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp target = null;
                target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp)get_store().find_element_user(LINP$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "linp" element
         */
        public boolean isSetLinp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(LINP$2) != 0;
            }
        }
        
        /**
         * Sets the "linp" element
         */
        public void setLinp(org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp linp)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp target = null;
                target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp)get_store().find_element_user(LINP$2, 0);
                if (target == null)
                {
                    target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp)get_store().add_element_user(LINP$2);
                }
                target.set(linp);
            }
        }
        
        /**
         * Appends and returns a new empty "linp" element
         */
        public org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp addNewLinp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp target = null;
                target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp)get_store().add_element_user(LINP$2);
                return target;
            }
        }
        
        /**
         * Unsets the "linp" element
         */
        public void unsetLinp()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(LINP$2, 0);
            }
        }
        /**
         * An XML core(@http://www.lindbergframework.org/schema).
         *
         * This is a complex type.
         */
        public static class CoreImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core
        {
            private static final long serialVersionUID = 1L;
            
            public CoreImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName CONFIGPROPERTY$0 = 
                new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "config-property");
            
            
            /**
             * Gets a List of "config-property" elements
             */
            public java.util.List<org.lindbergframework.schema.TconfigProperty> getConfigPropertyList()
            {
                final class ConfigPropertyList extends java.util.AbstractList<org.lindbergframework.schema.TconfigProperty>
                {
                    public org.lindbergframework.schema.TconfigProperty get(int i)
                        { return CoreImpl.this.getConfigPropertyArray(i); }
                    
                    public org.lindbergframework.schema.TconfigProperty set(int i, org.lindbergframework.schema.TconfigProperty o)
                    {
                      org.lindbergframework.schema.TconfigProperty old = CoreImpl.this.getConfigPropertyArray(i);
                      CoreImpl.this.setConfigPropertyArray(i, o);
                      return old;
                    }
                    
                    public void add(int i, org.lindbergframework.schema.TconfigProperty o)
                        { CoreImpl.this.insertNewConfigProperty(i).set(o); }
                    
                    public org.lindbergframework.schema.TconfigProperty remove(int i)
                    {
                      org.lindbergframework.schema.TconfigProperty old = CoreImpl.this.getConfigPropertyArray(i);
                      CoreImpl.this.removeConfigProperty(i);
                      return old;
                    }
                    
                    public int size()
                        { return CoreImpl.this.sizeOfConfigPropertyArray(); }
                    
                }
                
                synchronized (monitor())
                {
                    check_orphaned();
                    return new ConfigPropertyList();
                }
            }
            
            /**
             * Gets array of all "config-property" elements
             * @deprecated
             */
            public org.lindbergframework.schema.TconfigProperty[] getConfigPropertyArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    java.util.List<org.lindbergframework.schema.TconfigProperty> targetList = new java.util.ArrayList<org.lindbergframework.schema.TconfigProperty>();
                    get_store().find_all_element_users(CONFIGPROPERTY$0, targetList);
                    org.lindbergframework.schema.TconfigProperty[] result = new org.lindbergframework.schema.TconfigProperty[targetList.size()];
                    targetList.toArray(result);
                    return result;
                }
            }
            
            /**
             * Gets ith "config-property" element
             */
            public org.lindbergframework.schema.TconfigProperty getConfigPropertyArray(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TconfigProperty target = null;
                    target = (org.lindbergframework.schema.TconfigProperty)get_store().find_element_user(CONFIGPROPERTY$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    return target;
                }
            }
            
            /**
             * Returns number of "config-property" element
             */
            public int sizeOfConfigPropertyArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().count_elements(CONFIGPROPERTY$0);
                }
            }
            
            /**
             * Sets array of all "config-property" element
             */
            public void setConfigPropertyArray(org.lindbergframework.schema.TconfigProperty[] configPropertyArray)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    arraySetterHelper(configPropertyArray, CONFIGPROPERTY$0);
                }
            }
            
            /**
             * Sets ith "config-property" element
             */
            public void setConfigPropertyArray(int i, org.lindbergframework.schema.TconfigProperty configProperty)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TconfigProperty target = null;
                    target = (org.lindbergframework.schema.TconfigProperty)get_store().find_element_user(CONFIGPROPERTY$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    target.set(configProperty);
                }
            }
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "config-property" element
             */
            public org.lindbergframework.schema.TconfigProperty insertNewConfigProperty(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TconfigProperty target = null;
                    target = (org.lindbergframework.schema.TconfigProperty)get_store().insert_element_user(CONFIGPROPERTY$0, i);
                    return target;
                }
            }
            
            /**
             * Appends and returns a new empty value (as xml) as the last "config-property" element
             */
            public org.lindbergframework.schema.TconfigProperty addNewConfigProperty()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TconfigProperty target = null;
                    target = (org.lindbergframework.schema.TconfigProperty)get_store().add_element_user(CONFIGPROPERTY$0);
                    return target;
                }
            }
            
            /**
             * Removes the ith "config-property" element
             */
            public void removeConfigProperty(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_element(CONFIGPROPERTY$0, i);
                }
            }
        }
        /**
         * An XML linp(@http://www.lindbergframework.org/schema).
         *
         * This is a complex type.
         */
        public static class LinpImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp
        {
            private static final long serialVersionUID = 1L;
            
            public LinpImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName DATASOURCE$0 = 
                new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "dataSource");
            private static final javax.xml.namespace.QName CONFIGPROPERTIES$2 = 
                new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "config-properties");
            private static final javax.xml.namespace.QName PARSER$4 = 
                new javax.xml.namespace.QName("", "parser");
            
            
            /**
             * Gets the "dataSource" element
             */
            public org.lindbergframework.schema.TdataSource getDataSource()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TdataSource target = null;
                    target = (org.lindbergframework.schema.TdataSource)get_store().find_element_user(DATASOURCE$0, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target;
                }
            }
            
            /**
             * Sets the "dataSource" element
             */
            public void setDataSource(org.lindbergframework.schema.TdataSource dataSource)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TdataSource target = null;
                    target = (org.lindbergframework.schema.TdataSource)get_store().find_element_user(DATASOURCE$0, 0);
                    if (target == null)
                    {
                      target = (org.lindbergframework.schema.TdataSource)get_store().add_element_user(DATASOURCE$0);
                    }
                    target.set(dataSource);
                }
            }
            
            /**
             * Appends and returns a new empty "dataSource" element
             */
            public org.lindbergframework.schema.TdataSource addNewDataSource()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TdataSource target = null;
                    target = (org.lindbergframework.schema.TdataSource)get_store().add_element_user(DATASOURCE$0);
                    return target;
                }
            }
            
            /**
             * Gets the "config-properties" element
             */
            public org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties getConfigProperties()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties target = null;
                    target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties)get_store().find_element_user(CONFIGPROPERTIES$2, 0);
                    if (target == null)
                    {
                      return null;
                    }
                    return target;
                }
            }
            
            /**
             * True if has "config-properties" element
             */
            public boolean isSetConfigProperties()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().count_elements(CONFIGPROPERTIES$2) != 0;
                }
            }
            
            /**
             * Sets the "config-properties" element
             */
            public void setConfigProperties(org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties configProperties)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties target = null;
                    target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties)get_store().find_element_user(CONFIGPROPERTIES$2, 0);
                    if (target == null)
                    {
                      target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties)get_store().add_element_user(CONFIGPROPERTIES$2);
                    }
                    target.set(configProperties);
                }
            }
            
            /**
             * Appends and returns a new empty "config-properties" element
             */
            public org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties addNewConfigProperties()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties target = null;
                    target = (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties)get_store().add_element_user(CONFIGPROPERTIES$2);
                    return target;
                }
            }
            
            /**
             * Unsets the "config-properties" element
             */
            public void unsetConfigProperties()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_element(CONFIGPROPERTIES$2, 0);
                }
            }
            
            /**
             * Gets the "parser" attribute
             */
            public java.lang.String getParser()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PARSER$4);
                    if (target == null)
                    {
                      return null;
                    }
                    return target.getStringValue();
                }
            }
            
            /**
             * Gets (as xml) the "parser" attribute
             */
            public org.apache.xmlbeans.XmlString xgetParser()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PARSER$4);
                    return target;
                }
            }
            
            /**
             * True if has "parser" attribute
             */
            public boolean isSetParser()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().find_attribute_user(PARSER$4) != null;
                }
            }
            
            /**
             * Sets the "parser" attribute
             */
            public void setParser(java.lang.String parser)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.SimpleValue target = null;
                    target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PARSER$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PARSER$4);
                    }
                    target.setStringValue(parser);
                }
            }
            
            /**
             * Sets (as xml) the "parser" attribute
             */
            public void xsetParser(org.apache.xmlbeans.XmlString parser)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.apache.xmlbeans.XmlString target = null;
                    target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PARSER$4);
                    if (target == null)
                    {
                      target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PARSER$4);
                    }
                    target.set(parser);
                }
            }
            
            /**
             * Unsets the "parser" attribute
             */
            public void unsetParser()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_attribute(PARSER$4);
                }
            }
            /**
             * An XML config-properties(@http://www.lindbergframework.org/schema).
             *
             * This is a complex type.
             */
            public static class ConfigPropertiesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties
            {
                private static final long serialVersionUID = 1L;
                
                public ConfigPropertiesImpl(org.apache.xmlbeans.SchemaType sType)
                {
                    super(sType);
                }
                
                private static final javax.xml.namespace.QName CONFIGPROPERTY$0 = 
                    new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "config-property");
                
                
                /**
                 * Gets a List of "config-property" elements
                 */
                public java.util.List<org.lindbergframework.schema.TconfigProperty> getConfigPropertyList()
                {
                    final class ConfigPropertyList extends java.util.AbstractList<org.lindbergframework.schema.TconfigProperty>
                    {
                      public org.lindbergframework.schema.TconfigProperty get(int i)
                          { return ConfigPropertiesImpl.this.getConfigPropertyArray(i); }
                      
                      public org.lindbergframework.schema.TconfigProperty set(int i, org.lindbergframework.schema.TconfigProperty o)
                      {
                        org.lindbergframework.schema.TconfigProperty old = ConfigPropertiesImpl.this.getConfigPropertyArray(i);
                        ConfigPropertiesImpl.this.setConfigPropertyArray(i, o);
                        return old;
                      }
                      
                      public void add(int i, org.lindbergframework.schema.TconfigProperty o)
                          { ConfigPropertiesImpl.this.insertNewConfigProperty(i).set(o); }
                      
                      public org.lindbergframework.schema.TconfigProperty remove(int i)
                      {
                        org.lindbergframework.schema.TconfigProperty old = ConfigPropertiesImpl.this.getConfigPropertyArray(i);
                        ConfigPropertiesImpl.this.removeConfigProperty(i);
                        return old;
                      }
                      
                      public int size()
                          { return ConfigPropertiesImpl.this.sizeOfConfigPropertyArray(); }
                      
                    }
                    
                    synchronized (monitor())
                    {
                      check_orphaned();
                      return new ConfigPropertyList();
                    }
                }
                
                /**
                 * Gets array of all "config-property" elements
                 * @deprecated
                 */
                public org.lindbergframework.schema.TconfigProperty[] getConfigPropertyArray()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      java.util.List<org.lindbergframework.schema.TconfigProperty> targetList = new java.util.ArrayList<org.lindbergframework.schema.TconfigProperty>();
                      get_store().find_all_element_users(CONFIGPROPERTY$0, targetList);
                      org.lindbergframework.schema.TconfigProperty[] result = new org.lindbergframework.schema.TconfigProperty[targetList.size()];
                      targetList.toArray(result);
                      return result;
                    }
                }
                
                /**
                 * Gets ith "config-property" element
                 */
                public org.lindbergframework.schema.TconfigProperty getConfigPropertyArray(int i)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.lindbergframework.schema.TconfigProperty target = null;
                      target = (org.lindbergframework.schema.TconfigProperty)get_store().find_element_user(CONFIGPROPERTY$0, i);
                      if (target == null)
                      {
                        throw new IndexOutOfBoundsException();
                      }
                      return target;
                    }
                }
                
                /**
                 * Returns number of "config-property" element
                 */
                public int sizeOfConfigPropertyArray()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      return get_store().count_elements(CONFIGPROPERTY$0);
                    }
                }
                
                /**
                 * Sets array of all "config-property" element
                 */
                public void setConfigPropertyArray(org.lindbergframework.schema.TconfigProperty[] configPropertyArray)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      arraySetterHelper(configPropertyArray, CONFIGPROPERTY$0);
                    }
                }
                
                /**
                 * Sets ith "config-property" element
                 */
                public void setConfigPropertyArray(int i, org.lindbergframework.schema.TconfigProperty configProperty)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.lindbergframework.schema.TconfigProperty target = null;
                      target = (org.lindbergframework.schema.TconfigProperty)get_store().find_element_user(CONFIGPROPERTY$0, i);
                      if (target == null)
                      {
                        throw new IndexOutOfBoundsException();
                      }
                      target.set(configProperty);
                    }
                }
                
                /**
                 * Inserts and returns a new empty value (as xml) as the ith "config-property" element
                 */
                public org.lindbergframework.schema.TconfigProperty insertNewConfigProperty(int i)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.lindbergframework.schema.TconfigProperty target = null;
                      target = (org.lindbergframework.schema.TconfigProperty)get_store().insert_element_user(CONFIGPROPERTY$0, i);
                      return target;
                    }
                }
                
                /**
                 * Appends and returns a new empty value (as xml) as the last "config-property" element
                 */
                public org.lindbergframework.schema.TconfigProperty addNewConfigProperty()
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      org.lindbergframework.schema.TconfigProperty target = null;
                      target = (org.lindbergframework.schema.TconfigProperty)get_store().add_element_user(CONFIGPROPERTY$0);
                      return target;
                    }
                }
                
                /**
                 * Removes the ith "config-property" element
                 */
                public void removeConfigProperty(int i)
                {
                    synchronized (monitor())
                    {
                      check_orphaned();
                      get_store().remove_element(CONFIGPROPERTY$0, i);
                    }
                }
            }
        }
    }
}
