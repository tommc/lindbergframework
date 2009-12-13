package org.lindbergframework.validation.annotation.engine;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.Executor;
import org.lindbergframework.validation.settings.ValidationMode;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface IExecutorValidationAnnotationEngine extends Executor{
	
	public void execute(Object... beansToValidate) 
	   throws ValidationException, ValidationClassCastException;
	
	public void execute(ValidationMode mode,Object... beansToValidate) 
	   throws ValidationException, ValidationClassCastException;
	
	public void addBeans(Object... objs);
	

}
