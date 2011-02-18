package org.lindbergframework.validation.annotation.engine;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IExecutorValidation;
import org.lindbergframework.validation.IValidation;
import org.lindbergframework.validation.Item;
import org.lindbergframework.validation.impl.StringMaxMinLengthValidation;
import org.lindbergframework.validation.settings.ValidationMode;

/**
 * Interface que define uma engine executorValidation para o processamento de annotations de validação.<br><br>
 * 
 * Um executor que implemente essa interface deve processar beans que estejam anotados com as annotations Valid e Validations
 * 
 * @author Victor Lindberg
 *
 */
public interface IExecutorAnnotationEngine extends IExecutorValidation{
	
	/**
	 * Executa as validações configuradas no engine adicionando os beans anotados <br>
	 * com as annotations Valid e Validations no processamento de validações
	 * 
	 * @param beansToValidate beans anotados que receberão processamento
	 * @throws ValidationException
	 * @throws ValidationClassCastException
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
	 * Executa as validações definidas nos beans anotados que foram adicionados ao engine que tenham annotation definidas para serem <br>
	 * processadas em ao menos 1 das ações definidas como parametro deste método
	 *  
	 * @param actions ações indicarão quais validações serão processadas
	 * @throws ValidationException
	 * @throws ValidationClassCastException
	 */
	public void executeInActions(String... actions) 
	   throws ValidationException, ValidationClassCastException;
	
	/**
	 * Executa as validações definidas nos beans anotados que tenham annotation definidas para serem <br>
	 * processadas em ao menos 1 das ações definidas como parametro deste método
	 *  
	 * @param actions ações indicarão quais validações serão processadas
	 * @param beansToValidate beans anotados que receberão processamento
	 * @throws ValidationException
	 * @throws ValidationClassCastException
	 */
	public void executeInActions(String[] actions, Object... beansToValidate) 
	   throws ValidationException, ValidationClassCastException;
	
	/**
	 * Efetua o mesmo processamento do método {@link #executeInActions(String[], Object)} só que define 
	 * o Modo de processamento de validação<br><br>
	 * 
	 * @see ValidationMode
	 */
	public void executeInActions(ValidationMode mode,String[] actions, Object... beansToValidate) 
	   throws ValidationException, ValidationClassCastException;
	
	
	/**
	 * Adiciona novos beans anotados com as annotations Valid e Validations <br>
	 * as validações a serem processadas por este executor 
	 */
	public void addBeans(Object... objs);

	/**
	 * Método que adicina um item de validação direto sem o uso da leitura de anotações. <br><br>
	 * 
	 * Esse método é uma alternativa para as validações de beans anotados que precisam fazer uso de alguma <br>
	 * validação que foge do padrão, por exemplo: a definição de parametros como o máximo de caracteres de uma <br>
	 * string (validação {@link StringMaxMinLengthValidation}) a ser validada em umavalidação não é possível via annotation então pode-se mesmo usando a validação via annotations <br>
	 * a adição de items de forma direta junto com os beans anotados.
	 *  
	 * @param item item configurado diretamente a ser validado
	 * @param validation validação a ser usada para validar o item
	 * @param actions açoes ao qual se aplicam essa validação
	 */
	public void addItem(Item item, IValidation validation,String... actions);
	

}
