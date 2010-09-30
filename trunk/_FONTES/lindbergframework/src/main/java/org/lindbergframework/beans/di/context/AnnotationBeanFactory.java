package org.lindbergframework.beans.di.context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.lindbergframework.beans.di.AnnotationClassPathBeanMapper;
import org.lindbergframework.beans.di.AnnotationDependencyManager;
import org.lindbergframework.beans.di.BeanMapper;
import org.lindbergframework.beans.di.BeanMapping;
import org.lindbergframework.beans.di.DependencyManager;
import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.exception.BeanException;
import org.lindbergframework.exception.BeanNotFoundException;
import org.lindbergframework.exception.FactoryException;
import org.lindbergframework.persistence.transaction.annotation.Transax;
import org.lindbergframework.persistence.util.TransactionUtil;


/**
 * 
 * @author Victor Lindberg
 *
 */
public class AnnotationBeanFactory extends AbstractBeanFactory{
	
	private Map<String, Object> singletonBeansInstances = new HashMap<String, Object>();
	
	public AnnotationBeanFactory(){
	    //
	}
	
	public AnnotationBeanFactory(String... basePackages){
		loadBasepackage(basePackages);
	}
	
	public AnnotationBeanFactory(BeanMapper beanMapper){
	   loadBeanMapper(beanMapper);	
	}
	
	public AnnotationBeanFactory(BeanMapper beanMapper, DependencyManager dependencyManager){
		super(beanMapper,dependencyManager);
		beanMapper.map();
	}
	
	private void loadBeanMapper(BeanMapper beanMapper){
	    setBeanMapper(beanMapper);
        setDependencyManager(new AnnotationDependencyManager(this));
        beanMapper.map();
	}
	
	public void loadBasepackage(String... basePackages) {
	    loadBeanMapper(new AnnotationClassPathBeanMapper(basePackages));
	}
	
	public <E> E getBean(String id) throws BeanNotFoundException{
		return getBean(id,new Object[] {});
	}
	
	public <E> E getBean(String id, Object[] args) throws BeanNotFoundException {
	    verifyBeanMapper();
	    
		BeanMapping beanMapping = getBeanMapper().getBeanMapping(id);

		if (beanMapping == null)
			throw new BeanNotFoundException("Bean not found : " + id);

		try {
			if (beanMapping.isSingleton())
				return getSingleton(beanMapping,args);
			else {

				return createInstance(beanMapping.getClazz(),args);
			}

		} catch (Exception ex) {
			throw new BeanException("Error getting bean : "+id, ex);
		}
	}
	
	public boolean containsBean(String id) {
	    verifyBeanMapper();
	    
		try{
			BeanMapping beanMapping = getBeanMapper().getBeanMapping(id);
			
			return beanMapping != null;
		}catch(BeanNotFoundException ex){
		   return false;	
		}
	}
	
	public Class getType(String id) throws BeanNotFoundException {
		return getBean(id).getClass();
	}
	
	public boolean isSingleton(String id) throws BeanNotFoundException {
	    verifyBeanMapper();
	    
		return getBeanMapper().getBeanMapping(id).isSingleton();
	}
	
	protected <E> E createInstance(Class clazz,Object... args) 
	                throws InstantiationException, IllegalAccessException, 
	                       NoSuchMethodException, InvocationTargetException{
	   E bean;
	   if (isTransactionContext(clazz))
		  bean = TransactionUtil.createTransactionProxy(clazz,args);
	   else
	      bean = (E) BeanUtil.createInstance(clazz, args);
	   
	   return getDependencyManager().resolveDependecies(bean);
	}
	
	protected boolean isTransactionContext(Class clazz){
		if (clazz.getAnnotation(Transax.class) != null)//
			return true;
		
		for (Method method : clazz.getMethods()){
			if (method.getAnnotation(Transax.class) != null)
				return true;
		}
		
		return false;
	}
	
	protected <E> E getSingleton(BeanMapping bm,Object... args) 
	                            throws InstantiationException, IllegalAccessException,
	                                   NoSuchMethodException, InvocationTargetException{
		String id = bm.getId();
		Object obj = singletonBeansInstances.get(id);
		
		if (obj == null){
			obj = createInstance(bm.getClazz(),args);
			singletonBeansInstances.put(id, obj);
		}
			
		return (E) obj;
	}
	
	private void verifyBeanMapper(){
	    if (getBeanMapper() == null)
	        throw new FactoryException("Bean mapper or DIBasepackage in bean factory: "+this+" is not defined");
	}
	
	
}
