package org.lindbergframework.persistence.translate;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.store.CharUtil;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class SqlColumnForJavaPropertyTranslator implements SqlStringSyntaxTranslator<String>{
	
	public SqlColumnForJavaPropertyTranslator(){
		//
	}
	
	public String translate(String sqlProperty) {
	    if (! sqlProperty.contains("_")){
	    	for (char ch : sqlProperty.toCharArray())
	    		if (CharUtils.isAsciiAlphaLower(ch))
                   return sqlProperty;
	    	
	    	return sqlProperty.toLowerCase();
	    }
	    
        String[] strArray = StringUtils.split(sqlProperty,"_");
		
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0;i < strArray.length;i++){
		   String subStr = strArray[i].toLowerCase();
		   strBuf.append(i == 0 ? subStr : toUpperCaseFirstLetter(subStr));
		}
		
		return strBuf.toString();
	}
		
	public String toUpperCaseFirstLetter(String str){
	   char[] chars = str.toCharArray();
	   
	   chars[0] = Character.toUpperCase(chars[0]);
	   
	   return new String(chars);  
	}
	
	
}
