package br.com.lindbergframework.validation;


/**
 * Interface que define as valida��es para compara��es entre objetos
 * 
 * @author Victor Lindberg
 *
 */
public interface IComparableValidation<E> extends IValidation<Comparable<E>>{
	
	/**
	 * Configura o valor para compara��o
	 */
	public void setValorComparacao(E valorComparacao);
	
	/**
	 * Retorna o valor para compara��o
	 */
	public E getValorComparacao();
	
	
	

}
