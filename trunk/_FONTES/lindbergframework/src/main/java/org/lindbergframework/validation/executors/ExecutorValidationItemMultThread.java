package org.lindbergframework.validation.executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.lindbergframework.validation.IExecutorValidationItems;
import org.lindbergframework.validation.Item;
import org.lindbergframework.validation.settings.ValidationMode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * Implementação de {@link IExecutorValidationItems} que efetua o processamento das validações definidas a partir de objetos {@link Item}<br>
 * em várias threads. Cada validação roda em uma thread a parte.<br><br>
 * 
 * Esse executor é recomendado nos casos em que as validações demandam uma maior quantidade de processamento cada <br>
 * e/ou o volume de validações a ser processado demanda uma quantidade que excede o normal de processamento.<br><br>
 * 
 * Para  as validações comuns como notnnul, requiredField, etc...  a implementação padrão do {@link IExecutorValidationItems} <br>
 * que pode ser obtida atraves do método ValidationFactory.createExecutorValidation é recomendada. <br><br>
 * 
 * Validações com processamento de regras matemáticas mais complexas e/ou que fazem consultas a banco de dados são <br>
 * são exemplos de validações candidatas a serem processadas por um {@link ExecutorValidationItemMultThread} 
 * 
 * @author Victor Lindberg
 *
 */
@SuppressWarnings("unchecked")
@Component("executorValidationMultThread")
@Scope("prototype")
public class ExecutorValidationItemMultThread extends ExecutorValidationItemsImpl implements IExecutorValidationItems{
	
	public ExecutorValidationItemMultThread(){
		//
	}
	
	@Override
	protected void startValidationProcess(List<ValidationElement> validElements,
			ValidationMode mode, List<String> mensagensValidacao) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int indexValidacao = 0;indexValidacao < validElements.size();indexValidacao++)
			startThread(validElements.get(indexValidacao), mode, indexValidacao, mensagensValidacao, executorService);
		
		executorService.shutdown();
		
	}
	
	/**
	 * Dispara uma nova thread para o processamento da validação associada ao ValidationElement
	 * 
	 * @param element {@link ValidationElement} a ser processado
	 * @param mode modo de procesamento segundo o enum {@link ValidationMode}
	 * @param indexValidacao índice de processamento da validação atual
	 * @param mensagensValidacao lista de mensagens de validação a ser manipulada caso alguma validação falhe
	 * @param executorService ExecutorService responsável por gerenciar o processamento da thread
	 */
	private void startThread(final ValidationElement element,final ValidationMode mode,final  int indexValidacao,
			final List<String> mensagensValidacao,  ExecutorService executorService){
		
	   executorService.execute(new Runnable(){
		  public void run() {
			startValidation(element, mode, indexValidacao, mensagensValidacao);
		  } 
	   });
	}
	
}
