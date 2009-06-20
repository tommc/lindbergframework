package br.com.lindbergframework.validation.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IValidation;
import br.com.lindbergframework.validation.IValidationComposite;
import br.com.lindbergframework.validation.ValidationItem;
import br.com.lindbergframework.validation.settings.MsgType;
import br.com.lindbergframework.validation.settings.ValidationMode;



/**
 * 
 * @author Victor Lindberg
 * 
 */
@Component("validacaoComposite")
@Scope("prototype")
@SuppressWarnings("unchecked")
public class ValidationComposite implements IValidationComposite{

	private List<ValidacaoElement> validacoes = new Vector<ValidacaoElement>();
	
	public static final String MSG_INDEXES_VALIDACAO_INVALIDO = "Não foi possível adicionar a(s) validação(ões). " +
									"Um ou mais items tem um ou mais de seus índices de validação inválido"; 
	
	
	
	public ValidationComposite() {
		//
	}
	
	public void addValidations(List<ValidationItem> items,IValidation... validacoes){
	   if (! isIndexValidacoesItemsOK(validacoes, items))
		   throw new IllegalStateException(MSG_INDEXES_VALIDACAO_INVALIDO);
		
	   for (ValidationItem item : items)
	   	   addItem(validacoes, item); 
		   
	}
	
	public void addValidationForSeveralItems(IValidation validacao,ValidationItem... items){
	   for (ValidationItem item : items)
		   addValidation(validacao, item);
	}
	
	public void addValidationsForItem(ValidationItem item,IValidation... validacoes){
	   for (IValidation validacao : validacoes)
		   addValidation(validacao, item);
	}
	
	private void addItem(IValidation[] validacoes,ValidationItem item){
		for (Integer index : item.getIndexValidacoes()){
			IValidation validacao = validacoes[index];
			addValidation(validacao, item);
		}
	}
	
	private void addValidation(IValidation validacao,ValidationItem item){
		   validacoes.add(new ValidacaoElement(validacao,item));	
    }
	
	private boolean isIndexValidacoesItemsOK(IValidation[] validacoes, List<ValidationItem> items){
		for (ValidationItem item : items){
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
	public void executarValidacaoes(ValidationMode mode) throws ValidationException{
		List<String> mensagensValidacao = new ArrayList<String>();
		for (int indexValidacao = 0;indexValidacao < validacoes.size();indexValidacao++){
			ValidacaoElement element = validacoes.get(indexValidacao);
			try {
				validarItem(element);
			} catch (ValidationException e) {
				List<String> msgs;
				ValidationItem item = element.getValidacaoItem();
				if (item.getMessages().isEmpty())
					msgs = e.getMessages();
				else
					msgs = formatMsgsParaItemValidacao(e, item,indexValidacao);
				
				mensagensValidacao.addAll(msgs);
				lancarExcecaoSeModeImediatamente(mensagensValidacao, mode);
			}
		}
		
		lancarExcecaoSeModeFinal(mensagensValidacao, mode);
		clearValidations();
	}
	
	/**
	 * 
	 * @throws ValidationException
	 */
	public void executarValidacaoes() throws ValidationException{
		executarValidacaoes(ValidationMode.LANCAR_NO_FINAL);
	}
	
	private void lancarExcecaoSeModeImediatamente(List<String> mensagensValidacao,ValidationMode mode){
		if (mode.equals(ValidationMode.LANCAR_IMEDIATAMENTE))
			   lancarExcecaoSeNecessario(mensagensValidacao);   	
	}
	
	private void lancarExcecaoSeModeFinal(List<String> mensagensValidacao,ValidationMode mode){
		if (mode.equals(ValidationMode.LANCAR_NO_FINAL))
			lancarExcecaoSeNecessario(mensagensValidacao);   	
	}
	
	private void lancarExcecaoSeNecessario(List<String> mensagensValidacao) {
		if(! mensagensValidacao.isEmpty()) {
			clearValidations();
			throw new ValidationException(mensagensValidacao);
		}
	}
	
    private List<String> formatMsgsParaItemValidacao(ValidationException ex,ValidationItem item,int indexValidacao){
    	MsgType msgType = item.getMsgType();
    	String msgCustom = item.getMessages().get(indexValidacao);
		if (msgType.isUsandoMsgPersonalizada())
		{
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
		validacao.validate(validacaoElement.getValidacaoItem().getValor());
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
		
		
		public ValidacaoElement(){
			//
		}
		
		public ValidacaoElement(IValidation<Object> validacao, ValidationItem validacaoItem) {
			super();
			this.validacao = validacao;
			this.validacaoItem = validacaoItem;
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
