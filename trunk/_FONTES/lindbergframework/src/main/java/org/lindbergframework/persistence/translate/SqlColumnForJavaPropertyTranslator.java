package org.lindbergframework.persistence.translate;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.lindbergframework.util.StringUtil;


/**
 * Translator implementation to do transalation of a property in java pattern to sql pattern.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlColumnForJavaPropertyTranslator implements SqlStringSyntaxTranslator<String>{
	
	public SqlColumnForJavaPropertyTranslator(){
		//
	}
	
	/**
	 * translates a property name in sql pattern to java pattern.
	 */
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
		   strBuf.append(i == 0 ? subStr : StringUtil.toUpperCaseFirstLetter(subStr));
		}
		
		return strBuf.toString();
	}
		
	
}
