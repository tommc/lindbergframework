package br.com.lindbergframework.validation.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationClassCastException;
import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IValidation;
import br.com.lindbergframework.validation.IExecutorValidation;
import br.com.lindbergframework.validation.ValidationItem;
import br.com.lindbergframework.validation.settings.MsgType;
import br.com.lindbergframework.validation.settings.ValidationMode;



/**
 * 
 * @author Victor Lindberg
 * 
 */
@Component("executorValidation")
@Scope("prototype")
@SuppressWarnings("unchecked")
public class ExecutorValidationImpl implements IExecutorValidation{

	private List<ValidacaoElement> validacoes = new Vector<ValidacaoElement>();
	
	public static final String MSG_INDEXES_VALIDACAO_INVALIDO = "Não foi possível adicionar a(s) validação(ões). " +
									"Um ou mais items tem seus índices ou mensagens de validações inválidos"; 
	
	
	
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
	   executarValidacaoes(mode);
	}
	 
	public void addValidationsForItemValidating(ValidationMode mode,
			ValidationItem item, IValidation... validacoes) {
	   addValidationsForItem(item, validacoes);
	   executarValidacaoes(mode);
	}
	  
	public void addValidationsValidating(ValidationMode mode,
			ValidationItem[] items, IValidation... validacoes) {
	   addValidations(items, validacoes);
	   executarValidacaoes(mode);
	}
	
	private void addItem(IValidation[] validacoes,ValidationItem item){
		Integer[] indexes = item.getIndexValidacoes();
		for (int i = 0;i < indexes.length;i++){
			IValidation validacao = validacoes[indexes[i]];
			String msgCustom = item.getMessages()[i];
			addValidation(validacao, item,msgCustom);
		}
	}
	
	private void addValidation(IValidation validacao,ValidationItem item,String msgCustom){
		   validacoes.add(new ValidacaoElement(validacao,item,msgCustom));	
    }
	
	private boolean isIndexValidacoesItemsOK(IValidation[] validacoes, ValidationItem[] items){
		for (ValidationItem item : items){
		   if (item.getMessages().length != item.getIndexValidacoes().length)
			   return false;
		   
		   Integer[] indexes = item.getIndexValidacoes();
		
		   for (Integer index : indexes){
			  if (index > validacoes.length - 1 ||
			      index < 0)
				  return false;
		   }
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param mode
	 * @throws ValidationException
	 */
	public void executarValidacaoes(ValidationMode mode) throws ValidationException, ValidationClassCastException{
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
				List<String> msgs = formatMsgsParaItemValidacao(ex, element,indexValidacao);
				mensagensValidacao.addAll(msgs);
				lancarExcecaoSeModeImediatamente(mensagensValidacao, mode);
			}
		}
		
		lancarExcecaoSeModeFinal(mensagensValidacao, mode);
	}
	
	/**
	 * 
	 * @throws ValidationException
	 */
	public void executarValidacaoes() throws ValidationException,ValidationClassCastException{
		executarValidacaoes(ValidationMode.THROW_FINAL);
	}
	
	private void lancarExcecaoSeModeImediatamente(List<String> mensagensValidacao,ValidationMode mode){
		if (mode.equals(ValidationMode.THROW_IMMEDIATELY))
			   lancarExcecaoSeNecessario(mensagensValidacao);   	
	}
	
	private void lancarExcecaoSeModeFinal(List<String> mensagensValidacao,ValidationMode mode){
		if (mode.equals(ValidationMode.THROW_FINAL))
			lancarExcecaoSeNecessario(mensagensValidacao);   	
	}
	
	private void lancarExcecaoSeNecessario(List<String> mensagensValidacao) {
		if(! mensagensValidacao.isEmpty()) {
			clearValidations();
			throw new ValidationException(mensagensValidacao);
		}
	}
	
    private List<String> formatMsgsParaItemValidacao(ValidationException ex,ValidacaoElement element,int indexValidacao){
    	ValidationItem item = element.getValidacaoItem();
    	MsgType msgType = item.getMsgType();
		if (msgType.isUsandoMsgPersonalizada())
		{
		   String msgCustom = element.getMsgCustom();
		   if (msgType.isConcatenarComMsgValidacao())
		   {
		      List<String> msgs = new Vector<String>();
		      for (String msgEx : ex.getMessages()){
		    	  msgs.add(msgType.isConcatenarNoFinal() ? 
		    			         msgEx +" "+item.getSeparador()+" "+ msgCustom :
		    			        	 msgCustom +" "+item.getSeparador()+" "+ msgEx);
		      }
		      
		      return msgs;
		   }
		   else
			   return Arrays.asList(msgCustom);
		}
		else
			return ex.getMessages();
	}
	
	private void validarItem(ValidacaoElement validacaoElement) {
		IValidation<Object> validacao = validacaoElement.getValidacao();
		try{
		   validacao.validate(validacaoElement.getValidacaoItem().getValor());
		}catch(ClassCastException ex){
			throw new ValidationClassCastException("Não foi possível efetuar a validação de um ou mais " +
					"items pois o valor a ser validado não corresponde com o tipo esperado para a validação",ex);
		}
		
	}
	
	public void reset(){
		clearValidations();
	}
	
	public void clearValidations(){
		validacoes.clear();
	}

	private class ValidacaoElement {

		private IValidation<Object> validacao;
		private ValidationItem validacaoItem;
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
