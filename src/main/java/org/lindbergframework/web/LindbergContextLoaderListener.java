package org.lindbergframework.web;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.exception.WebConfigurationException;
import org.lindbergframework.util.LogUtil;
import org.lindbergframework.web.core.configuration.WebClassPathXmlCoreConfiguration;
import org.lindbergframework.web.core.configuration.WebCoreConfiguration;
import org.springframework.beans.BeanUtils;

/**
 * Web listener to initialize the configuration of lindbergframework. 
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergContextLoaderListener implements ServletContextListener, HttpSessionListener{
   
	/**
	 * attribute name of bean repository map in session. This attribute is uses by BeanRepositoryByResponse.
	 */
    public static final String ATTRIBUTE_BEANS_REPOSITORY = "lindbergSessionBeansRepository";    
	
	public LindbergContextLoaderListener(){
		//
	}
	
	/**
	 * initializes the lindberg configuration. 
	 */
	public void contextInitialized(ServletContextEvent sce) {
	   	if (! CoreContext.getInstance().isActive()){
	   	    LogUtil.logInfo("Initializing Lindberg Web Context");
	   		ServletContext servletContext = sce.getServletContext();
	   		
	   		String configLocation = (String) servletContext.getInitParameter(WebCoreConfiguration.CONFIG_LOCATION_PARAM);
	   		String configClassParam = (String) servletContext.getInitParameter(WebCoreConfiguration.CONFIG_CLASS_PARAM);
	   		
	   		if (configLocation == null)
	   		  configLocation = WebCoreConfiguration.DEFAULT_CONFIG_FILE_NAME;

	   		Class configClass;
	   		if (configClassParam == null)
	   			configClass = WebClassPathXmlCoreConfiguration.class;
	   		else
	   		    configClass = getConfigClass(configClassParam);
	   		
	   		if (! WebCoreConfiguration.class.isAssignableFrom(configClass))
	   			throw new WebConfigurationException("Lindberg Web Context initialization failed. Configuration class "+
	   					configClass.getName()+" is not of type "+WebCoreConfiguration.class.getName());
	   		
	   		WebCoreConfiguration webConfiguration = (WebCoreConfiguration) BeanUtils.instantiateClass(configClass);
	   		webConfiguration = webConfiguration.initialize(configLocation, servletContext);
	   		webConfiguration.initializeContext();
	   		LogUtil.logInfo("Lindberg Web Context initialized");
	   	}
	}
	
	private Class getConfigClass(String clazzStr) {
		try {
			return Class.forName(clazzStr);
		} catch (ClassNotFoundException ex) {
			throw new WebConfigurationException("Lindberg Web Context initialization failed",ex);
		}
	}
	
	public void contextDestroyed(ServletContextEvent sce) {}
	
	public void sessionCreated(HttpSessionEvent se) {}
	
	/**
	 * Removes the bean repository map when the user session is destroyed.
	 * This attribute is added in the session by BeanRepositoryByResponse.
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
	    Map map = (Map) se.getSession().getAttribute(ATTRIBUTE_BEANS_REPOSITORY);
	    if (map != null){
	       map.remove(se.getSession());
	       LogUtil.logInfo("Lindberg Beans Cache Repository for Session with id ["+se.getSession().getId()+"] was removed");
	    }
	}

}
