package org.lindbergframework.util;

/**
 * Utilitary class to string operations.
 * 
 * @author Victor Lindberg
 *
 */
public class StringUtil {
	
	/**
	 * get the index of string on other string ignoring case.
	 * @param str string.
	 * @param substr string to search.
	 * @return index of substr on str ignoring case. If the substr not found in str -1 is returned.
	 * 
	 */
	public static int indexOfIgnoreCase(String str,String substr){
		substr = substr.toUpperCase();
		str = str.toUpperCase();
		
		return str.indexOf(substr);
	}
	
	/**
	 * convert the first letter in str to Upper case.
	 */
	public static String toUpperCaseFirstLetter(String str){
	       char[] chars = str.toCharArray();
	       
	       chars[0] = Character.toUpperCase(chars[0]);
	       
	       return new String(chars);  
	    }

}
