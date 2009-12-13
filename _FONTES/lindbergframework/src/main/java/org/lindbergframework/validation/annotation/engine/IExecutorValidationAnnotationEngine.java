package org.lindbergframework.validation.annotation.engine;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.Executor;
import org.lindbergframework.validation.settings.ValidationMode;

/**
 * Interface que define uma engine executorValidation para o processamento de annotations de validação.<br><br>
 * 
 * Um executor que implemente essa interface deve processar beans que estejam anotados com as annotations Valid e Validations
 * 
 * @author Victor Lindberg
 *
 */
public interface IExecutorValidationAnnotationEngine extends Executor{
	
	/**
	 * Executa as validações configuradas no engine adicionando os beans anotados <br>
	 * com as annotations Valid e Validations no processamento de validações 
	 */
	public void execute(Object... beansToValidate) 
	   throws ValidationException, ValidationClassCastException;
	
	/**
	 * Efetua o mesmo processamento do método {@link #execute()} só que define 
	 * o Modo de processamento de validação<br><br>
	 * 
	 * @see ValidationMode
	 */
	public void execute(ValidationMode mode,Object... beansToValidate) 
	   throws ValidationException, ValidationClassCastException;
	
	/**
	 * Adiciona novos beans anotados com as annotations Valid e Validations <br>
	 * as validações a serem processadas por este executor 
	 */
	public void addBeans(Object... objs);
	

}
