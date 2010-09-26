package org.lindbergframework.persistence;

import java.sql.Driver;

import javax.sql.DataSource;

import org.lindbergframework.exception.PersistenceException;
import org.lindbergframework.persistence.datasource.SingleConnectionThreadLocalDataSource;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class DataSourceConfig {
	
	private DataSource dataSource;
	private Class driver;
	
	public DataSourceConfig(){
		//
	}

	public DataSourceConfig(DataSource dataSource, Class driver) {
		setDataSource(dataSource);
		setDriver(driver);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public final void setDataSource(DataSource dataSource) {
		this.dataSource = new SingleConnectionThreadLocalDataSource(dataSource);
	}

	public Class getDriver() {
		return driver;
	}

	public void setDriver(Class driver) {
		if (! Driver.class.isAssignableFrom(driver))
				throw new PersistenceException("driver property ["+driver+"] does not correspond to " +
						"a class that implements the Driver interface");
			
		this.driver = driver;
	}
	
	public boolean isDriverLoaded(){
		return driver != null;
	}

}
