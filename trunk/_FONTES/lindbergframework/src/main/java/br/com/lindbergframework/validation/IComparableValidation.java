package br.com.lindbergframework.validation;


/**
 * Interface que define as validações para comparações entre objetos
 * 
 * @author Victor Lindberg
 *
 */
public interface IComparableValidation<E> extends IValidation<Comparable<E>>{
	
	/**
	 * Configura o valor para comparação
	 */
	public void setValorComparacao(E valorComparacao);
	
	/**
	 * Retorna o valor para comparação
	 */
	public E getValorComparacao();
	
	
	

}
