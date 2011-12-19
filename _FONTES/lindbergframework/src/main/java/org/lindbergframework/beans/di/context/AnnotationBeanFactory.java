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
 * Bean factory implementation for beans annotated with @Bean annotation.
 *  
 * @author Victor Lindberg
 *
 */
public class AnnotationBeanFactory extends AbstractBeanFactory{
	
    /**
     * Repository for singleton beans instances.
     */
	private Map<String, Object> singletonBeansInstances = new HashMap<String, Object>();
	
	public AnnotationBeanFactory(){
	    //
	}
	
	/**
	 * Creates a AnnotationBeanFactory with the bean basePackages defined.
	 * 
	 * @param basePackages bean basepackage.
	 */
	public AnnotationBeanFactory(String... basePackages){
		loadBasepackage(basePackages);
	}
	
	/**
	 * Creates a AnnotationBeanFactory with the bean mapper defines.
	 * 
	 * @param beanMapper bean mapper implementation.
	 */
	public AnnotationBeanFactory(BeanMapper beanMapper){
	   loadBeanMapper(beanMapper);	
	}
	
	/**
	 * Creates a AnnotationBeanFactory with the bean mapper and dependency manager implementation defined.
	 * 
	 * @param beanMapper bean mapper implementation.
	 * @param dependencyManager dependency manager implementation.
	 */
	public AnnotationBeanFactory(BeanMapper beanMapper, DependencyManager dependencyManager){
		super(beanMapper,dependencyManager);
		beanMapper.map();
	}
	
	/**
	 * Configures the bean mapper implementation.
	 * 
	 * @param beanMapper bean mapper implementation.
	 */
	private void loadBeanMapper(BeanMapper beanMapper){
	    setBeanMapper(beanMapper);
        setDependencyManager(new AnnotationDependencyManager(this));
        beanMapper.map();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void loadBasepackage(String... basePackages) {
	    loadBeanMapper(new AnnotationClassPathBeanMapper(basePackages));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public <E> E getBean(String id, Object... args) throws BeanNotFoundException {
	    verifyBeanMapper();
	    
		BeanMapping beanMapping = getBeanMapper().getBeanMapping(id);

		if (beanMapping == null)
			throw new BeanNotFoundException("Bean not found : " + id);

		try {
			if (beanMapping.isSingleton())
				return (E) getSingleton(beanMapping,args);
			else {

				return (E) createInstance(beanMapping.getClazz(),args);
			}

		} catch (Exception ex) {
			throw new BeanException("Error getting bean : "+id, ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean containsBean(String id) {
	    verifyBeanMapper();
	    
		try{
			BeanMapping beanMapping = getBeanMapper().getBeanMapping(id);
			
			return beanMapping != null;
		}catch(BeanNotFoundException ex){
		   return false;	
		}
	}

	
	/**
	 * {@inheritDoc}
	 */
	public Class getType(String id) throws BeanNotFoundException {
		Object bean = getBean(id);
		return bean.getClass();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isSingleton(String id) throws BeanNotFoundException {
	    verifyBeanMapper();
	    
		return getBeanMapper().getBeanMapping(id).isSingleton();
	}

	/**
	 * Creates a bean instance from class argument using args argument in the bean constructor.
	 * 
	 * @param <E> bean type.
	 * @param clazz bean class.
	 * @param args constructor argument bean.
	 * @return bean instance.
	 * @throws InstantiationException instantiation failed.
	 * @throws IllegalAccessException class access failed.
	 * @throws NoSuchMethodException auto injection failed.
	 * @throws InvocationTargetException contructor or method (auto injection setters) failed.
	 */
	protected <E> E createInstance(Class clazz,Object... args) 
	                throws InstantiationException, IllegalAccessException, 
	                       NoSuchMethodException, InvocationTargetException{
	   E bean;
	   if (isTransactionContext(clazz))
		  bean = (E) TransactionUtil.createTransactionProxy(clazz,args);
	   else
	      bean = (E) BeanUtil.createInstance(clazz, args);
	   
	   return getDependencyManager().resolveDependecies(bean);
	}
	
	/**
	 * Checks transactional context of bean class. 
	 * @param clazz bean class.
	 * @return true if the bean class contains {@link Transax} annotation in the class or method scope.
	 */
	protected boolean isTransactionContext(Class clazz){
		if (clazz.getAnnotation(Transax.class) != null)//
			return true;
		
		for (Method method : clazz.getMethods()){
			if (method.getAnnotation(Transax.class) != null)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Get a singleton bean instance.
	 * 
	 * @param <E> bean type.
	 * @param bm bean mapping.
	 * @param args bean constructor args.
	 * @return bean instance.
	 * @throws InstantiationException instantiation failed.
     * @throws IllegalAccessException class access failed.
     * @throws NoSuchMethodException auto injection failed.
     * @throws InvocationTargetException contructor or method (auto injection setters) failed.
	 */
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
	
	/**
	 * Checks if bean mapper implementation was configured.
	 */
	private void verifyBeanMapper(){
	    if (getBeanMapper() == null)
	        throw new FactoryException("Bean mapper or DIBasepackage in bean factory: "+this+" is not defined");
	}
	
	
}
