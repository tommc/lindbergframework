package org.lindbergframework.test.beans;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Bean(value = "singleton_test_bean", singleton = true)
public class SingletonTestBean extends AClass{

	@Inject("singletonBean")
	private SingletonBean singletonBean1;
	
	@Inject("singletonBean")
	private SingletonBean singletonBean2;
	
	public SingletonTestBean(){
		//
	}

	public SingletonBean getSingletonBean1() {
		return singletonBean1;
	}

	public void setSingletonBean1(SingletonBean singletonBean1) {
		this.singletonBean1 = singletonBean1;
	}

	public SingletonBean getSingletonBean2() {
		return singletonBean2;
	}

	public void setSingletonBean2(SingletonBean singletonBean2) {
		this.singletonBean2 = singletonBean2;
	}

		

}
