package org.lindbergframework.persistence.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.lindbergframework.exception.PersistenceException;

/**
 * Data source implementation that encapsulates other specified data source
 * and get connections by Thread.
 * 
 * This data source implementation uses thread local resource to organize the connection requests.
 * 
 * @author Victor Lindberg
 *
 */
public class SingleConnectionThreadLocalDataSource implements DataSource{
	
    /**
     * Thread local cache.
     */
	private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<Connection>();
	
	/**
	 * Data source encapsulated.
	 */
	private DataSource dataSource;
	
	/**
	 * Creates a SingleConnectionThreadLocalDataSource for specified data source.
	 * @param dataSource data source to get connections.
	 */
	public SingleConnectionThreadLocalDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	/**
	 * Get connection from cache to current thread. 
	 * If the connection for current thread is closed a new is created.
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = connThreadLocal.get();
		if (conn == null || conn.isClosed())
		try {
			connThreadLocal.set(dataSource.getConnection());
		} catch (SQLException ex) {
			throw new PersistenceException("Error initializing single connection per thread in SingleConnectionThreadLocalDataSource",ex);
		}
		
		return connThreadLocal.get();
	}

	/**
	 * Get connection from cache to current thread for specified username and password. 
	 * If the connection for current thread is closed a new is created.
	 * 
	 * @param username database username.
	 * @param password database password.
	 */
	public Connection getConnection(String username, String password)
			throws SQLException {
		return dataSource.getConnection(username, password);
	}

	/**
	 * {@inheritDoc}
	 */
	public PrintWriter getLogWriter() throws SQLException {
		return dataSource.getLogWriter();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getLoginTimeout() throws SQLException {
		return dataSource.getLoginTimeout();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLogWriter(PrintWriter out) throws SQLException {
		dataSource.setLogWriter(out);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLoginTimeout(int seconds) throws SQLException {
		dataSource.setLoginTimeout(seconds);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}
	
	/**
	 * checks if thread local cache contains connection for current thread.
	 * 
	 * @return true if there is connection on cache for current thread.
	 */
	public boolean isThreadLocalActive(){
		return connThreadLocal.get() != null;
	}
	
	
	
}
