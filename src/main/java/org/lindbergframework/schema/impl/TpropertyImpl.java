/*
 * XML Type:  tproperty
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.Tproperty
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema.impl;
/**
 * An XML tproperty(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public class TpropertyImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.Tproperty
{
    private static final long serialVersionUID = 1L;
    
    public TpropertyImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LIST$0 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "list");
    private static final javax.xml.namespace.QName ARRAY$2 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "array");
    private static final javax.xml.namespace.QName NAME$4 = 
        new javax.xml.namespace.QName("", "name");
    private static final javax.xml.namespace.QName VALUE$6 = 
        new javax.xml.namespace.QName("", "value");
    private static final javax.xml.namespace.QName CONSTRUCTORARG$8 = 
        new javax.xml.namespace.QName("", "constructor-arg");
    
    
    /**
     * Gets the "list" element
     */
    public java.lang.String getList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LIST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "list" element
     */
    public org.lindbergframework.schema.Tproperty.List xgetList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.Tproperty.List target = null;
            target = (org.lindbergframework.schema.Tproperty.List)get_store().find_element_user(LIST$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "list" element
     */
    public boolean isSetList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LIST$0) != 0;
        }
    }
    
    /**
     * Sets the "list" element
     */
    public void setList(java.lang.String list)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LIST$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LIST$0);
            }
            target.setStringValue(list);
        }
    }
    
    /**
     * Sets (as xml) the "list" element
     */
    public void xsetList(org.lindbergframework.schema.Tproperty.List list)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.Tproperty.List target = null;
            target = (org.lindbergframework.schema.Tproperty.List)get_store().find_element_user(LIST$0, 0);
            if (target == null)
            {
                target = (org.lindbergframework.schema.Tproperty.List)get_store().add_element_user(LIST$0);
            }
            target.set(list);
        }
    }
    
    /**
     * Unsets the "list" element
     */
    public void unsetList()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LIST$0, 0);
        }
    }
    
    /**
     * Gets the "array" element
     */
    public java.lang.String getArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARRAY$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "array" element
     */
    public org.lindbergframework.schema.Tproperty.Array xgetArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.Tproperty.Array target = null;
            target = (org.lindbergframework.schema.Tproperty.Array)get_store().find_element_user(ARRAY$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "array" element
     */
    public boolean isSetArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARRAY$2) != 0;
        }
    }
    
    /**
     * Sets the "array" element
     */
    public void setArray(java.lang.String array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARRAY$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ARRAY$2);
            }
            target.setStringValue(array);
        }
    }
    
    /**
     * Sets (as xml) the "array" element
     */
    public void xsetArray(org.lindbergframework.schema.Tproperty.Array array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.Tproperty.Array target = null;
            target = (org.lindbergframework.schema.Tproperty.Array)get_store().find_element_user(ARRAY$2, 0);
            if (target == null)
            {
                target = (org.lindbergframework.schema.Tproperty.Array)get_store().add_element_user(ARRAY$2);
            }
            target.set(array);
        }
    }
    
    /**
     * Unsets the "array" element
     */
    public void unsetArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARRAY$2, 0);
        }
    }
    
    /**
     * Gets the "name" attribute
     */
    public java.lang.String getName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "name" attribute
     */
    public org.apache.xmlbeans.XmlString xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$4);
            return target;
        }
    }
    
    /**
     * True if has "name" attribute
     */
    public boolean isSetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(NAME$4) != null;
        }
    }
    
    /**
     * Sets the "name" attribute
     */
    public void setName(java.lang.String name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$4);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" attribute
     */
    public void xsetName(org.apache.xmlbeans.XmlString name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$4);
            }
            target.set(name);
        }
    }
    
    /**
     * Unsets the "name" attribute
     */
    public void unsetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(NAME$4);
        }
    }
    
    /**
     * Gets the "value" attribute
     */
    public java.lang.String getValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "value" attribute
     */
    public org.apache.xmlbeans.XmlString xgetValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$6);
            return target;
        }
    }
    
    /**
     * True if has "value" attribute
     */
    public boolean isSetValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(VALUE$6) != null;
        }
    }
    
    /**
     * Sets the "value" attribute
     */
    public void setValue(java.lang.String value)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALUE$6);
            }
            target.setStringValue(value);
        }
    }
    
    /**
     * Sets (as xml) the "value" attribute
     */
    public void xsetValue(org.apache.xmlbeans.XmlString value)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VALUE$6);
            }
            target.set(value);
        }
    }
    
    /**
     * Unsets the "value" attribute
     */
    public void unsetValue()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(VALUE$6);
        }
    }
    
    /**
     * Gets the "constructor-arg" attribute
     */
    public boolean getConstructorArg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONSTRUCTORARG$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(CONSTRUCTORARG$8);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "constructor-arg" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetConstructorArg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(CONSTRUCTORARG$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(CONSTRUCTORARG$8);
            }
            return target;
        }
    }
    
    /**
     * True if has "constructor-arg" attribute
     */
    public boolean isSetConstructorArg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(CONSTRUCTORARG$8) != null;
        }
    }
    
    /**
     * Sets the "constructor-arg" attribute
     */
    public void setConstructorArg(boolean constructorArg)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CONSTRUCTORARG$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CONSTRUCTORARG$8);
            }
            target.setBooleanValue(constructorArg);
        }
    }
    
    /**
     * Sets (as xml) the "constructor-arg" attribute
     */
    public void xsetConstructorArg(org.apache.xmlbeans.XmlBoolean constructorArg)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(CONSTRUCTORARG$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(CONSTRUCTORARG$8);
            }
            target.set(constructorArg);
        }
    }
    
    /**
     * Unsets the "constructor-arg" attribute
     */
    public void unsetConstructorArg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(CONSTRUCTORARG$8);
        }
    }
    /**
     * An XML list(@http://www.lindbergframework.org/schema).
     *
     * This is an atomic type that is a restriction of org.lindbergframework.schema.Tproperty$List.
     */
    public static class ListImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements org.lindbergframework.schema.Tproperty.List
    {
        private static final long serialVersionUID = 1L;
        
        public ListImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ListImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
    /**
     * An XML array(@http://www.lindbergframework.org/schema).
     *
     * This is an atomic type that is a restriction of org.lindbergframework.schema.Tproperty$Array.
     */
    public static class ArrayImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements org.lindbergframework.schema.Tproperty.Array
    {
        private static final long serialVersionUID = 1L;
        
        public ArrayImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ArrayImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
