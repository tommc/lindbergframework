package org.lindbergframework.util;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class StringUtil {
	
	public static int indexOfIgnoreCase(String str,String substr){
		substr = substr.toUpperCase();
		str = str.toUpperCase();
		
		return str.indexOf(substr);
	}
	
	public static String toUpperCaseFirstLetter(String str){
	       char[] chars = str.toCharArray();
	       
	       chars[0] = Character.toUpperCase(chars[0]);
	       
	       return new String(chars);  
	    }

}
