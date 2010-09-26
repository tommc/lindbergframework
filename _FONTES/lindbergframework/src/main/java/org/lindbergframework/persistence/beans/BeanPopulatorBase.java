package org.lindbergframework.persistence.beans;

import org.lindbergframework.persistence.translate.SqlColumnForJavaPropertyTranslator;
import org.lindbergframework.persistence.util.TranslateUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
public abstract class BeanPopulatorBase {
	
	public BeanPopulatorBase(){
		//
	}
	
	public String sqlColumnToJavaProperyPattern(String sqlColumn){
		return TranslateUtil.translateString(sqlColumn,
                new SqlColumnForJavaPropertyTranslator());
	}

}
