package org.lindbergframework.persistence;

import java.sql.Driver;

import javax.sql.DataSource;

import org.lindbergframework.exception.PersistenceException;
import org.lindbergframework.persistence.datasource.SingleConnectionThreadLocalDataSource;


/**
 * Class that encapsulates datasource configurations.
 * 
 * @author Victor Lindberg
 *
 */
public class DataSourceConfig {
	
    /**
     * Data source implementation.
     */
	private DataSource dataSource;
	
	/**
	 * driver class.
	 */
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
	    if (driver == null)
	        throw new PersistenceException("driver class must be not null");
	    
		if (! Driver.class.isAssignableFrom(driver))
				throw new PersistenceException("driver property ["+driver+"] does not correspond to " +
						"a class that implements the Driver interface");
			
		this.driver = driver;
	}
	
	/**
	 * checks if the driver class was loaded.
	 * 
	 * @return true if the driver class was loaded.
	 */
	public boolean isDriverLoaded(){
		return driver != null;
	}

}
