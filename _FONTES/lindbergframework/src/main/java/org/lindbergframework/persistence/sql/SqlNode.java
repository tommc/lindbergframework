package org.lindbergframework.persistence.sql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SqlNode {
	
	private String property;
	private Object value;
	private Map<String,SqlNode> childs = new HashMap<String,SqlNode>(); 
	
	public SqlNode(){
		//
		
	}
	
	public SqlNode(String property, Object value, Map<String,SqlNode> childs) {
		this(property,value);
		this.childs = childs;
	}
	
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

	public Collection<SqlNode> getChilds() {
		return childs.values();
	}

	public void addChild(SqlNode node){
		childs.put(node.getProperty(),node);
	}
	
	public void removeChild(SqlNode node){
	   childs.remove(node);
	}
	
	public void removeAllChildren(){
		childs.clear();
	}
	
	public int getCountChilds(){
		return childs.size();
	}
	
	public boolean isLeaf(){
		return childs.isEmpty();
	}
	
	public void clear(){
		setProperty(null);
		setValue(null);
		removeAllChildren();
	}
	
	public SqlNode getChild(String propertyChild){
		return childs.get(propertyChild);
	}
	
	public SqlNode getChild(int indexProperty){
		return new ArrayList<SqlNode>(childs.values()).get(indexProperty);
	}
	
	public boolean hasChild(String propertyChild){
	   return getChild(propertyChild) != null;	
	}
	
}
