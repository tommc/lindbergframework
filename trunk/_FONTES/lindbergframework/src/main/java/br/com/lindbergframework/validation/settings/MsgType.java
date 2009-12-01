package br.com.lindbergframework.validation.settings;

import br.com.lindbergframework.validation.ValidationItem;

/**
 * 
 * Tipo de uso de mensagem personalizada que indica a forma de uso e <br>
 * configura��o das mensagens de uma valida��o. Esta classe � usada em um {@link ValidationItem} <br>
 * para configura��o da(s) mesnagem(s) de valida��o 
 * 
 * @author Victor Lindberg
 *
 */
public enum MsgType {
	
	/**
	 * Usa somente a mensagem personalizada
	 */
	CUSTOM_ONLY("CUSTOM_ONLY",true,false,false),
	
	/**
	 * Usa a mensagem personalizada como sufixo na mensagem de valida��o
	 */
	USING_CUSTOM_SUFFIX("USING_CUSTOM_SUFFIX",true,true,true),
	
	/**
	 * Usa a mensagem personalizada como prefixo na mensagem de valida��o
	 */
	USING_CUSTOM_PREFIX("USING_CUSTOM_PREFIX",true,true,false),
	
	/**
	 * Usa apenas a mensagem de valida��o e n�o considera a personalizada
	 */
	NO_USING_CUSTOM("NO_USING_CUSTOM",false,false,false);
	
	private String name;
	private boolean usingMessageCustom,
	                concatWithValidationMessage,
	                concatInTheFinal;
	
	private MsgType(String name,boolean usingMessageCustom,
			         boolean concatWithValidationMessage, boolean concatInTheFinal){
	   setName(name);
	   setUsingMessageCustom(usingMessageCustom);
	   setConcatWithValidationMessage(concatWithValidationMessage);
	   setConcatInTheFinal(concatInTheFinal);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public boolean isUsingMessageCustom() {
		return usingMessageCustom;
	}
	
	
	public void setUsingMessageCustom(boolean usingMessageCustom) {
		this.usingMessageCustom = usingMessageCustom;
	}

	public boolean isConcatWithValidationMessage() {
		return concatWithValidationMessage;
	}
	
	public void setConcatWithValidationMessage(
			boolean concatWithValidationMessage) {
		this.concatWithValidationMessage = concatWithValidationMessage;
	}
	
	public boolean isConcatInTheFinal() {
		return concatInTheFinal;
	}
	
	public void setConcatInTheFinal(boolean concatInTheFinal) {
		this.concatInTheFinal = concatInTheFinal;
	}

}
