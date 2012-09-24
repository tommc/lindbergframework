package org.lindbergframework.persistence.sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lindbergframework.exception.PersistenceException;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class ResultSetMapper {

    private List<ResultSetRow> rows = new ArrayList<ResultSetRow>();
    
    private int columnCount;
    
    private ResultSetMetaData meta;
    
    public ResultSetMapper(ResultSet rs) {
    	try{
    		meta = rs.getMetaData();
    		columnCount = meta.getColumnCount();
        	load(rs);
    	}catch(SQLException ex){
    		throw new PersistenceException(ex);
    	}
    }
    
    private void load(ResultSet rs) throws SQLException{
        int index = 0;
        while (rs.next()){
        	loadRow(rs, index);
        	index++;
        }
    }
    
    private void loadRow(ResultSet rs, int index) throws SQLException{
    	ResultSetMetaData rsMeta = rs.getMetaData();
    	int columnCount = rsMeta.getColumnCount();
    	List<ResultSetColumn> columns = new ArrayList<ResultSetColumn>();
    	for (int i = 1; i <= columnCount;i++){
    		String name = rsMeta.getColumnLabel(i);
    		Object value = rs.getObject(i);
    		columns.add(new ResultSetColumn(name, value,i - 1));
    	}
    	rows.add(new ResultSetRow(index, columns));
    }
    
    public boolean hasData(){
        return ! rows.isEmpty();
    }
    
    public ResultSetRow getRow(int index){
    	return rows.get(index);
    }
    
    public int getRowCount(){
        return rows.size();
    }
    
    public int getColumnCount() {
		return columnCount;
	}
    
    public ResultSetRow getFisrt(){
        if (! hasData())
            return null;
        
        return rows.get(0);
    }
    
    public ResultSetRow getLast(){
        if (! hasData())
            return null;
        
        return rows.get(getRowCount() - 1);
    }
    
    public ResultSetMetaData getMetaData() {
		return meta;
	}
    
    public List<ResultSetRow> getRows() {
		return rows;
	}
}
