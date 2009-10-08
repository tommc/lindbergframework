package br.com.lindbergframework.validation;


/**
 * 
 * @author Victor Lindberg
 *
 */
public interface IComparableValidation<E> extends IValidation<Comparable<E>>{
	
	public void setValorComparacao(E valor);
	
	public E getValorComparacao();
	
	
	

}
