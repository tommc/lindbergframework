/*
 * An XML document type.
 * Localname: Linp-Mapping
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.LinpMappingDocument
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema;


/**
 * A document containing one Linp-Mapping(@http://www.lindbergframework.org/schema) element.
 *
 * This is a complex type.
 */
public interface LinpMappingDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LinpMappingDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s91172342D13B33D787C1EF15C0A6C401").resolveHandle("linpmappingdf89doctype");
    
    /**
     * Gets the "Linp-Mapping" element
     */
    org.lindbergframework.schema.LinpMappingDocument.LinpMapping getLinpMapping();
    
    /**
     * Sets the "Linp-Mapping" element
     */
    void setLinpMapping(org.lindbergframework.schema.LinpMappingDocument.LinpMapping linpMapping);
    
    /**
     * Appends and returns a new empty "Linp-Mapping" element
     */
    org.lindbergframework.schema.LinpMappingDocument.LinpMapping addNewLinpMapping();
    
    /**
     * An XML Linp-Mapping(@http://www.lindbergframework.org/schema).
     *
     * This is a complex type.
     */
    public interface LinpMapping extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LinpMapping.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s91172342D13B33D787C1EF15C0A6C401").resolveHandle("linpmappingb26delemtype");
        
        /**
         * Gets the "Description" element
         */
        java.lang.String getDescription();
        
        /**
         * Gets (as xml) the "Description" element
         */
        org.apache.xmlbeans.XmlString xgetDescription();
        
        /**
         * True if has "Description" element
         */
        boolean isSetDescription();
        
        /**
         * Sets the "Description" element
         */
        void setDescription(java.lang.String description);
        
        /**
         * Sets (as xml) the "Description" element
         */
        void xsetDescription(org.apache.xmlbeans.XmlString description);
        
        /**
         * Unsets the "Description" element
         */
        void unsetDescription();
        
        /**
         * Gets the "Sql-Mapping" element
         */
        org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping getSqlMapping();
        
        /**
         * True if has "Sql-Mapping" element
         */
        boolean isSetSqlMapping();
        
        /**
         * Sets the "Sql-Mapping" element
         */
        void setSqlMapping(org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping sqlMapping);
        
        /**
         * Appends and returns a new empty "Sql-Mapping" element
         */
        org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping addNewSqlMapping();
        
        /**
         * Unsets the "Sql-Mapping" element
         */
        void unsetSqlMapping();
        
        /**
         * An XML Sql-Mapping(@http://www.lindbergframework.org/schema).
         *
         * This is a complex type.
         */
        public interface SqlMapping extends org.apache.xmlbeans.XmlObject
        {
            public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
                org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SqlMapping.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s91172342D13B33D787C1EF15C0A6C401").resolveHandle("sqlmappinga628elemtype");
            
            /**
             * Gets a List of "Sql-Command" elements
             */
            java.util.List<org.lindbergframework.schema.TSqlCommand> getSqlCommandList();
            
            /**
             * Gets array of all "Sql-Command" elements
             * @deprecated
             */
            org.lindbergframework.schema.TSqlCommand[] getSqlCommandArray();
            
            /**
             * Gets ith "Sql-Command" element
             */
            org.lindbergframework.schema.TSqlCommand getSqlCommandArray(int i);
            
            /**
             * Returns number of "Sql-Command" element
             */
            int sizeOfSqlCommandArray();
            
            /**
             * Sets array of all "Sql-Command" element
             */
            void setSqlCommandArray(org.lindbergframework.schema.TSqlCommand[] sqlCommandArray);
            
            /**
             * Sets ith "Sql-Command" element
             */
            void setSqlCommandArray(int i, org.lindbergframework.schema.TSqlCommand sqlCommand);
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "Sql-Command" element
             */
            org.lindbergframework.schema.TSqlCommand insertNewSqlCommand(int i);
            
            /**
             * Appends and returns a new empty value (as xml) as the last "Sql-Command" element
             */
            org.lindbergframework.schema.TSqlCommand addNewSqlCommand();
            
            /**
             * Removes the ith "Sql-Command" element
             */
            void removeSqlCommand(int i);
            
            /**
             * A factory class with static methods for creating instances
             * of this type.
             */
            
            public static final class Factory
            {
                public static org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping newInstance() {
                  return (org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
                
                public static org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping newInstance(org.apache.xmlbeans.XmlOptions options) {
                  return (org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
                
                private Factory() { } // No instance of this class allowed
            }
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.lindbergframework.schema.LinpMappingDocument.LinpMapping newInstance() {
              return (org.lindbergframework.schema.LinpMappingDocument.LinpMapping) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.lindbergframework.schema.LinpMappingDocument.LinpMapping newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.lindbergframework.schema.LinpMappingDocument.LinpMapping) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.lindbergframework.schema.LinpMappingDocument newInstance() {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.lindbergframework.schema.LinpMappingDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.LinpMappingDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.LinpMappingDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.LinpMappingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
