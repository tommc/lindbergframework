package org.lindbergframework.persistence.sql;

import java.sql.SQLException;

import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.persistence.translate.SqlStringSyntaxTranslator;

/**
 * Class that organizes a DataSet result as a data tree (multilevel)
 * based on SqlStringSyntaxTranslator.PROPERTY_PATTERN_SPLIT_SEPARATOR_REPLACEMENT
 * to split the string column name in levels.
 * <br><br>
 * The tree nodes are {@link SqlNode} objects. To get the root node call {@link #getTree()}.
 * 
 * @author Victor Lindberg
 *
 */
public final class RowDataTree {
	
    /**
     * Root sql node.
     */
	private SqlNode tree;
	
	/**
	 * String token to split the string column name in levels.
	 */
	private String stringForSplitProperties;
	
	/**
	 * Creates a RowDataTree with the specified dataset.
	 * @param dataSet dataset to create the data tree.
	 * @throws SQLException database access error.
	 */
	public RowDataTree(DataSet dataSet) {
	   this(dataSet,SqlStringSyntaxTranslator.PROPERTY_PATTERN_SPLIT_SEPARATOR);
	}
	
	/**
	 * Creates a RowDataTree with the specified dataset and stringForSplitProperties.
	 * @param dataSet dataset to create the data tree.
	 * @param stringForSplitProperties split the string column name in levels. Default value  
	 * @throws SQLException dataset access error.
	 */
	public RowDataTree(DataSet dataSet,String stringForSplitProperties) {
		init(dataSet, stringForSplitProperties);
	}
	
	private void init(DataSet dataSet,String stringForSplitProperties){
	    try{
	    if (dataSet.isBeforeFirst() || dataSet.isAfterLast())//must to be pointing for some position valid in dataSet
            throw new SQLException("The DataSet can't to be pointing for before first position or after last position");
     
	    this.stringForSplitProperties = stringForSplitProperties;
     
	    tree = createTree(dataSet);
	    }catch(SQLException ex){
	        throw new BeanPopulateException(ex);
	    }
	}
	
	/**
	 * Get the root node.
	 * 
	 * @return root node.
	 */
	public SqlNode getTree(){
		return tree;
	}
	
	/**
	 * Builds the tree based on specified data set.
	 * 
	 * @param dataSet data set to build the tree.
	 * @return root node.
	 * @throws SQLException dataset access error.
	 */
	protected SqlNode createTree(DataSet dataSet) throws SQLException{
		SqlNode newRoot = new SqlNode();
		
		DataSetMetaDada meta = dataSet.getMetaData();
		for (int i = 1;i <= meta.getColumnCount();i++){
		   loadChild(newRoot, meta.getColumnLabel(i), dataSet.getValue(i));
		}
		
		return newRoot;
	}
	
	/**
	 * loads the node based on specified property and value.
	 * @param parent parent node.
	 * @param property current property.
	 * @param value node value.
	 */
	protected void loadChild(SqlNode parent, String property, Object value){
	    property = property.replaceAll(SqlStringSyntaxTranslator.PROPERTY_PATTERN_SPLIT_SEPARATOR_REPLACEMENT, SqlStringSyntaxTranslator.PROPERTY_PATTERN_SPLIT_SEPARATOR);
		loadChild(parent, 0 ,getSplitProperty(property), value);
	}
	
	/**
	 * loads the node based on current level, specified property array (multilevel) and value.
	 * 
	 * @param parent parent node.
	 * @param level current level.
	 * @param propertyAddressTokens property array (multilevel).
	 * @param value node value.
	 */
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
	
	/**
	 * executes the split on property.
	 * 
	 * @param property property to split.
	 * @return split from property.
	 */
	public String[] getSplitProperty(String property){
	    String[] split = property.split(SqlStringSyntaxTranslator.PROPERTY_PATTERN_SPLIT_SEPARATOR);
		
		if (split.length == 0)
			return new String[] {property};
		
		return split;
	}
	
}
