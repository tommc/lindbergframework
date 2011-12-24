/*
 * XML Type:  tconfig-property
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.TconfigProperty
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema;


/**
 * An XML tconfig-property(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public interface TconfigProperty extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TconfigProperty.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sC9B8946CDAF0E6FD759940423F673B42").resolveHandle("tconfigproperty7905type");
    
    /**
     * Gets a List of "property" elements
     */
    java.util.List<org.lindbergframework.schema.Tproperty> getPropertyList();
    
    /**
     * Gets array of all "property" elements
     * @deprecated
     */
    org.lindbergframework.schema.Tproperty[] getPropertyArray();
    
    /**
     * Gets ith "property" element
     */
    org.lindbergframework.schema.Tproperty getPropertyArray(int i);
    
    /**
     * Returns number of "property" element
     */
    int sizeOfPropertyArray();
    
    /**
     * Sets array of all "property" element
     */
    void setPropertyArray(org.lindbergframework.schema.Tproperty[] propertyArray);
    
    /**
     * Sets ith "property" element
     */
    void setPropertyArray(int i, org.lindbergframework.schema.Tproperty property);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "property" element
     */
    org.lindbergframework.schema.Tproperty insertNewProperty(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "property" element
     */
    org.lindbergframework.schema.Tproperty addNewProperty();
    
    /**
     * Removes the ith "property" element
     */
    void removeProperty(int i);
    
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
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.lindbergframework.schema.TconfigProperty newInstance() {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.lindbergframework.schema.TconfigProperty newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.lindbergframework.schema.TconfigProperty parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.lindbergframework.schema.TconfigProperty parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.lindbergframework.schema.TconfigProperty parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.TconfigProperty parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.lindbergframework.schema.TconfigProperty parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.lindbergframework.schema.TconfigProperty) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
