package org.lindbergframework.test.beans;

import org.lindbergframework.beans.di.annotation.Bean;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Bean(value = "singletonBean", singleton = true)
public class SingletonBean {
	
	public SingletonBean(){
		//
	}

}
