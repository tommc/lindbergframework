/*
 * XML Type:  tdataSource
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.TdataSource
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema.impl;
/**
 * An XML tdataSource(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public class TdataSourceImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.TdataSource
{
    private static final long serialVersionUID = 1L;
    
    public TdataSourceImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROPERTY$0 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "property");
    private static final javax.xml.namespace.QName CLASS1$2 = 
        new javax.xml.namespace.QName("", "class");
    private static final javax.xml.namespace.QName DRIVER$4 = 
        new javax.xml.namespace.QName("", "driver");
    private static final javax.xml.namespace.QName DRIVERPROPERTYNAME$6 = 
        new javax.xml.namespace.QName("", "driverPropertyName");
    
    
    /**
     * Gets a List of "property" elements
     */
    public java.util.List<org.lindbergframework.schema.Tproperty> getPropertyList()
    {
        final class PropertyList extends java.util.AbstractList<org.lindbergframework.schema.Tproperty>
        {
            public org.lindbergframework.schema.Tproperty get(int i)
                { return TdataSourceImpl.this.getPropertyArray(i); }
            
            public org.lindbergframework.schema.Tproperty set(int i, org.lindbergframework.schema.Tproperty o)
            {
                org.lindbergframework.schema.Tproperty old = TdataSourceImpl.this.getPropertyArray(i);
                TdataSourceImpl.this.setPropertyArray(i, o);
                return old;
            }
            
            public void add(int i, org.lindbergframework.schema.Tproperty o)
                { TdataSourceImpl.this.insertNewProperty(i).set(o); }
            
            public org.lindbergframework.schema.Tproperty remove(int i)
            {
                org.lindbergframework.schema.Tproperty old = TdataSourceImpl.this.getPropertyArray(i);
                TdataSourceImpl.this.removeProperty(i);
                return old;
            }
            
            public int size()
                { return TdataSourceImpl.this.sizeOfPropertyArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new PropertyList();
        }
    }
    
    /**
     * Gets array of all "property" elements
     * @deprecated
     */
    public org.lindbergframework.schema.Tproperty[] getPropertyArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<org.lindbergframework.schema.Tproperty> targetList = new java.util.ArrayList<org.lindbergframework.schema.Tproperty>();
            get_store().find_all_element_users(PROPERTY$0, targetList);
            org.lindbergframework.schema.Tproperty[] result = new org.lindbergframework.schema.Tproperty[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "property" element
     */
    public org.lindbergframework.schema.Tproperty getPropertyArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.Tproperty target = null;
            target = (org.lindbergframework.schema.Tproperty)get_store().find_element_user(PROPERTY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "property" element
     */
    public int sizeOfPropertyArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROPERTY$0);
        }
    }
    
    /**
     * Sets array of all "property" element
     */
    public void setPropertyArray(org.lindbergframework.schema.Tproperty[] propertyArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(propertyArray, PROPERTY$0);
        }
    }
    
    /**
     * Sets ith "property" element
     */
    public void setPropertyArray(int i, org.lindbergframework.schema.Tproperty property)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.Tproperty target = null;
            target = (org.lindbergframework.schema.Tproperty)get_store().find_element_user(PROPERTY$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(property);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "property" element
     */
    public org.lindbergframework.schema.Tproperty insertNewProperty(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.Tproperty target = null;
            target = (org.lindbergframework.schema.Tproperty)get_store().insert_element_user(PROPERTY$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "property" element
     */
    public org.lindbergframework.schema.Tproperty addNewProperty()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.Tproperty target = null;
            target = (org.lindbergframework.schema.Tproperty)get_store().add_element_user(PROPERTY$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "property" element
     */
    public void removeProperty(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROPERTY$0, i);
        }
    }
    
    /**
     * Gets the "class" attribute
     */
    public java.lang.String getClass1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CLASS1$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "class" attribute
     */
    public org.apache.xmlbeans.XmlString xgetClass1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CLASS1$2);
            return target;
        }
    }
    
    /**
     * Sets the "class" attribute
     */
    public void setClass1(java.lang.String class1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CLASS1$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CLASS1$2);
            }
            target.setStringValue(class1);
        }
    }
    
    /**
     * Sets (as xml) the "class" attribute
     */
    public void xsetClass1(org.apache.xmlbeans.XmlString class1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CLASS1$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CLASS1$2);
            }
            target.set(class1);
        }
    }
    
    /**
     * Gets the "driver" attribute
     */
    public java.lang.String getDriver()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DRIVER$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "driver" attribute
     */
    public org.apache.xmlbeans.XmlString xgetDriver()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DRIVER$4);
            return target;
        }
    }
    
    /**
     * True if has "driver" attribute
     */
    public boolean isSetDriver()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DRIVER$4) != null;
        }
    }
    
    /**
     * Sets the "driver" attribute
     */
    public void setDriver(java.lang.String driver)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DRIVER$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DRIVER$4);
            }
            target.setStringValue(driver);
        }
    }
    
    /**
     * Sets (as xml) the "driver" attribute
     */
    public void xsetDriver(org.apache.xmlbeans.XmlString driver)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DRIVER$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(DRIVER$4);
            }
            target.set(driver);
        }
    }
    
    /**
     * Unsets the "driver" attribute
     */
    public void unsetDriver()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DRIVER$4);
        }
    }
    
    /**
     * Gets the "driverPropertyName" attribute
     */
    public java.lang.String getDriverPropertyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DRIVERPROPERTYNAME$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(DRIVERPROPERTYNAME$6);
            }
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "driverPropertyName" attribute
     */
    public org.apache.xmlbeans.XmlString xgetDriverPropertyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DRIVERPROPERTYNAME$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_default_attribute_value(DRIVERPROPERTYNAME$6);
            }
            return target;
        }
    }
    
    /**
     * True if has "driverPropertyName" attribute
     */
    public boolean isSetDriverPropertyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DRIVERPROPERTYNAME$6) != null;
        }
    }
    
    /**
     * Sets the "driverPropertyName" attribute
     */
    public void setDriverPropertyName(java.lang.String driverPropertyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DRIVERPROPERTYNAME$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DRIVERPROPERTYNAME$6);
            }
            target.setStringValue(driverPropertyName);
        }
    }
    
    /**
     * Sets (as xml) the "driverPropertyName" attribute
     */
    public void xsetDriverPropertyName(org.apache.xmlbeans.XmlString driverPropertyName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DRIVERPROPERTYNAME$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(DRIVERPROPERTYNAME$6);
            }
            target.set(driverPropertyName);
        }
    }
    
    /**
     * Unsets the "driverPropertyName" attribute
     */
    public void unsetDriverPropertyName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DRIVERPROPERTYNAME$6);
        }
    }
}
