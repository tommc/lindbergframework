package org.lindbergframework.persistence.beans;

import org.lindbergframework.persistence.translate.SqlColumnForJavaPropertyTranslator;
import org.lindbergframework.persistence.util.SqlTranslateUtil;
import org.lindbergframework.persistence.util.TransactionUtil;

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
		return SqlTranslateUtil.translateSqlString(sqlColumn,
                new SqlColumnForJavaPropertyTranslator());
	}
	
	protected <E> E applyContextsPrePopulate(E bean){
		if (TransactionUtil.isTransactional(bean.getClass()))
			return TransactionUtil.createTransactionProxy(bean.getClass());
		
		return bean;
	}

}
