package org.lindbergframework.validation;

import java.util.List;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.settings.MsgType;
import org.lindbergframework.validation.settings.ValidationMode;

/**
 * 
 * Interface que define um Executador ou Engine de validações. <br><br>
 * 
 *  UM executor recebe diversos itens de validação cada um associado a uma ou mais validações <br>
 *  e é responsável por gerenciar e executar o processamento adequado das validações criadas.
 *  
 *  @see Item
 *  @see ValidationMode
 *  @see MsgType
 *  @see IValidation
 *  
 * @author Victor Lindberg
 *
 */
public interface IExecutorValidation {
	
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
	
	/**
	 * 
	 * Retorna a lista de validações adicionadas ao executor
	 * @param <E>
	 * @return
	 */
	public <E> List<IValidation<E>> getValidations();

}
