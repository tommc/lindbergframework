package br.com.lindbergframework.spring.context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.lindbergframework.spring.LindbergSpringFactory;
import br.com.lindbergframework.validation.IExecutorValidation;
import br.com.lindbergframework.validation.ValidationItem;
import br.com.lindbergframework.validation.factory.ValidationFactory;
import br.com.lindbergframework.validation.settings.MsgType;


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