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
 * 
 * @author Victor Lindberg
 *
 */
public class AnnotationDependencyManager implements DependencyManager{
	
	private BeanFactory beanFactory;

	public AnnotationDependencyManager(){
		//
	}
	
	public AnnotationDependencyManager(BeanFactory beanFactory){
		this.beanFactory = beanFactory;
	}
	
	
	
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
	
	public Map<Field, AutoInjectField> extractAutoInjectFields(Object bean){
		Map<Field, AutoInjectField>  autoInjectFields = new HashMap<Field, AutoInjectField>(); 
	    loadAutoInjectFields(bean.getClass(),autoInjectFields);
	    return autoInjectFields;
	}
	
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
	
	public boolean containsDependecy(String idBean, Class dependecy) {
		Object bean = beanFactory.getBean(idBean);
		Map<Field, AutoInjectField>  autoInjectFields = extractAutoInjectFields(bean);
		for (AutoInjectField autoInjectField : autoInjectFields.values())
			if (autoInjectField.getField().getType().isAssignableFrom(dependecy))
				return true;
		
		return false;
	}
	
	private class AutoInjectField{
		private String id;
		private Field field;
		
		public AutoInjectField(){
			//
		}
		
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
