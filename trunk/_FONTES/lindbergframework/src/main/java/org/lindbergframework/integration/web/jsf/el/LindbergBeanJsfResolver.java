package org.lindbergframework.integration.web.jsf.el;

import javax.el.BeanELResolver;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.beans.di.context.UserBeanContext;

/**
 * 
 * Lindbrg {@link ELResolver} implementation to integrate JSF layer with
 * lindberg IOC context beans.
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergBeanJsfResolver extends BeanELResolver {
    
    /**
     * Bean factory implementation.
     */
    private BeanFactory beanFactory;
    
    /**
     * Bean repository.
     */
    private BeanRepositoryByResponse repository;
    
    public LindbergBeanJsfResolver(){
        beanFactory = getBeanFactory();
        repository = new BeanRepositoryByResponse(beanFactory);
    }

    /**
     * Get bean instances of lindberg IOC context if the property corresponds to
     * a bean id.
     * 
     * @return bean instance or null if bean for id specified not found.
     */
    @Override
    public Object getValue(ELContext elContext, Object base, Object property) {
        if (base == null && property != null){
           ResponseBeans responseBeans = getResponseBeans();
           String idBean = property.toString(); 
           if (responseBeans.containsBean(idBean)){
              Object bean = responseBeans.getBean(idBean);
              elContext.setPropertyResolved(true);
              return bean;
           }
        }
        
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Class getType(ELContext context, Object base, Object property) {
        if (base == null && property != null)
           return beanFactory.getType(property.toString());
        
        return null;
    }
    
    public BeanFactory getBeanFactory(){
        return UserBeanContext.getInstance().getFactory();
    }
    
    /**
     * Get the {@link ResponseBeans} instance for this session and response.
     * 
     * @return {@link ResponseBeans} instance for this session and response.
     */
    public ResponseBeans getResponseBeans(){
        HttpServletResponse resp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        
        ResponseBeans responseBeans = repository.getResponseBeans(session);
        if (responseBeans != null){
           if (! responseBeans.getResponse().equals(resp)){
               responseBeans = repository.registerResponse(session, resp);
           }
           
           return responseBeans;
        }   
            
        return repository.registerResponse(session, resp);
        
    }
    
    
}
