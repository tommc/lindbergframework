package org.lindbergframework.integration.web.jsf.el;

import javax.el.BeanELResolver;
import javax.el.ELContext;

import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.beans.di.context.UserBeanContext;
import org.lindbergframework.core.context.BeanContext;
import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.exception.BeanNotFoundException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergBeanJsfResolver extends BeanELResolver {
    
    private BeanContext beanContext;
    
    public LindbergBeanJsfResolver(){
        beanContext = UserBeanContext.getInstance();
    }

    @Override
    public Object getValue(ELContext elContext, Object base, Object property) {
        if (property != null){
           String idBean = property.toString(); 
           if (beanContext.containsBean(idBean)) 
              return beanContext.getBean(idBean);
           
           return super.getValue(elContext, base, property);
        }
        
        return null;
    }
    
    @Override
    public Class getType(ELContext context, Object base, Object property) {
        if (property != null)
           return beanContext.getFactory().getType(property.toString());
        
        return null;
    }
    

    
    
}
