package org.lindbergframework.beans.di;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.exception.BeanIdAlreadyDefinedException;
import org.lindbergframework.exception.BeanMappingNotFoundException;
import org.lindbergframework.exception.MappingFailedException;


/**
 * Bean mapper implementation for annotated classes with {@link Bean} annotation inside application class path.
 * 
 * @author Victor Lindberg
 *
 */
public class AnnotationClassPathBeanMapper implements BeanMapper{
	
    /**
     * Bean mapping. Key MAP : bean id, Value MAP: {@link BeanMapping} for bean. 
     */
	private Map<String, BeanMapping> beans;
	
	/**
	 * Basepackages array. The annotated beans will be sought in these packages and sub packages.
	 */
	private String[] basepackages;
	
	/**
	 * Create a new instance of AnnotationClassPathBeanMapper for the defined base packages.
	 * 
	 * @param basepackages base packages where the annotated beans will be sought
	 */
	public AnnotationClassPathBeanMapper(String... basepackages){
		this.basepackages = basepackages;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void map() throws MappingFailedException {
		try{
		   doMap();
		}catch(Exception ex){
			throw new MappingFailedException("Bean mapping failed",ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public BeanMapping getBeanMapping(String id) throws BeanMappingNotFoundException{
		verifyMappingState();
		BeanMapping beanMapped = beans.get(id);
		
		if (beanMapped == null)
			throw new BeanMappingNotFoundException("Bean mapping not found : "+id);
		
		return beanMapped;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int getLengthBeanMapping(){
		verifyMappingState();
		return beans.size();
	}
	
    /**
     * Checks if the mapping state is OK.
     */
	protected void verifyMappingState(){
		if (beans == null)
			throw new IllegalStateException("Mapping uninitialized. Call map method to initialize it.");
	}
	
	/**
	 * Executes the bean mapping effectively.
	 * 
	 * @throws Exception if it was not possible map the bean 
	 */
	protected void doMap()
			throws Exception {
		Map<String, BeanMapping> beans = new HashMap<String, BeanMapping>();

		List<String> classes = new ArrayList<String>();
		for (String base : basepackages)
		    classes.addAll(ClassMappingUtil.listClassesInProject(base));
		
		for (String className : classes) {
		    Class clazz;
		    
		    try{
		       clazz = Class.forName(className);
		    }catch(NoClassDefFoundError ex){
		    	continue;
		    }

			int modifiers = clazz.getModifiers();
			if (!clazz.isInterface() && !clazz.isAnnotation()
					&& !clazz.isEnum() && !Modifier.isAbstract(modifiers)) {
				Bean annotBean = (Bean) clazz.getAnnotation(Bean.class);
				
				if (annotBean != null){
					String beanId = annotBean.value(); 
					if (beans.get(beanId) == null)
					   beans.put(beanId, new BeanMapping(clazz,annotBean.singleton(),beanId));
					else
					   throw new BeanIdAlreadyDefinedException("Bean id is already defined : "+beanId);
				}
			}
		}

		this.beans = beans;
	}
	
			
}
