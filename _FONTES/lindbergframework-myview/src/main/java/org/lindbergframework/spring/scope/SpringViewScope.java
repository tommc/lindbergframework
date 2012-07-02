package org.lindbergframework.spring.scope;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.request.FacesRequestAttributes;

/**
 * MyView scope implementation to {@link SameViewScoped}.
 * 
 * @author Victor Lindberg
 * 
 */
public class SpringViewScope implements Scope, ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	public SpringViewScope() {
		//
	}

	public static final String VIEW_SCOPE_CALLBACKS = "viewScope.callbacks";
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public synchronized Object get(String name, ObjectFactory<?> objectFactory) {
		SessionObjectFactory factory = applicationContext.getBean(SessionObjectFactory.class);
		//Object instance = getViewMap().get(name);
		FacesContext ctx = FacesContext.getCurrentInstance();
		String path = ctx.getViewRoot().getViewId();
		Object instance = FacesContext.getCurrentInstance().getViewRoot().getAttributes().get(name);
		if (instance == null) {
			instance = objectFactory.getObject();
			//getViewMap().put(name, instance);
			FacesContext.getCurrentInstance().getViewRoot().getAttributes().put(name, instance);
		}
		return instance;
	}

	public Object remove(String name) {
		Object instance = getViewMap().remove(name);
		if (instance != null) {
			Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap()
					.get(VIEW_SCOPE_CALLBACKS);
			if (callbacks != null) {
				callbacks.remove(name);
			}
		}
		return instance;
	}

	public void registerDestructionCallback(String name, Runnable runnable) {
		Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap()
				.get(VIEW_SCOPE_CALLBACKS);
		if (callbacks != null) {
			callbacks.put(name, runnable);
		}
	}

	public Object resolveContextualObject(String name) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(
				facesContext);
		return facesRequestAttributes.resolveReference(name);
	}

	public String getConversationId() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(
				facesContext);
		return facesRequestAttributes.getSessionId() + "-"
				+ facesContext.getViewRoot().getViewId();
	}

	private Map<String, Object> getViewMap() {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap();
	}

}
