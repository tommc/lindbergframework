package org.lindbergframework.validation.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IExecutorValidation;
import org.lindbergframework.validation.IValidation;
import org.lindbergframework.validation.ValidationItem;
import org.lindbergframework.validation.settings.MsgType;
import org.lindbergframework.validation.settings.ValidationMode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;




/**
 * Implementa��o padr�o de {@link IExecutorValidation} para o processamento de valida��es que implementem {@link IValidation}
 * 
 * @author Victor Lindberg
 * 
 */
@Component("executorValidation")
@Scope("prototype")
@SuppressWarnings("unchecked")
public class ExecutorValidationImpl implements IExecutorValidation{

	/**
	 * lista de valida��es aguardando processamento
	 */
	private List<ValidacaoElement> validacoes = new Vector<ValidacaoElement>();
	
	public static final String MSG_INDEXES_VALIDACAO_INVALIDO = "N�o foi poss�vel adicionar a(s) valida��o(�es). " +
									"Um ou mais items tem seus �ndices ou mensagens de valida��es inv�lidos"; 
	
	
	
	public ExecutorValidationImpl() {
		//
	}
	
	public void addValidations(ValidationItem[] items,IValidation... validacoes){
	   if (! isIndexValidacoesItemsOK(validacoes, items))
		   throw new IllegalStateException(MSG_INDEXES_VALIDACAO_INVALIDO);
		
	   for (ValidationItem item : items)
	   	   addItem(validacoes, item); 
		   
	}
	
	public void addValidationForSeveralItems(IValidation validacao,ValidationItem... items){
	   for (int i = 0; i < items.length;i++){
		   ValidationItem item = items[i];
		   int length = item.getMessages().length;
		   addValidation(validacao, item,(length == 0 ? null : item.getMessages()[0]));
	   }
	}
	
	public void addValidationsForItem(ValidationItem item,IValidation... validacoes){
	   for (int i = 0;i < validacoes.length;i++){
		   int length = item.getMessages().length;
		   addValidation(validacoes[i], item, (length == 0 || length - 1 < i ? null : item.getMessages()[i]));
	   }
	}
	 
	public void addValidationForSeveralItemsValidating(ValidationMode mode,
			IValidation validacao, ValidationItem... items) {
	   addValidationForSeveralItems(validacao, items);
	   execute(mode);
	}
	 
	public void addValidationsForItemValidating(ValidationMode mode,
			ValidationItem item, IValidation... validacoes) {
	   addValidationsForItem(item, validacoes);
	   execute(mode);
	}
	  
	public void addValidationsValidating(ValidationMode mode,
			ValidationItem[] items, IValidation... validacoes) {
	   addValidations(items, validacoes);
	   execute(mode);
	}
	
	public void addValidationForSeveralItemsValidating(IValidation validacao,
			ValidationItem... items) {
		addValidationForSeveralItemsValidating(ValidationMode.THROW_FINAL, validacao, items);
	}
	
	public void addValidationsForItemValidating(ValidationItem item,
			IValidation... validacoes) {
		addValidationsForItemValidating(ValidationMode.THROW_FINAL, item, validacoes);
	}
	
	public void addValidationsValidating(ValidationItem[] items,
			IValidation... validacoes) {
		addValidationsValidating(ValidationMode.THROW_FINAL, items, validacoes);		
	}
	
	private void addItem(IValidation[] validacoes,ValidationItem item){
		Integer[] indexes = item.getIndexValidations();
		for (int i = 0;i < indexes.length;i++){
			IValidation validacao = validacoes[indexes[i]];
			String msgCustom = item.getMessages()[i];
			addValidation(validacao, item,msgCustom);
		}
	}
	
	private void addValidation(IValidation validacao,ValidationItem item,String msgCustom){
		   validacoes.add(new ValidacaoElement(validacao,item,msgCustom));	
    }

	/**
	 * verifica se os �ndices de valida��es dos items de acordo com as valida��es s�o validos
	 */
	private boolean isIndexValidacoesItemsOK(IValidation[] validacoes, ValidationItem[] items){
		for (ValidationItem item : items){
		   if (item.getMessages().length != item.getIndexValidations().length)
			   return false;
		   
		   Integer[] indexes = item.getIndexValidations();
		
		   for (Integer index : indexes){
			  if (index > validacoes.length - 1 ||
			      index < 0)
				  return false;
		   }
		}
		
		return true;
	}
	
	public void execute(ValidationMode mode) throws ValidationException, ValidationClassCastException{
		List<String> mensagensValidacao = new ArrayList<String>();
		List<ValidacaoElement> validElements = new Vector<ValidacaoElement>();
		validElements.addAll(validacoes);
		
		clearValidations();
		
		for (int indexValidacao = 0;indexValidacao < validElements.size();indexValidacao++){
			ValidacaoElement element = validElements.get(indexValidacao);
			try {
				validarItem(element);
			}
			catch (ValidationException ex) {
				if (ex.getMessages().isEmpty())
					ex.addMessage(String.format("Validation %s failed", element.getValidacao().getClass().toString()));
				
				List<String> msgs = formatMsgsParaItemValidacao(ex, element,indexValidacao);
				mensagensValidacao.addAll(msgs);
				lancarExcecaoSeModeImediatamente(mensagensValidacao, mode);
			}
		}
		
		lancarExcecaoSeModeFinal(mensagensValidacao, mode);
	}
	
	public void execute() throws ValidationException,ValidationClassCastException{
		execute(ValidationMode.THROW_FINAL);
	}
	
	public void execute(String separatorMessages) throws ValidationException,ValidationClassCastException{
		try{
		   execute(ValidationMode.THROW_FINAL);
		}catch(ValidationException ex){
			ex.setSeparatorMessages(separatorMessages);
			throw ex;
		}
	}

	/**
	 * lan�a exce��o caso seja necess�rio e o modo de valida��o for ValidationMode.THROW_IMMEDIATELY 
	 */
	private void lancarExcecaoSeModeImediatamente(List<String> mensagensValidacao,ValidationMode mode){
		if (mode.equals(ValidationMode.THROW_IMMEDIATELY))
			   lancarExcecaoSeNecessario(mensagensValidacao);   	
	}
	
	/**
	 * lan�a exce��o caso seja necess�rio e o modo de valida��o for ValidationMode.THROW_FINAL 
	 */
	private void lancarExcecaoSeModeFinal(List<String> mensagensValidacao,ValidationMode mode){
		if (mode.equals(ValidationMode.THROW_FINAL))
			lancarExcecaoSeNecessario(mensagensValidacao);   	
	}

	/**
	 * lan�a exce��o se necess�rio ou seja se a lista de mensagens de valida��o n�o estiver vazia
	 */
	private void lancarExcecaoSeNecessario(List<String> mensagensValidacao) {
		if(! mensagensValidacao.isEmpty()) {
			clearValidations();
			throw new ValidationException(mensagensValidacao);
		}
	}
	
	/**
	 * Formata a mensagem de valida��o de acordo com as configura��es definidas no ValidationElement e retorna a lista de mensagens configuradas. <br><br>
	 * 
	 * Obs: Pode ser mais de uma mensagem por que um {@link ValidationException} pode ter uma ou mais mensagens
	 */
    private List<String> formatMsgsParaItemValidacao(ValidationException ex,ValidacaoElement element,int indexValidacao){
    	ValidationItem item = element.getValidacaoItem();
    	MsgType msgType = item.getMsgType();
		if (msgType.isUsingMessageCustom())
		{
		   String msgCustom = element.getMsgCustom();
		   if (msgType.isConcatWithValidationMessage())
		   {
		      List<String> msgs = new Vector<String>();
		      for (String msgEx : ex.getMessages()){
		    	  msgs.add(msgType.isConcatInTheFinal() ? 
		    			         msgEx +" "+item.getSeparator()+" "+ msgCustom :
		    			        	 msgCustom +" "+item.getSeparator()+" "+ msgEx);
		      }
		      
		      return msgs;
		   }
		   else
			   return Arrays.asList(msgCustom);
		}
		else
			return ex.getMessages();
	}

    
    /**
     * Efetua a valida��o de um elemento de valida��o
     */
	private void validarItem(ValidacaoElement validacaoElement) {
		IValidation<Object> validacao = validacaoElement.getValidacao();
		try{
		   validacao.validate(validacaoElement.getValidacaoItem().getValue());
		}catch(ClassCastException ex){
			throw new ValidationClassCastException("N�o foi poss�vel efetuar a valida��o de um ou mais " +
					"items pois o valor a ser validado n�o corresponde com o tipo esperado para a valida��o",ex);
		}
		
	}
	
	public void reset(){
		clearValidations();
	}
	
	public void clearValidations(){
		validacoes.clear();
	}

	/**
	 * Elemento de valida��o que contem um item de valida��o, uma valida��o <br>
	 * que � associada ao item e uma mensagem que pode ser null ou uma mensagem <br>
	 * personalziada para a valida��o caso esta falhe
	 * 
	 * @author Victor Lindberg
	 *
	 */
	private class ValidacaoElement {

		/**
		 * valida��o a ser usada para validar o item
		 */
		private IValidation<Object> validacao;
		
		/**
		 * item a ser validado
		 */
		private ValidationItem validacaoItem;
		
		/**
		 * mensagem personalizada que pode ou n�o ser definida
		 */
		private String msgCustom;
		
		public ValidacaoElement(){
			//
		}
		
		public ValidacaoElement(IValidation<Object> validacao, ValidationItem validacaoItem,String msgCustom) {
			this.validacao = validacao;
			this.validacaoItem = validacaoItem;
			this.msgCustom = msgCustom;
		}
		
		public void setMsgCustom(String msgCustom) {
			this.msgCustom = msgCustom;
		}
		
		
		public String getMsgCustom() {
			return msgCustom;
		}
		
		public IValidation<Object> getValidacao() {
			return validacao;
		}
		
		public void setValidacao(IValidation<Object> validacao) {
			this.validacao = validacao;
		}
		
		public ValidationItem getValidacaoItem() {
			return validacaoItem;
		}
		
		public void setValidacaoItem(ValidationItem validacaoItem) {
			this.validacaoItem = validacaoItem;
		}
		
	}


}