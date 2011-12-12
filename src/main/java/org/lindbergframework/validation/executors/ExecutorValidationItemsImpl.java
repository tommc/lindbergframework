package org.lindbergframework.validation.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.lindbergframework.exception.ValidationClassCastException;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IExecutorValidationItems;
import org.lindbergframework.validation.IValidation;
import org.lindbergframework.validation.Item;
import org.lindbergframework.validation.settings.MsgType;
import org.lindbergframework.validation.settings.ValidationMode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;




/**
 * Implementação padrão de {@link IExecutorValidationItems} para o processamento de validações que implementem {@link IValidation}
 * 
 * @author Victor Lindberg
 * 
 */
@Component("executorValidationDefault")
@Scope("prototype")
@SuppressWarnings("unchecked")
public class ExecutorValidationItemsImpl implements IExecutorValidationItems{
 
	/**
	 * lista de validações aguardando execução
	 */
	private List<ValidationElement> validacoes = new Vector<ValidationElement>();
	
	public static final String MSG_INDEXES_VALIDACAO_INVALIDO = "Não foi possível adicionar a(s) validação(ões). " +
									"Um ou mais items tem seus índices ou mensagens de validações inválidos"; 
	
	
	
	public ExecutorValidationItemsImpl() {
		//
	}
	
	public void addValidations(Item[] items,IValidation... validacoes){
	   if (! isIndexValidacoesItemsOK(validacoes, items))
		   throw new IllegalStateException(MSG_INDEXES_VALIDACAO_INVALIDO);
		
	   for (Item item : items)
	   	   addItem(validacoes, item); 
		   
	}
	
	public void addValidationForSeveralItems(IValidation validacao,Item... items){
	   for (int i = 0; i < items.length;i++){
		   Item item = items[i];
		   int length = item.getMessages().length;
		   addValidation(validacao, item,(length == 0 ? null : item.getMessages()[0]));
	   }
	}
	
	public void addValidationsForItem(Item item,IValidation... validacoes){
	   for (int i = 0;i < validacoes.length;i++){
		   int length = item.getMessages().length;
		   addValidation(validacoes[i], item, (length == 0 || length - 1 < i ? null : item.getMessages()[i]));
	   }
	}
	 
	public void addValidationForSeveralItemsValidating(ValidationMode mode,
			IValidation validacao, Item... items) {
	   addValidationForSeveralItems(validacao, items);
	   execute(mode);
	}
	 
	public void addValidationsForItemValidating(ValidationMode mode,
			Item item, IValidation... validacoes) {
	   addValidationsForItem(item, validacoes);
	   execute(mode);
	}
	  
	public void addValidationsValidating(ValidationMode mode,
			Item[] items, IValidation... validacoes) {
	   addValidations(items, validacoes);
	   execute(mode);
	}
	
	public void addValidationForSeveralItemsValidating(IValidation validacao,
			Item... items) {
		addValidationForSeveralItemsValidating(ValidationMode.THROW_FINAL, validacao, items);
	}
	
	public void addValidationsForItemValidating(Item item,
			IValidation... validacoes) {
		addValidationsForItemValidating(ValidationMode.THROW_FINAL, item, validacoes);
	}
	
	public void addValidationsValidating(Item[] items,
			IValidation... validacoes) {
		addValidationsValidating(ValidationMode.THROW_FINAL, items, validacoes);		
	}
	
	private void addItem(IValidation[] validacoes,Item item){
		Integer[] indexes = item.getIndexValidations();
		for (int i = 0;i < indexes.length;i++){
			IValidation validacao = validacoes[indexes[i]];
			String msgCustom = item.getMessages()[i];
			addValidation(validacao, item,msgCustom);
		}
	}
	
	private void addValidation(IValidation validacao,Item item,String msgCustom){
		   validacoes.add(new ValidationElement(validacao,item,msgCustom));	
    }

	/**
	 * verifica se os índices de validações dos items de acordo com as validações são validos
	 */
	private boolean isIndexValidacoesItemsOK(IValidation[] validacoes, Item[] items){
		for (Item item : items){
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
		List<String> validationMessages = new Vector<String>();
		List<ValidationElement> validElements = new Vector<ValidationElement>();
		validElements.addAll(validacoes);
		
		clearValidations();
	    
		startValidationProcess(validElements, mode, validationMessages);
		
		lancarExcecaoSeModeFinal(validationMessages, mode);
	}
	
	protected void startValidationProcess(List<ValidationElement> validElements,ValidationMode mode, List<String> validationMessages){
		for (int indexValidacao = 0;indexValidacao < validElements.size();indexValidacao++){
			startValidation(validElements.get(indexValidacao), mode, indexValidacao, validationMessages);
		}
		
	}
	
	protected void startValidation(ValidationElement element,
			ValidationMode mode, int indexValidacao,
			List<String> validationMessages) {
		try {
			validarItem(element);
		} catch (ValidationException ex) {
			tratarExcecao(element, mode, indexValidacao, ex, validationMessages);
		}
	}
	
	protected synchronized void tratarExcecao(ValidationElement element,ValidationMode mode,
			int indexValidacao,ValidationException ex, List<String> validationMessages){
		
		if (ex.getMessages().isEmpty())
			ex.addMessage(String.format("Validation %s failed", element.getValidacao().getClass().toString()));
		
		List<String> msgs = formatMsgsParaItemValidacao(ex, element,indexValidacao);
		validationMessages.addAll(msgs);
		lancarExcecaoSeModeImediatamente(validationMessages, mode);	
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
	 * lança exceção caso seja necessário e o modo de validação for ValidationMode.THROW_IMMEDIATELY 
	 */
	protected synchronized void lancarExcecaoSeModeImediatamente(List<String> validationMessages,ValidationMode mode){
		if (mode.equals(ValidationMode.THROW_IMMEDIATELY))
			   lancarExcecaoSeNecessario(validationMessages);   	
	}
	
	/**
	 * lança exceção caso seja necessário e o modo de validação for ValidationMode.THROW_FINAL 
	 */
	protected  synchronized void lancarExcecaoSeModeFinal(List<String> validationMessages,ValidationMode mode){
		if (mode.equals(ValidationMode.THROW_FINAL))
			lancarExcecaoSeNecessario(validationMessages);   	
	}

	/**
	 * lança exceção se necessário ou seja se a lista de mensagens de validação não estiver vazia
	 */
	protected synchronized void lancarExcecaoSeNecessario(List<String> validationMessages) {
		if(! validationMessages.isEmpty()) {
			clearValidations();
			throw new ValidationException(validationMessages);
		}
	}
	
	/**
	 * Formata a mensagem de validação de acordo com as configurações definidas no ValidationElement e retorna a lista de mensagens configuradas. <br><br>
	 * 
	 * Obs: Pode ser mais de uma mensagem por que um {@link ValidationException} pode ter uma ou mais mensagens
	 */
    protected List<String> formatMsgsParaItemValidacao(ValidationException ex,ValidationElement element,int indexValidacao){
    	Item item = element.getValidacaoItem();
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
     * Efetua a validação de um elemento de validação
     */
	protected void validarItem(ValidationElement validacaoElement) {
		IValidation<Object> validacao = validacaoElement.getValidacao();
		try{
		   validacao.validate(validacaoElement.getValidacaoItem().getValue());
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
	
	public List<IValidation> getValidations() {
		List<IValidation> validations = new Vector<IValidation>();
		
		for(ValidationElement elem : validacoes)
			validations.add(elem.getValidacao());
		
		return validations;
	}
	
	protected List<ValidationElement> getValidationElements(){
		return validacoes;
	}

	/**
	 * Elemento de validação que contem um item de validação, uma validação <br>
	 * que é associada ao item e uma mensagem que pode ser null ou uma mensagem <br>
	 * personalziada para a validação caso esta falhe
	 * 
	 * @author Victor Lindberg
	 *
	 */
	protected class ValidationElement {

		/**
		 * validação a ser usada para validar o item
		 */
		private IValidation<Object> validacao;
		
		/**
		 * item a ser validado
		 */
		private Item validacaoItem;
		
		/**
		 * mensagem personalizada que pode ou não ser definida
		 */
		private String msgCustom;
		
		public ValidationElement(){
			//
		}
		
		public ValidationElement(IValidation<Object> validacao, Item validacaoItem,String msgCustom) {
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
		
		public Item getValidacaoItem() {
			return validacaoItem;
		}
		
		public void setValidacaoItem(Item validacaoItem) {
			this.validacaoItem = validacaoItem;
		}
		
	}


}
