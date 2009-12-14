package org.lindbergframework.validation.executors.factory;

import org.lindbergframework.spring.LindbergSpringValidationsBeanFactory;
import org.lindbergframework.validation.IExecutorValidation;
import org.lindbergframework.validation.IExecutorValidationItems;
import org.lindbergframework.validation.Item;
import org.lindbergframework.validation.annotation.engine.IExecutorAnnotationEngine;

/**
 * Fábrica padrão de {@link IExecutorValidation}. <br><br>
 * 
 * Fábrica obtém instancias dos executors atravpes do contexto do spring em {@link LindbergSpringValidationsBeanFactory}
 * 
 * @author Victor Lindberg
 *
 */
public class ExecutorFactory {
	
    private static LindbergSpringValidationsBeanFactory springFactory = LindbergSpringValidationsBeanFactory.getInstance();
	
	public static final String EXECUTOR_VALIDATION_MULT_THREAD_ID_BEAN = "executorValidationMultThread";
	public static final String EXECUTOR_VALIDATION_ID_BEAN = "executorValidationDefault";
	public static final String EXECUTOR_VALIDATION_ANNOTATION_ENGINE_ID_BEAN = "executorAnnotationEngineDefault";
	
	/**
	 * Cria um {@link IExecutorValidationItems} padrão
	 */
	public static IExecutorValidationItems newExecutorValidationItems() {
		return springFactory.getBean(EXECUTOR_VALIDATION_ID_BEAN);
	}
	
	/**
	 * Cria um {@link IExecutorValidationItems} para o tratamento de validações definidas a partir <br>
	 * de objetos {@link Item} em multiplas threads
	 */
	public static IExecutorValidationItems newExecutorValidationMultThread() {
		return springFactory.getBean(EXECUTOR_VALIDATION_MULT_THREAD_ID_BEAN);
	}
	
	/**
	 * Cria um {@link IExecutorAnnotationEngine} para o tratamento de validações utilizando annotations
	 */
	public static IExecutorAnnotationEngine newExecutorAnnotationEngine() {
		return springFactory.getBean(EXECUTOR_VALIDATION_ANNOTATION_ENGINE_ID_BEAN);
	}

}
