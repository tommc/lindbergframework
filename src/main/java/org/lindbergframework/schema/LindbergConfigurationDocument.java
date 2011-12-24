/*
 * An XML document type.
 * Localname: lindberg-configuration
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.LindbergConfigurationDocument
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema;


/**
 * A document containing one lindberg-configuration(@http://www.lindbergframework.org/schema) element.
 *
 * This is a complex type.
 */
public interface LindbergConfigurationDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LindbergConfigurationDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("lindbergconfiguration421ddoctype");
     
    /**
     * Gets the "lindberg-configuration" element
     */
    org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration getLindbergConfiguration();
    
    /**
     * Sets the "lindberg-configuration" element
     */
    void setLindbergConfiguration(org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration lindbergConfiguration);
    
    /**
     * Appends and returns a new empty "lindberg-configuration" element
     */
    org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration addNewLindbergConfiguration();
    
    /**
     * An XML lindberg-configuration(@http://www.lindbergframework.org/schema).
     *
     * This is a complex type.
     */
    public interface LindbergConfiguration extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LindbergConfiguration.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("lindbergconfiguration96adelemtype");
        
        /**
         * Gets the "core" element
         */
        org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core getCore();
        
        /**
         * True if has "core" element
         */
        boolean isSetCore();
        
        /**
         * Sets the "core" element
         */
        void setCore(org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core core);
        
        /**
         * Appends and returns a new empty "core" element
         */
        org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core addNewCore();
        
        /**
         * Unsets the "core" element
         */
        void unsetCore();
        
        /**
         * Gets the "linp" element
         */
        org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp getLinp();
        
        /**
         * True if has "linp" element
         */
        boolean isSetLinp();
        
        /**
         * Sets the "linp" element
         */
        void setLinp(org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp linp);
        
        /**
         * Appends and returns a new empty "linp" element
         */
        org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp addNewLinp();
        
        /**
         * Unsets the "linp" element
         */
        void unsetLinp();
        
        /**
         * An XML core(@http://www.lindbergframework.org/schema).
         *
         * This is a complex type.
         */
        public interface Core extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Core.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("corec728elemtype");
            
            /**
             * Gets a List of "config-property" elements
             */
            java.util.List<org.lindbergframework.schema.TconfigProperty> getConfigPropertyList();
            
            /**
             * Gets array of all "config-property" elements
             * @deprecated
             */
            org.lindbergframework.schema.TconfigProperty[] getConfigPropertyArray();
            
            /**
             * Gets ith "config-property" element
             */
            org.lindbergframework.schema.TconfigProperty getConfigPropertyArray(int i);
            
            /**
             * Returns number of "config-property" element
             */
            int sizeOfConfigPropertyArray();
            
            /**
             * Sets array of all "config-property" element
             */
            void setConfigPropertyArray(org.lindbergframework.schema.TconfigProperty[] configPropertyArray);
            
            /**
             * Sets ith "config-property" element
             */
            void setConfigPropertyArray(int i, org.lindbergframework.schema.TconfigProperty configProperty);
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "config-property" element
             */
            org.lindbergframework.schema.TconfigProperty insertNewConfigProperty(int i);
            
            /**
             * Appends and returns a new empty value (as xml) as the last "config-property" element
             */
            org.lindbergframework.schema.TconfigProperty addNewConfigProperty();
            
            /**
             * Removes the ith "config-property" element
             */
            void removeConfigProperty(int i);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core newInstance() {
                  return (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Core) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * An XML linp(@http://www.lindbergframework.org/schema).
         *
         * This is a complex type.
         */
        public interface Linp extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Linp.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("linp0f88elemtype");
            
            /**
             * Gets the "dataSource" element
             */
            org.lindbergframework.schema.TdataSource getDataSource();
            
            /**
             * Sets the "dataSource" element
             */
            void setDataSource(org.lindbergframework.schema.TdataSource dataSource);
            
            /**
             * Appends and returns a new empty "dataSource" element
             */
            org.lindbergframework.schema.TdataSource addNewDataSource();
            
            /**
             * Gets the "config-properties" element
             */
            org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties getConfigProperties();
            
            /**
             * True if has "config-properties" element
             */
            boolean isSetConfigProperties();
            
            /**
             * Sets the "config-properties" element
             */
            void setConfigProperties(org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties configProperties);
            
            /**
             * Appends and returns a new empty "config-properties" element
             */
            org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties addNewConfigProperties();
            
            /**
             * Unsets the "config-properties" element
             */
            void unsetConfigProperties();
            
            /**
             * Gets the "parser" attribute
             */
            java.lang.String getParser();
            
            /**
             * Gets (as xml) the "parser" attribute
             */
            org.apache.xmlbeans.XmlString xgetParser();
            
            /**
             * True if has "parser" attribute
             */
            boolean isSetParser();
            
            /**
             * Sets the "parser" attribute
             */
            void setParser(java.lang.String parser);
            
            /**
             * Sets (as xml) the "parser" attribute
             */
            void xsetParser(org.apache.xmlbeans.XmlString parser);
            
            /**
             * Unsets the "parser" attribute
             */
            void unsetParser();
            
            /**
             * An XML config-properties(@http://www.lindbergframework.org/schema).
             *
             * This is a complex type.
             */
            public interface ConfigProperties extends org.apache.xmlbeans.XmlObject
            {
                public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                    org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ConfigProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("configpropertiesf5beelemtype");
                
                /**
                 * Gets a List of "config-property" elements
                 */
                java.util.List<org.lindbergframework.schema.TconfigProperty> getConfigPropertyList();
                
                /**
                 * Gets array of all "config-property" elements
                 * @deprecated
                 */
                org.lindbergframework.schema.TconfigProperty[] getConfigPropertyArray();
                
                /**
                 * Gets ith "config-property" element
                 */
                org.lindbergframework.schema.TconfigProperty getConfigPropertyArray(int i);
                
                /**
                 * Returns number of "config-property" element
                 */
                int sizeOfConfigPropertyArray();
                
                /**
                 * Sets array of all "config-property" element
                 */
                void setConfigPropertyArray(org.lindbergframework.schema.TconfigProperty[] configPropertyArray);
                
                /**
                 * Sets ith "config-property" element
                 */
                void setConfigPropertyArray(int i, org.lindbergframework.schema.TconfigProperty configProperty);
                
                /**
                 * Inserts and returns a new empty value (as xml) as the ith "config-property" element
                 */
                org.lindbergframework.schema.TconfigProperty insertNewConfigProperty(int i);
                
                /**
                 * Appends and returns a new empty value (as xml) as the last "config-property" element
                 */
                org.lindbergframework.schema.TconfigProperty addNewConfigProperty();
                
                /**
                 * Removes the ith "config-property" element
                 */
                void removeConfigProperty(int i);
                
                /**
                 * A factory class with static methods for creating instances
                 * of this type.
                 */
                
                public static final class Factory
                {
                    public static org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties newInstance() {
                      return (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                    
                    public static org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties newInstance(org.apache.xmlbeans.XmlOptions options) {
                      return (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp.ConfigProperties) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                    
                    private Factory() { } // No instance of this class allowed
                }
            }
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp newInstance() {
                  return (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration newInstance() {
              return (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.lindbergframework.schema.LindbergConfigurationDocument newInstance() {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.LindbergConfigurationDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.LindbergConfigurationDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
