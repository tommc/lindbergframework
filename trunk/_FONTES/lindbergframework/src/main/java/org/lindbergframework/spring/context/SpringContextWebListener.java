package org.lindbergframework.spring.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class SpringContextWebListener implements ServletContextListener{
    
    private static final long serialVersionUID = 1L;

    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        SingletonSpringBeanFactory.initContext(appContext);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        //does nothing
    }
    
}
