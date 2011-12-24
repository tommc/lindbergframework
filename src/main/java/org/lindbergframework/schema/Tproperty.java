/*
 * XML Type:  tproperty
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.Tproperty
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema;


/**
 * An XML tproperty(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public interface Tproperty extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Tproperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("tproperty8e90type");
    
    /**
     * Gets the "list" element
     */
    java.lang.String getList();
    
    /**
     * Gets (as xml) the "list" element
     */
    org.lindbergframework.schema.Tproperty.List xgetList();
    
    /**
     * True if has "list" element
     */
    boolean isSetList();
    
    /**
     * Sets the "list" element
     */
    void setList(java.lang.String list);
    
    /**
     * Sets (as xml) the "list" element
     */
    void xsetList(org.lindbergframework.schema.Tproperty.List list);
    
    /**
     * Unsets the "list" element
     */
    void unsetList();
    
    /**
     * Gets the "array" element
     */
    java.lang.String getArray();
    
    /**
     * Gets (as xml) the "array" element
     */
    org.lindbergframework.schema.Tproperty.Array xgetArray();
    
    /**
     * True if has "array" element
     */
    boolean isSetArray();
    
    /**
     * Sets the "array" element
     */
    void setArray(java.lang.String array);
    
    /**
     * Sets (as xml) the "array" element
     */
    void xsetArray(org.lindbergframework.schema.Tproperty.Array array);
    
    /**
     * Unsets the "array" element
     */
    void unsetArray();
    
    /**
     * Gets the "name" attribute
     */
    java.lang.String getName();
    
    /**
     * Gets (as xml) the "name" attribute
     */
    org.apache.xmlbeans.XmlString xgetName();
    
    /**
     * True if has "name" attribute
     */
    boolean isSetName();
    
    /**
     * Sets the "name" attribute
     */
    void setName(java.lang.String name);
    
    /**
     * Sets (as xml) the "name" attribute
     */
    void xsetName(org.apache.xmlbeans.XmlString name);
    
    /**
     * Unsets the "name" attribute
     */
    void unsetName();
    
    /**
     * Gets the "value" attribute
     */
    java.lang.String getValue();
    
    /**
     * Gets (as xml) the "value" attribute
     */
    org.apache.xmlbeans.XmlString xgetValue();
    
    /**
     * True if has "value" attribute
     */
    boolean isSetValue();
    
    /**
     * Sets the "value" attribute
     */
    void setValue(java.lang.String value);
    
    /**
     * Sets (as xml) the "value" attribute
     */
    void xsetValue(org.apache.xmlbeans.XmlString value);
    
    /**
     * Unsets the "value" attribute
     */
    void unsetValue();
    
    /**
     * Gets the "constructor-arg" attribute
     */
    boolean getConstructorArg();
    
    /**
     * Gets (as xml) the "constructor-arg" attribute
     */
    org.apache.xmlbeans.XmlBoolean xgetConstructorArg();
    
    /**
     * True if has "constructor-arg" attribute
     */
    boolean isSetConstructorArg();
    
    /**
     * Sets the "constructor-arg" attribute
     */
    void setConstructorArg(boolean constructorArg);
    
    /**
     * Sets (as xml) the "constructor-arg" attribute
     */
    void xsetConstructorArg(org.apache.xmlbeans.XmlBoolean constructorArg);
    
    /**
     * Unsets the "constructor-arg" attribute
     */
    void unsetConstructorArg();
    
    /**
     * An XML list(@http://www.lindbergframework.org/schema).
     *
     * This is an atomic type that is a restriction of org.lindbergframework.schema.Tproperty$List.
     */
    public interface List extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(List.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("listf2caelemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.lindbergframework.schema.Tproperty.List newValue(java.lang.Object obj) {
              return (org.lindbergframework.schema.Tproperty.List) type.newValue( obj ); }
            
            public static org.lindbergframework.schema.Tproperty.List newInstance() {
              return (org.lindbergframework.schema.Tproperty.List) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.lindbergframework.schema.Tproperty.List newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.lindbergframework.schema.Tproperty.List) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * An XML array(@http://www.lindbergframework.org/schema).
     *
     * This is an atomic type that is a restriction of org.lindbergframework.schema.Tproperty$Array.
     */
    public interface Array extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Array.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("array2ed5elemtype");
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.lindbergframework.schema.Tproperty.Array newValue(java.lang.Object obj) {
              return (org.lindbergframework.schema.Tproperty.Array) type.newValue( obj ); }
            
            public static org.lindbergframework.schema.Tproperty.Array newInstance() {
              return (org.lindbergframework.schema.Tproperty.Array) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.lindbergframework.schema.Tproperty.Array newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.lindbergframework.schema.Tproperty.Array) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.lindbergframework.schema.Tproperty newInstance() {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.lindbergframework.schema.Tproperty newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.lindbergframework.schema.Tproperty parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.lindbergframework.schema.Tproperty parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.lindbergframework.schema.Tproperty parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.lindbergframework.schema.Tproperty parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.lindbergframework.schema.Tproperty parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.lindbergframework.schema.Tproperty parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.lindbergframework.schema.Tproperty parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.lindbergframework.schema.Tproperty parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.lindbergframework.schema.Tproperty parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.lindbergframework.schema.Tproperty parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.lindbergframework.schema.Tproperty parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.lindbergframework.schema.Tproperty parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.lindbergframework.schema.Tproperty parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.lindbergframework.schema.Tproperty parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.Tproperty parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.Tproperty parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.Tproperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
