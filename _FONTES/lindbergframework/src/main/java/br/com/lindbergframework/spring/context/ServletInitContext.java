package br.com.lindbergframework.spring.context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Servlet utilitário que é carregado na inicialização da aplicação. <br>
 * Este servlet é utilizado para inicializar as configurações na aplicação <br>
 * que necessitam acessar recursos do ambiente web, por exemplo a referencia a <br>
 * instancia do ApplicationContext 
 * 
 * @author Victor Lindberg
 *
 */
public class ServletInitContext extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		SingletonSpringBeanFactory.initContext(appContext);
	}
	
}
