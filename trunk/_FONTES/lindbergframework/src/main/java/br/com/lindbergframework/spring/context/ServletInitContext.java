package br.com.lindbergframework.spring.context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * Servlet utilit�rio que � carregado na inicializa��o da aplica��o. <br>
 * Este servlet � utilizado para inicializar as configura��es na aplica��o <br>
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
