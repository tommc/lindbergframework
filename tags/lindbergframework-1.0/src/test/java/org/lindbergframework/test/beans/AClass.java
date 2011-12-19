package org.lindbergframework.test.beans;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;

@Bean("a_test")
public class AClass {
	
	@Inject("b_test")
	private BClass bClass;
	
	public AClass(){
		//
	}

	public BClass getBClass() {
		return bClass;
	}

	public void setBClass(BClass bClass) {
		this.bClass = bClass;
	}
	

}
