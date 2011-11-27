package org.lindbergframework.persistence.impl;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
class ProcedureColumnMetaData {
    
    private String name;
    private int type;
    private short stereotype;
    private int index;
    
    public ProcedureColumnMetaData(String name, int type, short stereotype, int index) {
        this.name = name;
        this.type = type;
        this.stereotype = stereotype;
        this.index = index;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the type
     */
    public int getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    /**
     * @return the stereotype
     */
    public short getStereotype() {
        return stereotype;
    }
    /**
     * @param stereotype the stereotype to set
     */
    public void setStereotype(short stereotype) {
        this.stereotype = stereotype;
    }
    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }
    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
    

    
}
