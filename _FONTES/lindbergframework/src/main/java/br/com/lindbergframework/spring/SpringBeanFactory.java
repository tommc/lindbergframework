package br.com.lindbergframework.spring;

import org.springframework.context.ApplicationContext;

/**
 * Fábrica de beans do Spring
 * 
 * 
 * @author Victor Lindberg
 * 
 */
public class SpringBeanFactory {

	private ApplicationContext applicationContext;

	public SpringBeanFactory(ApplicationContext appContext) {
		applicationContext = appContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * Retorna a instancia de um beans do Spring
	 * 
	 * @param bean
	 *            = id do bean do Spring
	 * @return = retorna o bean do Spring ou null se o mesmo nao foi <br>
	 *         encontrado ou se o bean nao pode ser criado
	 */
	@SuppressWarnings("unchecked")
	public <E> E getBean(String bean) {
		try {
			return (E) applicationContext.getBean(bean);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
