/*
 * XML Type:  tFunction
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.TFunction
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema.impl;
/**
 * An XML tFunction(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public class TFunctionImpl extends org.lindbergframework.schema.impl.TProcedureImpl implements org.lindbergframework.schema.TFunction
{
    private static final long serialVersionUID = 1L;
    
    public TFunctionImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESULTCURSOR$0 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "ResultCursor");
    private static final javax.xml.namespace.QName RESULTNAME$2 = 
        new javax.xml.namespace.QName("", "resultName");
    
    
    /**
     * Gets the "ResultCursor" element
     */
    public org.lindbergframework.schema.TFunctionResultCursor getResultCursor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TFunctionResultCursor target = null;
            target = (org.lindbergframework.schema.TFunctionResultCursor)get_store().find_element_user(RESULTCURSOR$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ResultCursor" element
     */
    public boolean isSetResultCursor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESULTCURSOR$0) != 0;
        }
    }
    
    /**
     * Sets the "ResultCursor" element
     */
    public void setResultCursor(org.lindbergframework.schema.TFunctionResultCursor resultCursor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TFunctionResultCursor target = null;
            target = (org.lindbergframework.schema.TFunctionResultCursor)get_store().find_element_user(RESULTCURSOR$0, 0);
            if (target == null)
            {
                target = (org.lindbergframework.schema.TFunctionResultCursor)get_store().add_element_user(RESULTCURSOR$0);
            }
            target.set(resultCursor);
        }
    }
    
    /**
     * Appends and returns a new empty "ResultCursor" element
     */
    public org.lindbergframework.schema.TFunctionResultCursor addNewResultCursor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TFunctionResultCursor target = null;
            target = (org.lindbergframework.schema.TFunctionResultCursor)get_store().add_element_user(RESULTCURSOR$0);
            return target;
        }
    }
    
    /**
     * Unsets the "ResultCursor" element
     */
    public void unsetResultCursor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESULTCURSOR$0, 0);
        }
    }
    
    /**
     * Gets the "resultName" attribute
     */
    public java.lang.String getResultName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RESULTNAME$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "resultName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetResultName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RESULTNAME$2);
            return target;
        }
    }
    
    /**
     * True if has "resultName" attribute
     */
    public boolean isSetResultName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(RESULTNAME$2) != null;
        }
    }
    
    /**
     * Sets the "resultName" attribute
     */
    public void setResultName(java.lang.String resultName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(RESULTNAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(RESULTNAME$2);
            }
            target.setStringValue(resultName);
        }
    }
    
    /**
     * Sets (as xml) the "resultName" attribute
     */
    public void xsetResultName(org.apache.xmlbeans.XmlString resultName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(RESULTNAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(RESULTNAME$2);
            }
            target.set(resultName);
        }
    }
    
    /**
     * Unsets the "resultName" attribute
     */
    public void unsetResultName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(RESULTNAME$2);
        }
    }
}
