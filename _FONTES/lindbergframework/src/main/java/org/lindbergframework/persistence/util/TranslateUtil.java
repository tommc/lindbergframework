package org.lindbergframework.persistence.util;

import org.lindbergframework.persistence.translate.SqlStringSyntaxTranslator;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class TranslateUtil {
	
	public static String translateString(String sql, SqlStringSyntaxTranslator<String>... translators){
		for (SqlStringSyntaxTranslator<String> trans : translators)
			sql = trans.translate(sql);
		
		return sql;
	}

}
