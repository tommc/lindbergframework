package org.lindbergframework.persistence.util;

import org.lindbergframework.persistence.translate.SqlStringSyntaxTranslator;

/**
 * Utilitary class to sql translation operations.
 * 
 * @author Victor Lindberg
 *
 */
public class SqlTranslateUtil {
	
    /**
     * Executes the translation of sql based on specified translators.
     *   
     * @param sql sql to translate.
     * @param translators translators to execute the translation.
     * @return sql translated.
     */
	public static String translateSqlString(String sql, SqlStringSyntaxTranslator<String>... translators){
		for (SqlStringSyntaxTranslator<String> trans : translators)
			sql = trans.translate(sql);
		
		return sql;
	}

}
