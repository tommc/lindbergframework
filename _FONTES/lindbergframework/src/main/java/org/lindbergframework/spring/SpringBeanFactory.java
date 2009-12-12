package org.lindbergframework.spring;

import org.springframework.context.ApplicationContext;

/**
 * Fábrica de beans do Spring
 * 
 * 
 * @author Victor Lindberg
 * 
 */
public class SpringBeanFactory {

	/**
	 * Contexto do spring
	 */
	private ApplicationContext applicationContext;

	/**
	 * Cria uma nova fábrica de bens do spring baseada em um applicationcontext pronto
	 * @param appContext
	 */
	public SpringBeanFactory(ApplicationContext appContext) {
		applicationContext = appContext;
	}
	
	/**
	 * retorna o context configurado na fábrica
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public boolean isContextConfigured(){
		return applicationContext != null;
	}

	/**
	 * Retorna a instancia de um bean do Spring
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
