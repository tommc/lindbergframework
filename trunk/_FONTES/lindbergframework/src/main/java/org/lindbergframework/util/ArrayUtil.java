package org.lindbergframework.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.ArrayUtils;

import com.sun.org.apache.xml.internal.utils.StringComparable;



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
	
	/**
	 * Efetua o merge entre dois arrays em um terceiro array fornecido.<br><br>
	 * 
	 * Por exemplo: O trecho de código abaixo <br><br>
	 * 
	 *  String[] a = new String[] {"aa", "bb"};
		String[] b = new String[] {"11", "22"};
		
		String[] c = merge(a, b, new String[a.length + b.length]);
		<br><br>
		
		o array <i>c</i> terá o conteúdo {"aa", "bb", "11", "22"}
	 * 
	 * @param <E>
	 * @param array1
	 * @param array2
	 * @param arrayToMerge
	 * @return
	 */
	public static <E> E[] merge(E[] array1, E[] array2,E[] arrayToMerge){
		List<E> list = new Vector<E>();
		
		list.addAll(Arrays.asList(array1));
		list.addAll(Arrays.asList(array2));
		
		return list.toArray(arrayToMerge);
	}
	
	/**
	 * Efetua o merge da mesma forma que o método {@link #merge(Object[], Object[], Object[])} <br>
	 * só que ordena o array resultando do merge baseado em um objeto {@link Comparator} passado
	 * 
	 * @param <E>
	 * @param array1
	 * @param array2
	 * @param arrayToMerge
	 * @param comparator
	 * @return
	 */
	public static <E> E[] mergeSorting(E[] array1, E[] array2,E[] arrayToMerge, Comparator<E> comparator){
		E[] arrayMerged = merge(array1, array2, arrayToMerge);
		Arrays.sort(arrayMerged, comparator);
		
		return arrayMerged;
	}
	
	
}
