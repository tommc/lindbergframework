package org.lindbergframework.validation;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.ArrayUtil;
import org.lindbergframework.validation.impl.ExecutorValidationImpl;
import org.lindbergframework.validation.settings.ValidationMode;


/**
 * Interface que define um executador de validações que é responsável pelo  <br>
 * processamento das validações configuradas.
 * 
 * Veja a implementação padrão do framework que é {@link ExecutorValidationImpl}
 * 
 * @author Victor Lindberg
 *
 */
@SuppressWarnings("unchecked")
public interface IExecutorValidation {

	/**
	 * Adiciona validações de modo flexível. <br>
	 * Este método adiciona um array de {@link ValidationItem} <br>
	 * de acordo com um conjunto de {@link IValidation}. <br><br>
	 * 
	 * Neste método os {@link ValidationItem} devem ser criados utilizandos <br>
	 * construtores que recebam indexValidations que indicam com quais validações <br>
	 * o {@link ValidationItem} será validado. Os indexValidations devem ser indicado <br>
	 * levando o índice 0(zero) como o índice da primeira validação.
	 * 
	 * Exemplo, na validação abaixo usando a classe {@link ArrayUtil} do framework <br><br>
	 * 
	 *    executorValidation.addValidations(ArrayUtil.toArray(<br>
	 *			new ValidationItem("lindberg",0),<br>
	 *			new ValidationItem(new Date(),0,1)<br>
	 *			), <br>
	 *			ValidationFactory.createNotNullValidation(), --> validação de índice 0 (Zero)<br>
	 *			ValidationFactory.createDateHasBeFutureValidation()); --> validação de índice 1<br><br>
	 *
	 *    O método {@link #addValidations(ValidationItem[], IValidation...)} <br>
	 *    adiciona ao executorValidation dos validationItem onde o primeiro item <br>
	 *    item é validado usando a validação de índice zero que neste caso é<br>
	 *    ValidationFactory.createNotNullValidation() e o segundo item <br>
	 *    é validado usando duas validações de índices 0 e 1, 
	 *    ValidationFactory.createNotNullValidation() e 
	 *    ValidationFactory.createDateHasBeFutureValidation())
	 *  
	 */
	public void addValidations(ValidationItem[] items,IValidation... validacoes);
		
	/**
	 * Trabalha da mesma forma que o {@link #addValidations(ValidationItem[], IValidation...)} só que <br>
	 * já efetua a validação no modo {@link ValidationMode.THROW_FINAL}
	 */
	public void addValidationsValidating(ValidationItem[] items,IValidation... validacoes);
	
	/**
	 * Trabalha da mesma forma que o {@link #addValidations(ValidationItem[], IValidation...)} só que <br>
	 * já efetua a validação no modo que é passado como argumento para o método no parametro mode
	 */
	public void addValidationsValidating(ValidationMode mode,ValidationItem[] items,IValidation... validacoes);
	
	/**
	 * adiciona uma validação a diversos items 
	 */
	public void addValidationForSeveralItems(IValidation validacao,ValidationItem... items);
		
	/**
	 * adiciona uma validação a diversos items e <br>
	 * já efetua a validação no modo que é passado como argumento para o método no parametro mode 
	 */
	public void addValidationForSeveralItemsValidating(IValidation validacao,ValidationItem... items);
	
	/**
	 * adiciona uma validação a diversos items e <br>
	 * já efetua a validação no modo {@link ValidationMode.THROW_FINAL} 
	 */
	public void addValidationForSeveralItemsValidating(ValidationMode mode,IValidation validacao,ValidationItem... items);
	
	/**
	 * Adiciona várias validações a um item
	 */
	public void addValidationsForItem(ValidationItem item,IValidation... validacoes);
	
	/**
	 * Adiciona várias validações a um item e <br>
	 * já efetua a validação no modo {@link ValidationMode.THROW_FINAL} 
	 */
	public void addValidationsForItemValidating(ValidationItem item,IValidation... validacoes);
	
	/**
	 * Adiciona várias validações a um item e<br>
	 * já efetua a validação no modo que é passado como argumento para o método no parametro mode
	 */
	public void addValidationsForItemValidating(ValidationMode mode, ValidationItem item,IValidation... validacoes);
	
	
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
