/*
 * XML Type:  tProcedure
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.TProcedure
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema.impl;
/**
 * An XML tProcedure(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public class TProcedureImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.TProcedure
{
    private static final long serialVersionUID = 1L;
    
    public TProcedureImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUTCURSOR$0 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "OutCursor");
    private static final javax.xml.namespace.QName NAME$2 = 
        new javax.xml.namespace.QName("", "name");
    private static final javax.xml.namespace.QName SCHEMA$4 = 
        new javax.xml.namespace.QName("", "schema");
    private static final javax.xml.namespace.QName PACKAGE$6 = 
        new javax.xml.namespace.QName("", "package");
    private static final javax.xml.namespace.QName CATALOG$8 = 
        new javax.xml.namespace.QName("", "catalog");
    
    
    /**
     * Gets a List of "OutCursor" elements
     */
    public java.util.List<org.lindbergframework.schema.TOutCursor> getOutCursorList()
    {
        final class OutCursorList extends java.util.AbstractList<org.lindbergframework.schema.TOutCursor>
        {
            public org.lindbergframework.schema.TOutCursor get(int i)
                { return TProcedureImpl.this.getOutCursorArray(i); }
            
            public org.lindbergframework.schema.TOutCursor set(int i, org.lindbergframework.schema.TOutCursor o)
            {
                org.lindbergframework.schema.TOutCursor old = TProcedureImpl.this.getOutCursorArray(i);
                TProcedureImpl.this.setOutCursorArray(i, o);
                return old;
            }
            
            public void add(int i, org.lindbergframework.schema.TOutCursor o)
                { TProcedureImpl.this.insertNewOutCursor(i).set(o); }
            
            public org.lindbergframework.schema.TOutCursor remove(int i)
            {
                org.lindbergframework.schema.TOutCursor old = TProcedureImpl.this.getOutCursorArray(i);
                TProcedureImpl.this.removeOutCursor(i);
                return old;
            }
            
            public int size()
                { return TProcedureImpl.this.sizeOfOutCursorArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new OutCursorList();
        }
    }
    
    /**
     * Gets array of all "OutCursor" elements
     * @deprecated
     */
    public org.lindbergframework.schema.TOutCursor[] getOutCursorArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<org.lindbergframework.schema.TOutCursor> targetList = new java.util.ArrayList<org.lindbergframework.schema.TOutCursor>();
            get_store().find_all_element_users(OUTCURSOR$0, targetList);
            org.lindbergframework.schema.TOutCursor[] result = new org.lindbergframework.schema.TOutCursor[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "OutCursor" element
     */
    public org.lindbergframework.schema.TOutCursor getOutCursorArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TOutCursor target = null;
            target = (org.lindbergframework.schema.TOutCursor)get_store().find_element_user(OUTCURSOR$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "OutCursor" element
     */
    public int sizeOfOutCursorArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OUTCURSOR$0);
        }
    }
    
    /**
     * Sets array of all "OutCursor" element
     */
    public void setOutCursorArray(org.lindbergframework.schema.TOutCursor[] outCursorArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(outCursorArray, OUTCURSOR$0);
        }
    }
    
    /**
     * Sets ith "OutCursor" element
     */
    public void setOutCursorArray(int i, org.lindbergframework.schema.TOutCursor outCursor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TOutCursor target = null;
            target = (org.lindbergframework.schema.TOutCursor)get_store().find_element_user(OUTCURSOR$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(outCursor);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "OutCursor" element
     */
    public org.lindbergframework.schema.TOutCursor insertNewOutCursor(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TOutCursor target = null;
            target = (org.lindbergframework.schema.TOutCursor)get_store().insert_element_user(OUTCURSOR$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "OutCursor" element
     */
    public org.lindbergframework.schema.TOutCursor addNewOutCursor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TOutCursor target = null;
            target = (org.lindbergframework.schema.TOutCursor)get_store().add_element_user(OUTCURSOR$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "OutCursor" element
     */
    public void removeOutCursor(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OUTCURSOR$0, i);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$2);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$2);
            }
            target.set(name);
        }
    }
    
    /**
     * Gets the "schema" attribute
     */
    public java.lang.String getSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SCHEMA$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "schema" attribute
     */
    public org.apache.xmlbeans.XmlString xgetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SCHEMA$4);
            return target;
        }
    }
    
    /**
     * True if has "schema" attribute
     */
    public boolean isSetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(SCHEMA$4) != null;
        }
    }
    
    /**
     * Sets the "schema" attribute
     */
    public void setSchema(java.lang.String schema)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SCHEMA$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SCHEMA$4);
            }
            target.setStringValue(schema);
        }
    }
    
    /**
     * Sets (as xml) the "schema" attribute
     */
    public void xsetSchema(org.apache.xmlbeans.XmlString schema)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SCHEMA$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SCHEMA$4);
            }
            target.set(schema);
        }
    }
    
    /**
     * Unsets the "schema" attribute
     */
    public void unsetSchema()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(SCHEMA$4);
        }
    }
    
    /**
     * Gets the "package" attribute
     */
    public java.lang.String getPackage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PACKAGE$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "package" attribute
     */
    public org.apache.xmlbeans.XmlString xgetPackage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PACKAGE$6);
            return target;
        }
    }
    
    /**
     * True if has "package" attribute
     */
    public boolean isSetPackage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PACKAGE$6) != null;
        }
    }
    
    /**
     * Sets the "package" attribute
     */
    public void setPackage(java.lang.String xpackage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PACKAGE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PACKAGE$6);
            }
            target.setStringValue(xpackage);
        }
    }
    
    /**
     * Sets (as xml) the "package" attribute
     */
    public void xsetPackage(org.apache.xmlbeans.XmlString xpackage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PACKAGE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PACKAGE$6);
            }
            target.set(xpackage);
        }
    }
    
    /**
     * Unsets the "package" attribute
     */
    public void unsetPackage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PACKAGE$6);
        }
    }
    
    /**
     * Gets the "catalog" attribute
     */
    public java.lang.String getCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CATALOG$8);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "catalog" attribute
     */
    public org.apache.xmlbeans.XmlString xgetCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CATALOG$8);
            return target;
        }
    }
    
    /**
     * True if has "catalog" attribute
     */
    public boolean isSetCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(CATALOG$8) != null;
        }
    }
    
    /**
     * Sets the "catalog" attribute
     */
    public void setCatalog(java.lang.String catalog)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CATALOG$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CATALOG$8);
            }
            target.setStringValue(catalog);
        }
    }
    
    /**
     * Sets (as xml) the "catalog" attribute
     */
    public void xsetCatalog(org.apache.xmlbeans.XmlString catalog)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CATALOG$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CATALOG$8);
            }
            target.set(catalog);
        }
    }
    
    /**
     * Unsets the "catalog" attribute
     */
    public void unsetCatalog()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(CATALOG$8);
        }
    }
}
