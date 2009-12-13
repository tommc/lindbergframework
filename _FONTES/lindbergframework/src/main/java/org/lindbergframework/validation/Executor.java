package org.lindbergframework.validation;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.settings.ValidationMode;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface Executor {
	
	/**
	 * Executa as validações no modo padrão {@link ValidationMode.THROW_FINAL} 
	 */
	public void execute() 
	throws ValidationException, ValidationClassCastException;
	
	/**
	 * Executa as validações configuradas no ExecutorValidation usando o modo de validação passado por argumento <br>
	 *  no parametro mode
	 */
	public void execute(ValidationMode mode) 
	                     throws ValidationException, ValidationClassCastException;
	
	
	/**
	 * Executa as validações no modo padrão {@link ValidationMode.THROW_FINAL} só que configurando o separador <br>
	 * das mensagens das validações 
	 */
	public void execute(String separatorMessages) throws ValidationException,ValidationClassCastException;
	
	/**
	 * Limpa as validações do executorValidation 
	 */
	public void clearValidations();

	/**
	 * Reinicia o estado e configurações feitas no executorValidation
	 */
	public void reset();

}
