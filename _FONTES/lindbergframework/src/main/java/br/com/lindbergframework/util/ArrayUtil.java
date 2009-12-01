package br.com.lindbergframework.util;



/**
 * Classe utilitária para manipulação de arrays
 * 
 * @author Victor Lindberg
 *
 */
public class ArrayUtil {
	
	/**
	 * Retorna um array de objetos baseado no conjunto passado como argumento
	 */
	public static  <E> E[] toArray(E... objs){
		return objs; 
	}
	
	
}
