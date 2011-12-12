package org.lindbergframework.validation;

import org.lindbergframework.util.ArrayUtil;
import org.lindbergframework.validation.executors.ExecutorValidationItemsImpl;
import org.lindbergframework.validation.settings.ValidationMode;


/**
 * Interface que define um executador de validações que é responsável pelo  <br>
 * processamento das validações configuradas a partir de objetos {@link Item}.
 * 
 * Veja a implementação padrão do framework que é {@link ExecutorValidationItemsImpl}
 * 
 * @author Victor Lindberg
 *
 */
@SuppressWarnings("unchecked")
public interface IExecutorValidationItems extends IExecutorValidation{

	/**
	 * Adiciona validações de modo flexível. <br>
	 * Este método adiciona um array de {@link Item} <br>
	 * de acordo com um conjunto de {@link IValidation}. <br><br>
	 * 
	 * Neste método os {@link Item} devem ser criados utilizandos <br>
	 * construtores que recebam indexValidations que indicam com quais validações <br>
	 * o {@link Item} será validado. Os indexValidations devem ser indicado <br>
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
	 *    O método {@link #addValidations(Item[], IValidation...)} <br>
	 *    adiciona ao executorValidation dos validationItem onde o primeiro item <br>
	 *    item á validado usando a validação de índice zero que neste caso é<br>
	 *    ValidationFactory.createNotNullValidation() e o segundo item <br>
	 *    é validado usando duas validações de índices 0 e 1, 
	 *    ValidationFactory.createNotNullValidation() e 
	 *    ValidationFactory.createDateHasBeFutureValidation())
	 *  
	 */
	public void addValidations(Item[] items,IValidation... validacoes);
		
	/**
	 * Trabalha da mesma forma que o {@link #addValidations(Item[], IValidation...)} só que <br>
	 * já efetua a validações no modo {@link ValidationMode.THROW_FINAL}
	 */
	public void addValidationsValidating(Item[] items,IValidation... validacoes);
	
	/**
	 * Trabalha da mesma forma que o {@link #addValidations(Item[], IValidation...)} só que <br>
	 * já efetua a validação no modo que é passado como argumento para o método no parametro mode
	 */
	public void addValidationsValidating(ValidationMode mode,Item[] items,IValidation... validacoes);
	
	/**
	 * adiciona uma validação a diversos items 
	 */
	public void addValidationForSeveralItems(IValidation validacao,Item... items);
		
	/**
	 * adiciona uma validação a diversos items e <br>
	 * já efetua a validação no modo que é passado como argumento para o método no parametro mode 
	 */
	public void addValidationForSeveralItemsValidating(IValidation validacao,Item... items);
	
	/**
	 * adiciona uma validação a diversos items e <br>
	 * já efetua a validação no modo {@link ValidationMode.THROW_FINAL} 
	 */
	public void addValidationForSeveralItemsValidating(ValidationMode mode,IValidation validacao,Item... items);
	
	/**
	 * Adiciona várias validações a um item
	 */
	public void addValidationsForItem(Item item,IValidation... validacoes);
	
	/**
	 * Adiciona várias validações a um item e <br>
	 * já efetua a validação no modo {@link ValidationMode.THROW_FINAL} 
	 */
	public void addValidationsForItemValidating(Item item,IValidation... validacoes);
	
	/**
	 * Adiciona várias validações a um item e<br>
	 * já efetua a validação no modo que é passado como argumento para o método no parametro mode
	 */
	public void addValidationsForItemValidating(ValidationMode mode, Item item,IValidation... validacoes);
	
	
}
