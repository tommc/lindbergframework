package org.lindbergframework.validation.executors;

import org.lindbergframework.validation.annotation.engine.IExecutorAnnotationEngine;
import org.lindbergframework.validation.executors.factory.ExecutorFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Component("executorAnnotationEngineMultThread")
@Scope("prototype")
public class ExecutorAnnotationEngineMultThread extends ExecutorAnnotationEngineImpl 
                   implements IExecutorAnnotationEngine{
	
	public ExecutorAnnotationEngineMultThread(){
		super(ExecutorFactory.newExecutorValidationItemsMultThread());
	}
	
	

}
