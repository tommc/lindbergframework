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

}
