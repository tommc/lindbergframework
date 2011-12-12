package org.lindbergframework.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;



/**
 * Utilitary class to Array operations.
 * 
 * @author Victor Lindberg
 *
 */
public class ArrayUtil {
	
	/**
	 * Returns a array based on object varargs.
	 */
	public static  <E> E[] toArray(E... objs){
		return objs; 
	}
	
	/**
	 * Merges tow array on a other specified array.<br><br>
	 * 
	 * E.g.: <br><br>
	 * 
	 *  String[] a = new String[] {"aa", "bb"};
		String[] b = new String[] {"11", "22"};
		
		String[] c = merge(a, b, new String[a.length + b.length]);
		<br><br>
		
		The array <i>c</i> : {"aa", "bb", "11", "22"}
	 * 
	 * @param <E> type of elements in array.
	 * @param array1 array 1
	 * @param array2 array 2
	 * @param arrayToMerge array to merge.
	 * @return array merged.
	 */
	public static <E> E[] merge(E[] array1, E[] array2,E[] arrayToMerge){
		List<E> list = new Vector<E>();
		
		list.addAll(Arrays.asList(array1));
		list.addAll(Arrays.asList(array2));
		
		return list.toArray(arrayToMerge);
	}
	
	/**
	 * Executes the merge of tow array on a other array based on specified comparator implementation.
	 * 
	 * @param array1 array 1
	 * @param array2 array 2
	 * @param arrayToMerge array to merge
	 * @param comparator comparator to sort
	 * @return array merged.
	 */
	public static <E> E[] mergeSorting(E[] array1, E[] array2,E[] arrayToMerge, Comparator<E> comparator){
		E[] arrayMerged = merge(array1, array2, arrayToMerge);
		Arrays.sort(arrayMerged, comparator);
		
		return arrayMerged;
	}
	
}
