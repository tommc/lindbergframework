package org.lindbergframework.validation;

/**
 * Classe abstrata que define validações referentes a comprimento <br>
 * máximo seja de String's, de arrarys, de collections, etc...
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractMaxLengthRequiredValidation<E> implements IValidation<E>{

	private int maxLengthRequired = 0;
	
	public AbstractMaxLengthRequiredValidation(){
		//
	}
	
	public AbstractMaxLengthRequiredValidation(int maxLengthRequired){
		setMaxLengthRequired(maxLengthRequired);
	}

	public int getMaxLengthRequired() {
		return maxLengthRequired;
	}

	public void setMaxLengthRequired(int maxLengthRequired) {
		this.maxLengthRequired = maxLengthRequired;
	}
	
	
	
	
}
