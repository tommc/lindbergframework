/*
 * XML Type:  tProcedure
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.TProcedure
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema;


/**
 * An XML tProcedure(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public interface TProcedure extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TProcedure.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s91172342D13B33D787C1EF15C0A6C401").resolveHandle("tprocedure8078type");
    
    /**
     * Gets a List of "OutCursor" elements
     */
    java.util.List<org.lindbergframework.schema.TOutCursor> getOutCursorList();
    
    /**
     * Gets array of all "OutCursor" elements
     * @deprecated
     */
    org.lindbergframework.schema.TOutCursor[] getOutCursorArray();
    
    /**
     * Gets ith "OutCursor" element
     */
    org.lindbergframework.schema.TOutCursor getOutCursorArray(int i);
    
    /**
     * Returns number of "OutCursor" element
     */
    int sizeOfOutCursorArray();
    
    /**
     * Sets array of all "OutCursor" element
     */
    void setOutCursorArray(org.lindbergframework.schema.TOutCursor[] outCursorArray);
    
    /**
     * Sets ith "OutCursor" element
     */
    void setOutCursorArray(int i, org.lindbergframework.schema.TOutCursor outCursor);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "OutCursor" element
     */
    org.lindbergframework.schema.TOutCursor insertNewOutCursor(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OutCursor" element
     */
    org.lindbergframework.schema.TOutCursor addNewOutCursor();
    
    /**
     * Removes the ith "OutCursor" element
     */
    void removeOutCursor(int i);
    
    /**
     * Gets the "name" attribute
     */
    java.lang.String getName();
    
    /**
     * Gets (as xml) the "name" attribute
     */
    org.apache.xmlbeans.XmlString xgetName();
    
    /**
     * Sets the "name" attribute
     */
    void setName(java.lang.String name);
    
    /**
     * Sets (as xml) the "name" attribute
     */
    void xsetName(org.apache.xmlbeans.XmlString name);
    
    /**
     * Gets the "schema" attribute
     */
    java.lang.String getSchema();
    
    /**
     * Gets (as xml) the "schema" attribute
     */
    org.apache.xmlbeans.XmlString xgetSchema();
    
    /**
     * True if has "schema" attribute
     */
    boolean isSetSchema();
    
    /**
     * Sets the "schema" attribute
     */
    void setSchema(java.lang.String schema);
    
    /**
     * Sets (as xml) the "schema" attribute
     */
    void xsetSchema(org.apache.xmlbeans.XmlString schema);
    
    /**
     * Unsets the "schema" attribute
     */
    void unsetSchema();
    
    /**
     * Gets the "package" attribute
     */
    java.lang.String getPackage();
    
    /**
     * Gets (as xml) the "package" attribute
     */
    org.apache.xmlbeans.XmlString xgetPackage();
    
    /**
     * True if has "package" attribute
     */
    boolean isSetPackage();
    
    /**
     * Sets the "package" attribute
     */
    void setPackage(java.lang.String xpackage);
    
    /**
     * Sets (as xml) the "package" attribute
     */
    void xsetPackage(org.apache.xmlbeans.XmlString xpackage);
    
    /**
     * Unsets the "package" attribute
     */
    void unsetPackage();
    
    /**
     * Gets the "catalog" attribute
     */
    java.lang.String getCatalog();
    
    /**
     * Gets (as xml) the "catalog" attribute
     */
    org.apache.xmlbeans.XmlString xgetCatalog();
    
    /**
     * True if has "catalog" attribute
     */
    boolean isSetCatalog();
    
    /**
     * Sets the "catalog" attribute
     */
    void setCatalog(java.lang.String catalog);
    
    /**
     * Sets (as xml) the "catalog" attribute
     */
    void xsetCatalog(org.apache.xmlbeans.XmlString catalog);
    
    /**
     * Unsets the "catalog" attribute
     */
    void unsetCatalog();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.lindbergframework.schema.TProcedure newInstance() {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.lindbergframework.schema.TProcedure newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.lindbergframework.schema.TProcedure parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.lindbergframework.schema.TProcedure parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.lindbergframework.schema.TProcedure parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.lindbergframework.schema.TProcedure parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.lindbergframework.schema.TProcedure parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.lindbergframework.schema.TProcedure parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.lindbergframework.schema.TProcedure parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.lindbergframework.schema.TProcedure parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.lindbergframework.schema.TProcedure parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.lindbergframework.schema.TProcedure parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.lindbergframework.schema.TProcedure parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.lindbergframework.schema.TProcedure parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.lindbergframework.schema.TProcedure parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.lindbergframework.schema.TProcedure parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.TProcedure parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.TProcedure parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.TProcedure) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
