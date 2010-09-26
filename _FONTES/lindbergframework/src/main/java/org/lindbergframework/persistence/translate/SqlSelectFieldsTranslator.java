package org.lindbergframework.persistence.translate;

import org.springframework.util.StringUtils;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class SqlSelectFieldsTranslator implements SqlStringSyntaxTranslator<String>{
	
	
	public SqlSelectFieldsTranslator(){
		//
	}
	
	public String translate(String sql) {
		sql = sql.trim();
		
		String sqlFields = getSqlFields(sql);
		
        sql = StringUtils.delete(sql, sqlFields);
		
		sqlFields = sqlFields.trim();
		
		String sqlFieldsTranslated = executeTranslationSqlFields(sqlFields);
		
        String sqlFrom = sql.substring(7);
	    
		return String.format("select %s %s", sqlFieldsTranslated, sqlFrom);
	}
	
	public String getSqlFields(String sql){
	    int  indexFrom = 0;
	    String sqlAux = sql.toUpperCase();
	    do{
	      int indexFromLocal = sqlAux.indexOf("FROM");
	      try{
	         if (indexFromLocal != -1){
	             indexFrom += indexFromLocal + 4;
	             if ((sql.charAt(indexFrom - 5) == ' ' || sql.charAt(indexFrom - 5) == '\t') &&
	                 (sql.charAt(indexFrom) == ' ' || sql.charAt(indexFrom) == '\t'))
	                break;
	             else
	                sqlAux = sqlAux.substring(indexFromLocal + 4);
	         }
	      }catch(IndexOutOfBoundsException ex){
	          continue;
	      }
	    }
	    while(indexFrom != -1);
	    
		return sql.substring(6,indexFrom - 5).trim();
	}
	
	protected String executeTranslationField(String str){
		return replacePropertySeparator(replaceReservedCharacters(str));
	}
	
	protected String replaceReservedCharacters(String str){
		return str.replace(PROPERTY_SEPARATOR_STRING_RESERVED, PROPERTY_SEPARATOR_STRING_RESERVED_REPLACEMENT_ESCAPE);
	}
	
	protected String replacePropertySeparator(String str){
		String replaceResult = str.replace(PROPERTY_SEPARATOR, PROPERTY_SEPARATOR_REPLACEMENT);
		
		return replaceResult.replace(PROPERTY_SEPARATOR_REPLACEMENT + "*", PROPERTY_SEPARATOR + "*");
	}
	
	public String executeTranslationSqlFields(String sqlFields){
		String[] sqlFieldsArray = sqlFields.split(",");
		
		StringBuffer strBf = new StringBuffer();
		for (int i = 0;i < sqlFieldsArray.length;i++){
			String campo = sqlFieldsArray[i].trim();
			int indexOfLastWord = campo.lastIndexOf(" ") + 1;
			
			if (indexOfLastWord == 0){
			   if (! campo.contains(PROPERTY_SEPARATOR))
			      campo =  executeTranslationField(campo);
			}
			else{
				String alias = campo.substring(indexOfLastWord);
				campo = campo.substring(0,indexOfLastWord);
				campo = campo + executeTranslationField(alias);
			}
			   
			strBf.append(campo + (i == sqlFieldsArray.length - 1 ? "" : ", "));
		}
		
		return strBf.toString();
			
	}
	
	
}
