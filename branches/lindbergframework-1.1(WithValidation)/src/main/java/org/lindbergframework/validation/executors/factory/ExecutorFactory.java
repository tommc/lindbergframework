package org.lindbergframework.validation.executors.factory;

import org.lindbergframework.validation.IExecutorValidation;
import org.lindbergframework.validation.IExecutorValidationItems;
import org.lindbergframework.validation.Item;
import org.lindbergframework.validation.annotation.engine.IExecutorAnnotationEngine;
import org.lindbergframework.validation.context.LindbergSpringValidationsBeanFactory;

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
	
	public static final String EXECUTOR_VALIDATION_ITEM_MULTTHREAD_ID_BEAN = "executorValidationMultThread";
	public static final String EXECUTOR_VALIDATION_ITEM_ID_BEAN = "executorValidationDefault";
	public static final String EXECUTOR_ANNOTATION_ENGINE_ID_BEAN = "executorAnnotationEngineDefault";
	public static final String EXECUTOR_ANNOTATION_ENGINE_MULTTHREAD_ID_BEAN = "executorAnnotationEngineMultThread";
		
	/**
	 * Cria um {@link IExecutorValidationItems} padrão
	 */
	public static IExecutorValidationItems newExecutorValidationItems() {
		return springFactory.getBean(EXECUTOR_VALIDATION_ITEM_ID_BEAN);
	}
	
	/**
	 * Cria um {@link IExecutorValidationItems} para o tratamento de validações definidas a partir <br>
	 * de objetos {@link Item} em multiplas threads
	 */
	public static IExecutorValidationItems newExecutorValidationItemsMultThread() {
		return springFactory.getBean(EXECUTOR_VALIDATION_ITEM_MULTTHREAD_ID_BEAN);
	}
	
	/**
	 * Cria um {@link IExecutorAnnotationEngine} para o tratamento de validações utilizando annotations
	 */
	public static IExecutorAnnotationEngine newExecutorAnnotationEngine() {
		return springFactory.getBean(EXECUTOR_ANNOTATION_ENGINE_ID_BEAN);
	}
	
	/**
	 * Cria um {@link IExecutorAnnotationEngine} para o tratamento de validações em beans anotados em multiplas threads
	 */
	public static IExecutorAnnotationEngine newExecutorAnnotationEngineMultThread() {
		return springFactory.getBean(EXECUTOR_ANNOTATION_ENGINE_MULTTHREAD_ID_BEAN);
	}

}
