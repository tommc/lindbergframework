package org.lindbergframework.persistence.datasource;

import javax.sql.DataSource;

import org.lindbergframework.persistence.context.LinpContext;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class LinpContextDataSource extends SingleConnectionThreadLocalDataSource{

	public LinpContextDataSource() {
		//
	}
	
	@Override
	public DataSource getTargetDataSource() {
		return LinpContext.getInstance().getDataSourceConfig().getTargetDataSource();
	}
	
}
