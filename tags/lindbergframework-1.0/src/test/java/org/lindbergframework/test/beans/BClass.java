package org.lindbergframework.test.beans;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;

@Bean("b_test")
public class BClass {
	
	@Inject("c_test")
	private CClass cClass;
	
	public BClass(){
		//
	}

	public CClass getCClass() {
		return cClass;
	}

	public void setCClass(CClass cClass) {
		this.cClass = cClass;
	}
	
	

}
