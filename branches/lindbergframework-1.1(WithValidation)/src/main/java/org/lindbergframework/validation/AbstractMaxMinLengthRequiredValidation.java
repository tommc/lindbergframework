package org.lindbergframework.validation;

/**
 * Classe abstrata que define validações referentes a comprimento <br>
 * máximo e minimo seja de String's, de arrarys, de collections, etc...
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractMaxMinLengthRequiredValidation<E> implements IValidation<E>{

	private int maxLengthRequired = 0;
	private int minLengthRequired = 0;
	
	public AbstractMaxMinLengthRequiredValidation(){
		//
	}
	
	public AbstractMaxMinLengthRequiredValidation(int minLengthRequired, int maxLengthRequired){
		setMaxLengthRequired(maxLengthRequired);
		setMinLengthRequired(minLengthRequired);
	}
	
	

    public int getMaxLengthRequired() {
		return maxLengthRequired;
	}

	public void setMaxLengthRequired(int maxLengthRequired) {
		this.maxLengthRequired = maxLengthRequired;
	}
	
    public void setMinLengthRequired(int minLengthRequired) {
        this.minLengthRequired = minLengthRequired;
    }
    
    public int getMinLengthRequired() {
        return minLengthRequired;
    }
	
	
}
