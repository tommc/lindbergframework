package org.lindbergframework.integration.web.jsf.el;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.exception.BeanNotFoundException;

/**
 * 
 * @author Victor Lindberg
 *
 */
class ResponseBeans {

    private HttpServletResponse response;

    private Map<String, Object> cacheBeans = new HashMap<String, Object>();

    private BeanFactory beanFactory;

    public ResponseBeans(HttpServletResponse response, BeanFactory beanFactory) {
        this.response = response;
        this.beanFactory = beanFactory;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public <E> E getBean(String id) throws BeanNotFoundException {
        E bean = (E) cacheBeans.get(id);

        if (bean == null) {
            bean = beanFactory.getBean(id);
            cacheBeans.put(id, bean);
        }

        return bean;
    }

    public boolean containsBean(String id) {
        return containsCacheForBean(id) || beanFactory.containsBean(id);
    }

    public boolean containsCacheForBean(String id) {
        return cacheBeans.get(id) != null;
    }

}
