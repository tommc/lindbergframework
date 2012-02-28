package org.lindbergframework.orm.hibernate.support;

import java.util.logging.Logger;

import org.hibernate.FlushMode;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

/**
 * {@link OpenSessionInViewFilter} extension that works with FlushMode.AUTO by default.
 * 
 * @author Victor Lindberg
 *
 */
public class MyViewScopesOpenSessionInViewFilter extends OpenSessionInViewFilter{

	private Logger logger = Logger.getLogger(getClass().getName());
	
	public MyViewScopesOpenSessionInViewFilter() {
		setFlushMode(FlushMode.AUTO);
		logger.info("Usando [MyViewScopesOpenSessionInViewFilter] como implementação de OpenSessionInViewFilter com FlushMode.AUTO. Em AccessScope, FlushMode.COMMIT é usado.");
	}
}
