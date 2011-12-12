package org.lindbergframework.integration.web.jsf.el;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.web.context.LindbergConfigLoaderListener;

/**
 * Bean repository. This repository stores bean instances by Response
 * keeping the same bean instance inside of same request.
 * 
 * @author Victor Lindberg
 */
class BeanRepositoryByResponse {

    /**
     * Bean cache with bean instances for response of request.
     */
    private Map<HttpSession, ResponseBeans> cache = Collections
        .synchronizedMap(new HashMap<HttpSession, ResponseBeans>());

    private BeanFactory beanFactory;

    public BeanRepositoryByResponse(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * Records a new response.
     * 
     * @param session current session.
     * @param response currente response.
     * 
     * @return ResponseBeans instance.
     */
    public ResponseBeans registerResponse(HttpSession session,
        HttpServletResponse response) {
        ResponseBeans respBean = new ResponseBeans(response, beanFactory);
        if (!cache.containsKey(session))
            session.setAttribute(
                LindbergConfigLoaderListener.ATTRIBUTE_BEANS_REPOSITORY,cache);

        cache.put(session, respBean);
        return respBean;
    }

    public ResponseBeans getResponseBeans(HttpSession session) {
        return cache.get(session);
    }

    public Map<HttpSession, ResponseBeans> getCache() {
        return cache;
    }

}
