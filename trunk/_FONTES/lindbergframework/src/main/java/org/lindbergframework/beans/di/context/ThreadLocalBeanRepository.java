package org.lindbergframework.beans.di.context;

import java.util.HashMap;
import java.util.Map;

import org.lindbergframework.exception.BeanNotFoundException;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ThreadLocalBeanRepository {
    
    private static ThreadLocal<Map<String, Object>> threadBeanCache = new ThreadLocal<Map<String, Object>>();
    private BeanFactory beanFactory;
    
    public ThreadLocalBeanRepository(BeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }
    
    public <E> E getBean(String id) throws BeanNotFoundException {
       Map<String, Object> cache = getCache();
       if (! isCacheActive()){
           cache = new HashMap<String, Object>();
           threadBeanCache.set(cache);
       }
       
       E bean = getBeanFromCache(id);
       
       if (bean == null){
          bean = beanFactory.getBean(id);
          cache.put(id, bean);
       }
       
       return bean;
    }
    
    public boolean containsBean(String id){
        return containsCacheForBean(id) || beanFactory.containsBean(id);
    }
    
    public Map<String, Object> getCache(){
        return threadBeanCache.get();
    }
    
    public boolean isCacheActive(){
        return getCache() != null;
    }
    
    public boolean containsCacheForBean(String id){
        return isCacheActive() && getCache().get(id) != null;
    }
    
    public <E> E getBeanFromCache(String id){
        if (isCacheActive())
            return (E) getCache().get(id);
        
        return null;
    }
    
}
