package org.lindbergframework.persistence.sql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Sql result node. A sql node is used to map a result using multilevel strategy.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlNode {
	
    /**
     * bean property name in the level of that node.
     */
	private String property;
	
	/**
	 * bean property value in the level of that node.
	 */
	private Object value;
	
	/**
	 * children nodes of this node. The map has as key the bean property of node.
	 */
	private Map<String,SqlNode> children = new HashMap<String,SqlNode>(); 
	
	public SqlNode(){
		//
		
	}
	
	/**
	 * creates a sql node with specified property, value and children nodes.
	 * 
	 * @param property bean property in the level of that node.
	 * @param value bean value in the level of that node.
	 * @param children children nodes.
	 */
	public SqlNode(String property, Object value, Map<String,SqlNode> children) {
		this(property,value);
		this.children = children;
	}
	
	/**
	 * creates a sql node with specified property and value.
	 * 
	 * @param property bean property in the level of that node.
	 * @param value bean value in the level of that node.
	 */
	public SqlNode(String property, Object value) {
		this.property = property;
		this.value = value;
	}


	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	
	public String getProperty() {
		return property;
	}

	/**
	 * get the children of this node.
	 * 
	 * @return children of this node.
	 */
	public Collection<SqlNode> getChildren() {
		return children.values();
	}

	/**
	 * adds a new child on this node.
	 * @param node new child.
	 */
	public void addChild(SqlNode node){
		children.put(node.getProperty(),node);
	}
	
	/**
	 * remove the child of this node.
	 * 
	 * @param node node to remove.
	 */
	public void removeChild(SqlNode node){
	   children.remove(node);
	}
	
	/**
	 * remove all children of this node.
	 */
	public void removeAllChildren(){
		children.clear();
	}
	
	/**
	 * get the count of children of this node.
	 *  
	 * @return count of children of this node.
	 */
	public int getCountChildren(){
		return children.size();
	}
	
	/**
	 * checks if this node is leaf.
	 * 
	 * @return true if this node is leaf.
	 */
	public boolean isLeaf(){
		return children.isEmpty();
	}
	
	/**
	 * cleans this node.
	 */
	public void clear(){
		setProperty(null);
		setValue(null);
		removeAllChildren();
	}
	
	/**
	 * get a child of this node associated with the specified property.
	 * 
	 * @param propertyChild bean property.
	 * 
	 * @return sql node associated with the specified property or null if the node not found.
	 */
	public SqlNode getChild(String propertyChild){
		return children.get(propertyChild);
	}
	
	/**
	 * get a child of this node associated with the specified property.
	 * 
	 * @param indexNode index of node.
	 * 
	 * @return sql node of the index or null if the node not found.
	 */
	public SqlNode getChild(int indexNode){
		return new ArrayList<SqlNode>(children.values()).get(indexNode);
	}
	
	/**
	 * checks if this node contains a child associated with the specified property.
	 * 
	 * @param propertyChild bean property.
	 * 
	 * @return true if this node contains a child associated with the specified property or null otherwise.
	 */
	public boolean hasChild(String propertyChild){
	   return getChild(propertyChild) != null;	
	}
	
}
