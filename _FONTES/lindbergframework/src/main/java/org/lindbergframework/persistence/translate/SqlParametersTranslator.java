package org.lindbergframework.persistence.translate;

/**
 * 
 * @author Victor Lindberg
 *
 */
//TODO: Remover esta classe caso não esteja sendo usada
public class SqlParametersTranslator implements SqlStringSyntaxTranslator<String>{
	
	private Object[] params;
	
	public SqlParametersTranslator(Object... params){
		this.params = params;
	}
	
	public String translate(String sql) {
		for (Object obj : params){
			sql = sql.replaceFirst(PARAMETER_STRING_RESERVED, obj.toString());
		}
		
		return sql;
	}
	
	
}
