package org.lindbergframework.integration.web.jsf.beans;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.exception.BeanNotFoundException;

/**
 * Class that encapsulates beans for a specified response.
 * 
 * @author Victor Lindberg
 *
 */
class ResponseBeans {

    /**
     * Current response.
     */
    private HttpServletResponse response;

    /**
     * Bean for response.
     */
    private Map<String, Object> cacheBeans = new HashMap<String, Object>();

    /**
     * Bean factory implementation.
     */
    private BeanFactory beanFactory;

    public ResponseBeans(HttpServletResponse response, BeanFactory beanFactory) {
        this.response = response;
        this.beanFactory = beanFactory;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    /**
     * Get bean instance for specified id.
     * 
     * @param <E> bean type expected.
     * @param id bean id.
     * @return bean instance.
     * 
     * @throws BeanNotFoundException bean not found.
     */
    public <E> E getBean(String id) throws BeanNotFoundException {
        E bean = (E) cacheBeans.get(id);

        if (bean == null) {
            bean = (E) beanFactory.getBean(id);
            cacheBeans.put(id, bean);
        }

        return bean;
    }

    /**
     * Checks if this context contains a bean with the specified id.
     * 
     * @param id bean id.
     * @return true if contains bean for specified id.
     */
    public boolean containsBean(String id) {
        return containsCacheForBean(id) || beanFactory.containsBean(id);
    }

    /**
     * Checks if the cache contains a bean with the specified id.
     * 
     * @param id bean id.
     * @return true if contains bean for specified id.
     */
    public boolean containsCacheForBean(String id) {
        return cacheBeans.get(id) != null;
    }

}
