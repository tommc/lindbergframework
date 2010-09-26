package org.lindbergframework.persistence.sql;

import java.sql.SQLException;

import org.lindbergframework.persistence.translate.SqlStringSyntaxTranslator;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class RowDataTree {
	
	private SqlNode tree;
	private String stringForSplitProperties;
	
	public RowDataTree(DataSet dataSet) throws SQLException{
	   this(dataSet,SqlStringSyntaxTranslator.PROPERTY_PATTERN_SPLIT_SEPARATOR_REPLACEMENT);
	}
	
	public RowDataTree(DataSet dataSet,String stringForSplitProperties) throws SQLException{
		if (dataSet.isBeforeFirst() || dataSet.isAfterLast())//must to be pointing for some position valid in dataSet
			   throw new SQLException("The DataSet can't to be pointing for before first position or after last position");
		
		this.stringForSplitProperties = stringForSplitProperties;
		
		tree = createTree(dataSet);
	}
	
	public SqlNode getTree(){
		return tree;
	}
	
	protected SqlNode createTree(DataSet dataSet) throws SQLException{
		SqlNode newRoot = new SqlNode();
		
		DataSetMetaDada meta = dataSet.getMetaData();
		for (int i = 1;i <= meta.getColumnCount();i++){
		   loadChild(newRoot, meta.getColumnLabel(i), dataSet.getValue(i));
		}
		
		return newRoot;
	}
	
	protected void loadChild(SqlNode parent, String property, Object value){
		loadChild(parent, 0 ,getSplitProperty(property), value);
	}
	
	private void loadChild(SqlNode parent, int level, String[] propertyAddressTokens, Object value){
		String property = propertyAddressTokens[level];
		
		if (level == propertyAddressTokens.length - 1){
			parent.addChild(new SqlNode(property,value));
		}else{
			SqlNode child = parent.getChild(property);
			if (child == null){
				child = new SqlNode(property,null);
				parent.addChild(child);
			}
			
			loadChild(child, level + 1, propertyAddressTokens, value);
		}
			
	}
	
	public String[] getSplitProperty(String property){
		String[] split = property.split(stringForSplitProperties);
		
		if (split.length == 0)
			return new String[] {property};
		
		return split;
	}
		
	
}
