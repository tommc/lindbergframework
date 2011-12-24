/*
 * XML Type:  tFunctionResultCursor
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.TFunctionResultCursor
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema.impl;
/**
 * An XML tFunctionResultCursor(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public class TFunctionResultCursorImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.TFunctionResultCursor
{
    private static final long serialVersionUID = 1L;
    
    public TFunctionResultCursorImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POPULATIONCLASS$0 = 
        new javax.xml.namespace.QName("", "population-class");
    
    
    /**
     * Gets the "population-class" attribute
     */
    public java.lang.String getPopulationClass()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(POPULATIONCLASS$0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "population-class" attribute
     */
    public org.apache.xmlbeans.XmlString xgetPopulationClass()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(POPULATIONCLASS$0);
            return target;
        }
    }
    
    /**
     * Sets the "population-class" attribute
     */
    public void setPopulationClass(java.lang.String populationClass)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(POPULATIONCLASS$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(POPULATIONCLASS$0);
            }
            target.setStringValue(populationClass);
        }
    }
    
    /**
     * Sets (as xml) the "population-class" attribute
     */
    public void xsetPopulationClass(org.apache.xmlbeans.XmlString populationClass)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(POPULATIONCLASS$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(POPULATIONCLASS$0);
            }
            target.set(populationClass);
        }
    }
}
