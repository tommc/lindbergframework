/*
 * XML Type:  tSql-Command
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.TSqlCommand
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema.impl;
/**
 * An XML tSql-Command(@http://www.lindbergframework.org/schema).
 *
 * This is a complex type.
 */
public class TSqlCommandImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.TSqlCommand
{
    private static final long serialVersionUID = 1L;
    
    public TSqlCommandImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SQLSTATEMENT$0 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "Sql-Statement");
    private static final javax.xml.namespace.QName PROCEDURE$2 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "Procedure");
    private static final javax.xml.namespace.QName FUNCTION$4 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "Function");
    private static final javax.xml.namespace.QName ID$6 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets the "Sql-Statement" element
     */
    public java.lang.String getSqlStatement()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SQLSTATEMENT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Sql-Statement" element
     */
    public org.apache.xmlbeans.XmlString xgetSqlStatement()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SQLSTATEMENT$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "Sql-Statement" element
     */
    public boolean isSetSqlStatement()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SQLSTATEMENT$0) != 0;
        }
    }
    
    /**
     * Sets the "Sql-Statement" element
     */
    public void setSqlStatement(java.lang.String sqlStatement)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SQLSTATEMENT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SQLSTATEMENT$0);
            }
            target.setStringValue(sqlStatement);
        }
    }
    
    /**
     * Sets (as xml) the "Sql-Statement" element
     */
    public void xsetSqlStatement(org.apache.xmlbeans.XmlString sqlStatement)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SQLSTATEMENT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SQLSTATEMENT$0);
            }
            target.set(sqlStatement);
        }
    }
    
    /**
     * Unsets the "Sql-Statement" element
     */
    public void unsetSqlStatement()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SQLSTATEMENT$0, 0);
        }
    }
    
    /**
     * Gets the "Procedure" element
     */
    public org.lindbergframework.schema.TProcedure getProcedure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TProcedure target = null;
            target = (org.lindbergframework.schema.TProcedure)get_store().find_element_user(PROCEDURE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Procedure" element
     */
    public boolean isSetProcedure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PROCEDURE$2) != 0;
        }
    }
    
    /**
     * Sets the "Procedure" element
     */
    public void setProcedure(org.lindbergframework.schema.TProcedure procedure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TProcedure target = null;
            target = (org.lindbergframework.schema.TProcedure)get_store().find_element_user(PROCEDURE$2, 0);
            if (target == null)
            {
                target = (org.lindbergframework.schema.TProcedure)get_store().add_element_user(PROCEDURE$2);
            }
            target.set(procedure);
        }
    }
    
    /**
     * Appends and returns a new empty "Procedure" element
     */
    public org.lindbergframework.schema.TProcedure addNewProcedure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TProcedure target = null;
            target = (org.lindbergframework.schema.TProcedure)get_store().add_element_user(PROCEDURE$2);
            return target;
        }
    }
    
    /**
     * Unsets the "Procedure" element
     */
    public void unsetProcedure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PROCEDURE$2, 0);
        }
    }
    
    /**
     * Gets the "Function" element
     */
    public org.lindbergframework.schema.TFunction getFunction()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TFunction target = null;
            target = (org.lindbergframework.schema.TFunction)get_store().find_element_user(FUNCTION$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Function" element
     */
    public boolean isSetFunction()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FUNCTION$4) != 0;
        }
    }
    
    /**
     * Sets the "Function" element
     */
    public void setFunction(org.lindbergframework.schema.TFunction function)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TFunction target = null;
            target = (org.lindbergframework.schema.TFunction)get_store().find_element_user(FUNCTION$4, 0);
            if (target == null)
            {
                target = (org.lindbergframework.schema.TFunction)get_store().add_element_user(FUNCTION$4);
            }
            target.set(function);
        }
    }
    
    /**
     * Appends and returns a new empty "Function" element
     */
    public org.lindbergframework.schema.TFunction addNewFunction()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.TFunction target = null;
            target = (org.lindbergframework.schema.TFunction)get_store().add_element_user(FUNCTION$4);
            return target;
        }
    }
    
    /**
     * Unsets the "Function" element
     */
    public void unsetFunction()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FUNCTION$4, 0);
        }
    }
    
    /**
     * Gets the "id" attribute
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" attribute
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$6);
            return target;
        }
    }
    
    /**
     * Sets the "id" attribute
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$6);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" attribute
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$6);
            }
            target.set(id);
        }
    }
}
