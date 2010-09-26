package org.lindbergframework.beans.di;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class BeanMapping {

	private String id;
	private Class clazz;
	private boolean singleton;

	public BeanMapping() {
		//
	}

	public BeanMapping(Class clazz, boolean singleton, String id) {
		this.clazz = clazz;
		this.singleton = singleton;
		this.id = id;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public boolean isSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	public Object newInstance() throws InstantiationException,
			IllegalAccessException {
		return getClazz().newInstance();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
