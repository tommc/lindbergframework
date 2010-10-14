package org.lindbergframework.persistence.beans;

import org.lindbergframework.persistence.translate.SqlColumnForJavaPropertyTranslator;
import org.lindbergframework.persistence.util.TranslateUtil;

/**
 * abstract bean populator with main resources for all {@link BeanPopulator} implementations.
 * 
 * @author Victor Lindberg
 *
 */
public abstract class BeanPopulatorBase implements BeanPopulator{
	
	public BeanPopulatorBase(){
		//
	}
	
	/**
	 * Formats a sql column name to java pattern.
	 * @param sqlColumn sql column name.
	 * 
	 * @return column name in the java pattern
	 */
	public String sqlColumnToJavaProperyPattern(String sqlColumn){
		return TranslateUtil.translateString(sqlColumn,
                new SqlColumnForJavaPropertyTranslator());
	}

}
