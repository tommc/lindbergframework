package org.lindbergframework.spring.scope;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;


/**
 *
 * @author Victor Lindberg
 *
 */
public class SessionObjectFactory {
	
	private Map<String, Object> viewBeans = new HashMap<String, Object>();
	
	private String currentPage;

	public SessionObjectFactory() {
		//
	}
	
	public synchronized Object get(String requestPage, String name, ObjectFactory<?> objectFactory) {
		checkPage(requestPage);
		Object instance = viewBeans.get(name);
		if (instance == null){
			instance = objectFactory.getObject();
			viewBeans.put(name, instance);
		}
		
		return instance;
	}
	
	public synchronized Object remove(String name) {
		Object instance = viewBeans.get(name);
		return instance;
	}
	
	
	public void checkPage(String page){
		if (page != null &&
			! page.equals(currentPage)){
			currentPage = page;
			viewBeans.clear();
		}
	}
}
