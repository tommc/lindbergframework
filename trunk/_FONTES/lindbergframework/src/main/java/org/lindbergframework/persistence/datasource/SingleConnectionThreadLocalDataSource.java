package org.lindbergframework.persistence.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.lindbergframework.exception.PersistenceException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SingleConnectionThreadLocalDataSource implements DataSource{
	
	private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<Connection>();
	
	private DataSource dataSource;
	
	
	public SingleConnectionThreadLocalDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

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

	public Connection getConnection(String username, String password)
			throws SQLException {
		return dataSource.getConnection(username, password);
	}

	public PrintWriter getLogWriter() throws SQLException {
		return dataSource.getLogWriter();
	}

	public int getLoginTimeout() throws SQLException {
		return dataSource.getLoginTimeout();
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		dataSource.setLogWriter(out);
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		dataSource.setLoginTimeout(seconds);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}
	
	public boolean isThreadLocalActive(){
		return connThreadLocal.get() != null;
	}
	
	
	
}
