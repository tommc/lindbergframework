/*
 * An XML document type.
 * Localname: Linp-Mapping
 * Namespace: http://www.lindbergframework.org/schema
 * Java type: org.lindbergframework.schema.LinpMappingDocument
 *
 * Automatically generated - do not modify.
 */
package org.lindbergframework.schema.impl;
/**
 * A document containing one Linp-Mapping(@http://www.lindbergframework.org/schema) element.
 *
 * This is a complex type.
 */
public class LinpMappingDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.LinpMappingDocument
{
    private static final long serialVersionUID = 1L;
    
    public LinpMappingDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LINPMAPPING$0 = 
        new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "Linp-Mapping");
    
    
    /**
     * Gets the "Linp-Mapping" element
     */
    public org.lindbergframework.schema.LinpMappingDocument.LinpMapping getLinpMapping()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.LinpMappingDocument.LinpMapping target = null;
            target = (org.lindbergframework.schema.LinpMappingDocument.LinpMapping)get_store().find_element_user(LINPMAPPING$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Linp-Mapping" element
     */
    public void setLinpMapping(org.lindbergframework.schema.LinpMappingDocument.LinpMapping linpMapping)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.LinpMappingDocument.LinpMapping target = null;
            target = (org.lindbergframework.schema.LinpMappingDocument.LinpMapping)get_store().find_element_user(LINPMAPPING$0, 0);
            if (target == null)
            {
                target = (org.lindbergframework.schema.LinpMappingDocument.LinpMapping)get_store().add_element_user(LINPMAPPING$0);
            }
            target.set(linpMapping);
        }
    }
    
    /**
     * Appends and returns a new empty "Linp-Mapping" element
     */
    public org.lindbergframework.schema.LinpMappingDocument.LinpMapping addNewLinpMapping()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.lindbergframework.schema.LinpMappingDocument.LinpMapping target = null;
            target = (org.lindbergframework.schema.LinpMappingDocument.LinpMapping)get_store().add_element_user(LINPMAPPING$0);
            return target;
        }
    }
    /**
     * An XML Linp-Mapping(@http://www.lindbergframework.org/schema).
     *
     * This is a complex type.
     */
    public static class LinpMappingImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.LinpMappingDocument.LinpMapping
    {
        private static final long serialVersionUID = 1L;
        
        public LinpMappingImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DESCRIPTION$0 = 
            new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "Description");
        private static final javax.xml.namespace.QName SQLMAPPING$2 = 
            new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "Sql-Mapping");
        
        
        /**
         * Gets the "Description" element
         */
        public java.lang.String getDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Description" element
         */
        public org.apache.xmlbeans.XmlString xgetDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$0, 0);
                return target;
            }
        }
        
        /**
         * True if has "Description" element
         */
        public boolean isSetDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DESCRIPTION$0) != 0;
            }
        }
        
        /**
         * Sets the "Description" element
         */
        public void setDescription(java.lang.String description)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$0);
                }
                target.setStringValue(description);
            }
        }
        
        /**
         * Sets (as xml) the "Description" element
         */
        public void xsetDescription(org.apache.xmlbeans.XmlString description)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$0);
                }
                target.set(description);
            }
        }
        
        /**
         * Unsets the "Description" element
         */
        public void unsetDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DESCRIPTION$0, 0);
            }
        }
        
        /**
         * Gets the "Sql-Mapping" element
         */
        public org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping getSqlMapping()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping target = null;
                target = (org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping)get_store().find_element_user(SQLMAPPING$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "Sql-Mapping" element
         */
        public boolean isSetSqlMapping()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SQLMAPPING$2) != 0;
            }
        }
        
        /**
         * Sets the "Sql-Mapping" element
         */
        public void setSqlMapping(org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping sqlMapping)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping target = null;
                target = (org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping)get_store().find_element_user(SQLMAPPING$2, 0);
                if (target == null)
                {
                    target = (org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping)get_store().add_element_user(SQLMAPPING$2);
                }
                target.set(sqlMapping);
            }
        }
        
        /**
         * Appends and returns a new empty "Sql-Mapping" element
         */
        public org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping addNewSqlMapping()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping target = null;
                target = (org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping)get_store().add_element_user(SQLMAPPING$2);
                return target;
            }
        }
        
        /**
         * Unsets the "Sql-Mapping" element
         */
        public void unsetSqlMapping()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SQLMAPPING$2, 0);
            }
        }
        /**
         * An XML Sql-Mapping(@http://www.lindbergframework.org/schema).
         *
         * This is a complex type.
         */
        public static class SqlMappingImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.lindbergframework.schema.LinpMappingDocument.LinpMapping.SqlMapping
        {
            private static final long serialVersionUID = 1L;
            
            public SqlMappingImpl(org.apache.xmlbeans.SchemaType sType)
            {
                super(sType);
            }
            
            private static final javax.xml.namespace.QName SQLCOMMAND$0 = 
                new javax.xml.namespace.QName("http://www.lindbergframework.org/schema", "Sql-Command");
            
            
            /**
             * Gets a List of "Sql-Command" elements
             */
            public java.util.List<org.lindbergframework.schema.TSqlCommand> getSqlCommandList()
            {
                final class SqlCommandList extends java.util.AbstractList<org.lindbergframework.schema.TSqlCommand>
                {
                    public org.lindbergframework.schema.TSqlCommand get(int i)
                        { return SqlMappingImpl.this.getSqlCommandArray(i); }
                    
                    public org.lindbergframework.schema.TSqlCommand set(int i, org.lindbergframework.schema.TSqlCommand o)
                    {
                      org.lindbergframework.schema.TSqlCommand old = SqlMappingImpl.this.getSqlCommandArray(i);
                      SqlMappingImpl.this.setSqlCommandArray(i, o);
                      return old;
                    }
                    
                    public void add(int i, org.lindbergframework.schema.TSqlCommand o)
                        { SqlMappingImpl.this.insertNewSqlCommand(i).set(o); }
                    
                    public org.lindbergframework.schema.TSqlCommand remove(int i)
                    {
                      org.lindbergframework.schema.TSqlCommand old = SqlMappingImpl.this.getSqlCommandArray(i);
                      SqlMappingImpl.this.removeSqlCommand(i);
                      return old;
                    }
                    
                    public int size()
                        { return SqlMappingImpl.this.sizeOfSqlCommandArray(); }
                    
                }
                
                synchronized (monitor())
                {
                    check_orphaned();
                    return new SqlCommandList();
                }
            }
            
            /**
             * Gets array of all "Sql-Command" elements
             * @deprecated
             */
            public org.lindbergframework.schema.TSqlCommand[] getSqlCommandArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    java.util.List<org.lindbergframework.schema.TSqlCommand> targetList = new java.util.ArrayList<org.lindbergframework.schema.TSqlCommand>();
                    get_store().find_all_element_users(SQLCOMMAND$0, targetList);
                    org.lindbergframework.schema.TSqlCommand[] result = new org.lindbergframework.schema.TSqlCommand[targetList.size()];
                    targetList.toArray(result);
                    return result;
                }
            }
            
            /**
             * Gets ith "Sql-Command" element
             */
            public org.lindbergframework.schema.TSqlCommand getSqlCommandArray(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TSqlCommand target = null;
                    target = (org.lindbergframework.schema.TSqlCommand)get_store().find_element_user(SQLCOMMAND$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    return target;
                }
            }
            
            /**
             * Returns number of "Sql-Command" element
             */
            public int sizeOfSqlCommandArray()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    return get_store().count_elements(SQLCOMMAND$0);
                }
            }
            
            /**
             * Sets array of all "Sql-Command" element
             */
            public void setSqlCommandArray(org.lindbergframework.schema.TSqlCommand[] sqlCommandArray)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    arraySetterHelper(sqlCommandArray, SQLCOMMAND$0);
                }
            }
            
            /**
             * Sets ith "Sql-Command" element
             */
            public void setSqlCommandArray(int i, org.lindbergframework.schema.TSqlCommand sqlCommand)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TSqlCommand target = null;
                    target = (org.lindbergframework.schema.TSqlCommand)get_store().find_element_user(SQLCOMMAND$0, i);
                    if (target == null)
                    {
                      throw new IndexOutOfBoundsException();
                    }
                    target.set(sqlCommand);
                }
            }
            
            /**
             * Inserts and returns a new empty value (as xml) as the ith "Sql-Command" element
             */
            public org.lindbergframework.schema.TSqlCommand insertNewSqlCommand(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TSqlCommand target = null;
                    target = (org.lindbergframework.schema.TSqlCommand)get_store().insert_element_user(SQLCOMMAND$0, i);
                    return target;
                }
            }
            
            /**
             * Appends and returns a new empty value (as xml) as the last "Sql-Command" element
             */
            public org.lindbergframework.schema.TSqlCommand addNewSqlCommand()
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    org.lindbergframework.schema.TSqlCommand target = null;
                    target = (org.lindbergframework.schema.TSqlCommand)get_store().add_element_user(SQLCOMMAND$0);
                    return target;
                }
            }
            
            /**
             * Removes the ith "Sql-Command" element
             */
            public void removeSqlCommand(int i)
            {
                synchronized (monitor())
                {
                    check_orphaned();
                    get_store().remove_element(SQLCOMMAND$0, i);
                }
            }
        }
    }
}
