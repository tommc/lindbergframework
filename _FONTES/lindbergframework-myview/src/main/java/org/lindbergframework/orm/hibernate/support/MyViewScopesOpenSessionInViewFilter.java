package org.lindbergframework.orm.hibernate.support;

import java.util.logging.Logger;

import org.hibernate.FlushMode;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

/**
 *
 * @author Victor Lindberg
 *
 */
public class MyViewScopesOpenSessionInViewFilter extends OpenSessionInViewFilter{

	private Logger logger = Logger.getLogger(getClass().getName());
	
	public MyViewScopesOpenSessionInViewFilter() {
		setFlushMode(FlushMode.AUTO);
		logger.info("Using [MyViewScopesOpenSessionInViewFilter] as OpenSessionInViewFilter implementation with FlushMode.AUTO. In AccessScope, FlushMode.COMMIT is used.");
	}
}
