package org.lindbergframework.beans.di;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.lindbergframework.beans.di.annotation.Inject;
import org.lindbergframework.beans.di.context.BeanFactory;
import org.lindbergframework.exception.InjectionFailedException;
import org.lindbergframework.util.ReflectionUtil;
import org.springframework.util.ReflectionUtils;



/**
 * DependencyManager Implementation for to manage dependecies by annotation {@link Inject}.
 *  
 * @author Victor Lindberg
 *
 */
public class AnnotationDependencyManager implements DependencyManager{
	
    /**
     * Bean factory for to get bean instances.
     */
	private BeanFactory beanFactory;

	/**
	 * Default constructor for AnnotationDependencyManager.
	 */
	public AnnotationDependencyManager(){
		//
	}
	
	/**
	 * AnnotationDependencyManager constructor for a bean factory defined.
	 *  
	 * @param beanFactory bean factory for to get bean instances.
	 */
	public AnnotationDependencyManager(BeanFactory beanFactory){
		this.beanFactory = beanFactory;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public <E> E resolveDependecies(E bean) throws InjectionFailedException {
		Map<Field, AutoInjectField>  autoInjectFields = extractAutoInjectFields(bean); 
		
		for (AutoInjectField autoInjectField : autoInjectFields.values()){
			Object dependencyBean = beanFactory.getBean(autoInjectField.getId());
			Field field = autoInjectField.getField();
			ReflectionUtils.makeAccessible(field);
			
			try{
				ReflectionUtil.setFieldValue(field, bean,dependencyBean,true);
			}catch(Exception ex){
				throw new InjectionFailedException("Injection failed",ex);
			}
		}
		
		return bean;
	};
	
	/**
	 * Extract a map with the annotated fields with {@link Inject} annotation in the bean.
	 * 
	 * @param bean bean for the extraction.
	 * 
	 * @return map with annotated fields with {@link Inject} annotation.
	 */
	public Map<Field, AutoInjectField> extractAutoInjectFields(Object bean){
		Map<Field, AutoInjectField>  autoInjectFields = new HashMap<Field, AutoInjectField>(); 
	    loadAutoInjectFields(bean.getClass(),autoInjectFields);
	    return autoInjectFields;
	}
	
	/**
	 * Load in the map  all annotated fields with {@link Inject} annotation in the beanClazz argument.
	 * 
	 * @param beanClazz class for to do extraction of annotated fields.
	 * 
	 * @param autoInjectFieldsList map for load annotated fields.
	 */
	public void loadAutoInjectFields(Class beanClazz, Map<Field, AutoInjectField> autoInjectFieldsList){
		if (beanClazz == Object.class)
			return;
		
		Field[] fields = beanClazz.getDeclaredFields();
		for (Field field : fields){
			Inject inject = field.getAnnotation(Inject.class);
			if (inject != null){
				String id = inject.value();
				if (! autoInjectFieldsList.containsKey(field))
				   autoInjectFieldsList.put(field,new AutoInjectField(id,field));
			}
		}
		
		loadAutoInjectFields(beanClazz.getSuperclass(), autoInjectFieldsList);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean containsDependecy(String idBean, Class dependecy) {
		Object bean = beanFactory.getBean(idBean);
		Map<Field, AutoInjectField>  autoInjectFields = extractAutoInjectFields(bean);
		for (AutoInjectField autoInjectField : autoInjectFields.values())
			if (autoInjectField.getField().getType().isAssignableFrom(dependecy))
				return true;
		
		return false;
	}
	
	/**
	 * private Class for encapsulates the field and the bean id for the annotated field.
	 *   
	 * @author Victor Lindberg
	 *
	 */
	private class AutoInjectField{
	    
	    /**
	     * bean id. 
	     */
		private String id;
		
		/**
		 * annotated field.
		 */
		private Field field;
		
		/**
		 * Default constructor for {@link AutoInjectField}
		 */
		public AutoInjectField(){
			//
		}
		
		/**
		 * Create a {@link AutoInjectField} for id and field defined.
		 * 
		 * @param id bean id.
		 * @param field annotated field.
		 */
		public AutoInjectField(String id, Field field){
			setId(id);
			setField(field);
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Field getField() {
			return field;
		}

		public void setField(Field field) {
			this.field = field;
		}
		
	}
	
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
}
