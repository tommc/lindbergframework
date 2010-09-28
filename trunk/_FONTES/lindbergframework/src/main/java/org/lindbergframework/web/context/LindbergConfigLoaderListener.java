package org.lindbergframework.web.context;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.core.context.WebClassPathXmlCoreConfiguration;
import org.lindbergframework.core.context.WebCoreConfiguration;
import org.lindbergframework.exception.WebConfigurationException;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.util.LogUtil;
import org.springframework.beans.BeanUtils;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergConfigLoaderListener implements ServletContextListener, HttpSessionListener{
    
    public static final String ATTRIBUTE_BEANS_REPOSITORY = "lindbergSessionBeansRepository";    
	
	public LindbergConfigLoaderListener(){
		//
	}
	
	public void contextInitialized(ServletContextEvent sce) {
	   	if (! LinpContext.getInstance().isActive()){
	   	    LogUtil.logInfo("Initializing Lindberg Web Context");
	   		ServletContext servletContext = sce.getServletContext();
	   		
	   		String configLocation = (String) servletContext.getInitParameter(WebCoreConfiguration.CONFIG_LOCATION_PARAM);
	   		String configClassParam = (String) servletContext.getInitParameter(WebCoreConfiguration.CONFIG_CLASS_PARAM);
	   		
	   		if (configLocation == null)
	   		  configLocation = WebCoreConfiguration.DEFAULT_CONFIG_LOCATION;

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
	   		
	   		CoreContext.getInstance().loadConfiguration(webConfiguration);
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
	
	public void sessionDestroyed(HttpSessionEvent se) {
	    Map map = (Map) se.getSession().getAttribute(ATTRIBUTE_BEANS_REPOSITORY);
	    if (map != null){
	       map.remove(se.getSession());
	       LogUtil.logInfo("Lindberg Beans Cache Repository for Session with id ["+se.getSession().getId()+"] was removed");
	    }
	}

}
