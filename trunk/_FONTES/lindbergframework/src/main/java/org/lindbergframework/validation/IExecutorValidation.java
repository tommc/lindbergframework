package org.lindbergframework.validation;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.ArrayUtil;
import org.lindbergframework.validation.impl.ExecutorValidationImpl;
import org.lindbergframework.validation.settings.ValidationMode;


/**
 * Interface que define um executador de valida��es que � respons�vel pelo  <br>
 * processamento das valida��es configuradas.
 * 
 * Veja a implementa��o padr�o do framework que � {@link ExecutorValidationImpl}
 * 
 * @author Victor Lindberg
 *
 */
@SuppressWarnings("unchecked")
public interface IExecutorValidation {

	/**
	 * Adiciona valida��es de modo flex�vel. <br>
	 * Este m�todo adiciona um array de {@link ValidationItem} <br>
	 * de acordo com um conjunto de {@link IValidation}. <br><br>
	 * 
	 * Neste m�todo os {@link ValidationItem} devem ser criados utilizandos <br>
	 * construtores que recebam indexValidations que indicam com quais valida��es <br>
	 * o {@link ValidationItem} ser� validado. Os indexValidations devem ser indicado <br>
	 * levando o �ndice 0(zero) como o �ndice da primeira valida��o.
	 * 
	 * Exemplo, na valida��o abaixo usando a classe {@link ArrayUtil} do framework <br><br>
	 * 
	 *    executorValidation.addValidations(ArrayUtil.toArray(<br>
	 *			new ValidationItem("lindberg",0),<br>
	 *			new ValidationItem(new Date(),0,1)<br>
	 *			), <br>
	 *			ValidationFactory.createNotNullValidation(), --> valida��o de �ndice 0 (Zero)<br>
	 *			ValidationFactory.createDateHasBeFutureValidation()); --> valida��o de �ndice 1<br><br>
	 *
	 *    O m�todo {@link #addValidations(ValidationItem[], IValidation...)} <br>
	 *    adiciona ao executorValidation dos validationItem onde o primeiro item <br>
	 *    item � validado usando a valida��o de �ndice zero que neste caso �<br>
	 *    ValidationFactory.createNotNullValidation() e o segundo item <br>
	 *    � validado usando duas valida��es de �ndices 0 e 1, 
	 *    ValidationFactory.createNotNullValidation() e 
	 *    ValidationFactory.createDateHasBeFutureValidation())
	 *  
	 */
	public void addValidations(ValidationItem[] items,IValidation... validacoes);
		
	/**
	 * Trabalha da mesma forma que o {@link #addValidations(ValidationItem[], IValidation...)} s� que <br>
	 * j� efetua a valida��o no modo {@link ValidationMode.THROW_FINAL}
	 */
	public void addValidationsValidating(ValidationItem[] items,IValidation... validacoes);
	
	/**
	 * Trabalha da mesma forma que o {@link #addValidations(ValidationItem[], IValidation...)} s� que <br>
	 * j� efetua a valida��o no modo que � passado como argumento para o m�todo no parametro mode
	 */
	public void addValidationsValidating(ValidationMode mode,ValidationItem[] items,IValidation... validacoes);
	
	/**
	 * adiciona uma valida��o a diversos items 
	 */
	public void addValidationForSeveralItems(IValidation validacao,ValidationItem... items);
		
	/**
	 * adiciona uma valida��o a diversos items e <br>
	 * j� efetua a valida��o no modo que � passado como argumento para o m�todo no parametro mode 
	 */
	public void addValidationForSeveralItemsValidating(IValidation validacao,ValidationItem... items);
	
	/**
	 * adiciona uma valida��o a diversos items e <br>
	 * j� efetua a valida��o no modo {@link ValidationMode.THROW_FINAL} 
	 */
	public void addValidationForSeveralItemsValidating(ValidationMode mode,IValidation validacao,ValidationItem... items);
	
	/**
	 * Adiciona v�rias valida��es a um item
	 */
	public void addValidationsForItem(ValidationItem item,IValidation... validacoes);
	
	/**
	 * Adiciona v�rias valida��es a um item e <br>
	 * j� efetua a valida��o no modo {@link ValidationMode.THROW_FINAL} 
	 */
	public void addValidationsForItemValidating(ValidationItem item,IValidation... validacoes);
	
	/**
	 * Adiciona v�rias valida��es a um item e<br>
	 * j� efetua a valida��o no modo que � passado como argumento para o m�todo no parametro mode
	 */
	public void addValidationsForItemValidating(ValidationMode mode, ValidationItem item,IValidation... validacoes);
	
	
	/**
	 * Executa as valida��es no modo padr�o {@link ValidationMode.THROW_FINAL} 
	 */
	public void execute() 
	throws ValidationException, ValidationClassCastException;
	
	/**
	 * Executa as valida��es configuradas no ExecutorValidation usando o modo de valida��o passado por argumento <br>
	 *  no parametro mode
	 */
	public void execute(ValidationMode mode) 
	                     throws ValidationException, ValidationClassCastException;
	
	
	/**
	 * Executa as valida��es no modo padr�o {@link ValidationMode.THROW_FINAL} s� que configurando o separador <br>
	 * das mensagens das valida��es 
	 */
	public void execute(String separatorMessages) throws ValidationException,ValidationClassCastException;
	
	/**
	 * Limpa as valida��es do executorValidation 
	 */
	public void clearValidations();

	/**
	 * Reinicia o estado e configura��es feitas no executorValidation
	 */
	public void reset();
	
}
