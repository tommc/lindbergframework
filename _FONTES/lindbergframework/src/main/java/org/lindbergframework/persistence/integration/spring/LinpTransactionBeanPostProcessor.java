package org.lindbergframework.persistence.integration.spring;

import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.exception.BeanException;
import org.lindbergframework.persistence.util.TransactionUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Lindberg Persistence Bean post processor implementation for
 * Spring and lindbergframework integration for transaction operations.
 * 
 * @author Victor Lindberg
 *
 */
public class LinpTransactionBeanPostProcessor implements BeanPostProcessor{
	
    /**
     * Creates lindberg transaction proxy for bean if necessary. 
     */
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (TransactionUtil.isSomeMethodOrClassTransactional(bean.getClass())) {
			Object proxy = TransactionUtil.createTransactionProxy(bean.getClass());
			try {
				BeanUtil.copyProperties(bean, proxy);
			} catch (Exception ex) {
				throw new BeanException("Instantiation of bean failed", ex);
			}

			return proxy;
		}

		return bean;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}
	
	
	

}
