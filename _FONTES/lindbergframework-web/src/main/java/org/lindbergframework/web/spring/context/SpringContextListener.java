package org.lindbergframework.web.spring.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.lindbergframework.spring.context.SingletonSpringBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Web listener to initialize the SingletonSpringBeanFactory based on ServletContext.
 * 
 * @author Victor Lindberg
 *
 */
public class SpringContextListener implements ServletContextListener{
    
    private static final long serialVersionUID = 1L;

    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        SingletonSpringBeanFactory.initContext(appContext);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        //does nothing
    }
    
}
