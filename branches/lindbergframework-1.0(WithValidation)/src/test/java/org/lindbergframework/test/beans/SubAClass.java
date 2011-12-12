package org.lindbergframework.test.beans;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Bean("subA_test")
public class SubAClass extends AClass{
	
	@Inject("c_test")
	private CClass cClass;
	
	@Inject("c_test")
	private CClass cClass2;
	
	private boolean injectionCClass2OK = false;
	
	public SubAClass(){
		//
	}
	
	public void setCClass2(CClass cClass2) {
		this.cClass2 = cClass2;
		injectionCClass2OK = true;
	}
	
	public CClass getCClass2() {
		return cClass2;
	}
	
	public CClass getCClass() {
		return cClass;
	}
	
	public boolean isInjectionCClass2OK() {
		return injectionCClass2OK;
	}
	
}
