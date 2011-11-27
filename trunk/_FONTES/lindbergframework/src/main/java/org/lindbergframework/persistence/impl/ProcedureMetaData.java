package org.lindbergframework.persistence.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
class ProcedureMetaData {

    private List<ProcedureColumnMetaData> columnMetaData;
    
    /**
     * Construtor padrão.
     * @throws SQLException 
     */
    public ProcedureMetaData(ResultSet rs) throws SQLException {
        load(rs);
    }
    
    private void load(ResultSet rs) throws SQLException{
        ResultSetMetaData meta = rs.getMetaData();
        columnMetaData = new ArrayList<ProcedureColumnMetaData>();
        int index = 0;
        while (rs.next()){
            String name = rs.getString(4);
            short stereotype = rs.getShort(5);
            int type = rs.getInt(6);
            columnMetaData.add(new ProcedureColumnMetaData(name, type, stereotype,index));
            index++;
        }
    }
    
    public boolean hasData(){
        return ! columnMetaData.isEmpty();
    }
    
    public List<ProcedureColumnMetaData> getColumnMetaData() {
        return columnMetaData;
    }
    
    public int getColumnCount(){
        return columnMetaData.size();
    }
    
    public ProcedureColumnMetaData getColumnMetaData(int index){
        return columnMetaData.get(index);
    }
    
    public ProcedureColumnMetaData getFisrt(){
        if (! hasData())
            return null;
        
        return columnMetaData.get(0);
    }
    
    public ProcedureColumnMetaData getLast(){
        if (! hasData())
            return null;
        
        return columnMetaData.get(getColumnCount() - 1);
    }
}
