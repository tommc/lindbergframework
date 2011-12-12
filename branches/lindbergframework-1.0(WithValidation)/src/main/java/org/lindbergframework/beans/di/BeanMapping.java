package org.lindbergframework.beans.di;

/**
 * Class that defines bean mapping inside of IOC context.
 * 
 * @author Victor Lindberg
 * 
 */
public class BeanMapping {

    /**
     * bean id.
     */
	private String id;
	
	/**
	 * bean clazz.
	 */
	private Class clazz;
	
	/**
	 * true if this bean is a singleton instance and false if is not a singleton.
	 */
	private boolean singleton;

	/**
	 * Default construtor for {@link BeanMapping}.
	 */
	public BeanMapping() {
		//
	}

	/**
	 * Create a {@link BeanMapping} for clazz, singleton and id attributes defined.
	 * 
	 * @param clazz bean class.
	 * @param singleton true if the bean is a singleton and false if is not a singleton bean.
	 * @param id bean id.
	 */
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

	/**
	 * Create a new instance for the bean.
	 * 
	 * @return new bean instance.
	 * 
	 * @throws InstantiationException Could not create bean instance.
	 * @throws IllegalAccessException Could not access bean class.
	 */
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
