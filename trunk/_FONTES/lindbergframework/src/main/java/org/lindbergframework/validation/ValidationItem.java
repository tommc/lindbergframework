package org.lindbergframework.validation;

import org.lindbergframework.validation.settings.MsgType;

/**
 * Item de valida��o. Este item contem a configura��o da valida��o de um determinado valor <br>
 * que auxiliar� ExecutorsValidations no correto processamento das valida��es. <br><br>
 * 
 * Esta classe � usada para configurar elementos de uma valida��o como: mensagem da valida��o, <br>
 * concatena��o ou n�o da mensagem da valida��o e da mensagem personalizada, <br>
 * tipo de concatena��o baseada no enum {@link MsgType}, etc...<br>
 * 
 * 
 * @author Victor Lindberg
 *
 */
public class ValidationItem {
 
	/**
	 * Separador padr�o quando a mensagem da <br>
	 * valida��o e a personalizada forem utilizadas ao mesmo tempo na valida��o
	 */
	public static final String DEFAULT_SEPARATOR = ":";

	/**
	 * valor a ser validado
	 */	
	private Object value;
	
	/**
	 * Lista de mensagens onde cada mensagem corresponde a uma valida��o que � adicionada junto com este item
	 */
	private String[] messages = new String[0];
	
	/**
	 * �ndices de valida��es que indicam com quais valida��es este item ser� validado.<br><br>
	 * 
	 * Obs: Esta propriedade � definida explicitamente quando o m�todo <br>
	 * addValidations de um ExecutorValidation � usado para adiciona um ou mais validationItems
	 */
	private Integer[] indexValidations = new Integer[] {0};
	
	/**
	 * Tipo de uso da mensagem que ser� lan�ada na exception quando a valida��o falhar.<br><br>
	 * 
	 * O enum {@link MsgType} define se ser� usada uma mensagem externa ou n�o, <br>
	 * se ser� usada apenas esta, se esta ser� usada em conjunto com a mensagem vinda da exce��o, <br>
	 * como se dar� a forma��o da concatena��o das duas mensagens e se a externa ser� prefixo ou sufixo da mensagem da valida��o
	 */
	private MsgType msgType = MsgType.NO_USING_CUSTOM;
	
	/**
	 * Separador das mensagem quando a mensagem externa e a da valida��o forem utilizadas ao mesmo tempo na vaida��o 
	 */
	private String separator = DEFAULT_SEPARATOR;

	/**
	 * Cria um novo item apenas com a mensagem da valida��o 
	 * 
	 * @param value valor a ser validado
	 */
	public ValidationItem(Object value){
		setValue(value);
	}
	
	/**
	 * Cria um novo item usando apenas a mensagem externa (personalizada)
	 * 
	 * @param value valor a ser validado
	 * @param msg mensagem personalizada
	 */
	public ValidationItem(Object value,String msg){
		this(value,MsgType.CUSTOM_ONLY,msg);
	}
	
	/**
	 * Cria um novo item usando mensagens personalizadas de acordo <br>
	 * com o tipo de uso da mensagem personalizada passado como argumento.<br><br>
	 * 
	 * Este m�todo recebe um conjunto de Strings onde cada uma corresponde a uma <br>
	 * valida��o que ser� associada ao item onde por exemplo se forem passadas 3 Strings para o parametro <br>
	 * {@link #messages} internamente os �ndices de valida��o ser�o configurados como 0,1,2 <br>
	 * onde cada valida��o correspondente a um dos �ndices ser� associada a String de mesmo �ndice <br>
	 * no parametro {@link #messages}
	 * 
	 * @param value valor a ser validado
	 * @param msgType tipo de uso das mensagens personalizadas
	 * @param messages lista de mensagens 
	 */
	public ValidationItem(Object value,MsgType msgType,String... messages){
		setValue(value);
		setMessages(messages);
		setMsgType(msgType);
		Integer[] indexes = new Integer[messages.length];
		for (int i = 0;i < messages.length;i++)
			indexes[i] = i;
		setIndexValidations(indexValidations);
	}
	
	/**
	 * Cria um item da mesma forma que o construtor {@link #ValidationItem(Object, MsgType, String...)} <br>
	 * s� que configurando o separador das mensagens personalizada e da valida��o
	 * 
	 * @param separator separador da mensagem personalizada e da valida�ao
	 * @param value valor a ser validado
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param messages lista de mensagens
	 */
	public ValidationItem(String separator, Object value,MsgType msgType,String... messages){
		this(value,msgType,messages);
		setSeparator(separator);
	}
	
	
	/**
	 * Cria um item que utilizar� as valida��es de �ndices descritos no parametro indexesValidations <br><br>
	 * 
	 * Este construtor � usado geralmente no m�todo addValidations de um executorValidation na a��o de adi��o de valida��es
	 * 
	 * @param value valor a ser validado
	 * @param indexesValidations �ndices das valida��es que ser�o utilizadas para este item
	 */
	public ValidationItem(Object value,Integer... indexesValidations){
		setValue(value);
		setIndexValidations(indexesValidations);
		setMessages(createArrayWithMessage(null, indexesValidations.length));
	}
	
	/**
	 * Cria um item definindo os �ndices de valida��es<br>
	 * e um array de mensagens onde cada mensagem corresponde <br>
	 * a uma valida��o que ser� adicionada a este item segundo o conjunto <br>
	 * de �ndices de valida��es passados para o parametro indexesValidations
	 * 
	 * @param value valor a ser validado
	 * @param msgType tipo de uso da mesnagem personalizada
	 * @param messages mensagens de cada valida��o
	 * @param indexesValidations �ndices das valida��es que ser�o associadas a este item
	 */
	public ValidationItem(Object value,MsgType msgType,
			   String[] messages,Integer... indexesValidations){
		this(value,indexesValidations);
		setMessages(messages);
		setMsgType(msgType);
	}
	
	/**
	 * Cria um item da mesma forma que o construtor {@link #ValidationItem(Object, MsgType, String[], Integer...)} <br>
	 * s� que configura o separador da mensagem personalizada e da valida��o
	 * 
	 * @param separator separador das mensagens personalizada e da valida��o
	 * @param value valor a ser validado
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param messages mensagens das valida��es
	 * @param indexesValidations �ndices das valida��es que ser�o associadas a este item
	 */
	public ValidationItem(String separator, Object value,MsgType msgType,
			String[] messages,Integer... indexesValidations){
		this(value,msgType,messages,indexesValidations);
		setSeparator(separator);
	} 
	
	/**
	 * Cria um item da mesma forma que o construtor {@link #ValidationItem(Object, MsgType, String[], Integer...)} <br>
	 * s� que configura o tipo de mensagem como apenas personalidaza (MsgType.CUSTOM_ONLY)
	 * 
	 * @param value valor a ser validado
	 * @param messages mensagens das valida��es
	 * @param indexesValidations �ndices das valida��es que ser�o associadas a este item
	 */
	public ValidationItem(Object value,String[] messages,Integer... indexesValidations){
		this(value,MsgType.CUSTOM_ONLY,messages,indexesValidations);
	}
	
	/**
	 * Cria um novo item da mesma forma que o construtor {@link #ValidationItem(Object, MsgType, String[], Integer...)} <br>
	 * s� que como s� recebe uma mensagem ent�o configura a mesma mensagem para todas as valida��es
	 * 
	 * @param value valor a ser validado
	 * @param message mensagem a ser configurada para as valida��es
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param indexesValidations �ndices das valida��es que ser�o associadas a este item
	 */
	public ValidationItem(Object value,String message,MsgType msgType,Integer... indexesValidations){
		this(value,indexesValidations);
		setMessages(createArrayWithMessage(message, indexesValidations.length));
		setMsgType(msgType);
	}
	
	/**
	 * Cria um novo item da mesma forma que o construtor {@link #ValidationItem(Object, String,MsgType, String[], Integer...)} <br>
	 * s� que configura o tipo da mensagem como apenas personalizada
	 * 
	 * @param value valor a ser validado
	 * @param message mensagem a ser configurada para as valida��es
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param indexesValidations �ndices das valida��es que ser�o associadas a este item
	 */
	public ValidationItem(Object value,String message,Integer... indexesValidations){
		this(value,message,MsgType.CUSTOM_ONLY,indexesValidations);
	}
	
	/**
	 * Cria um item da mesma forma que o construtor {@link #ValidationItem(Object, String, MsgType, Integer...)} <br>
	 * s� que configura o separador da mensagem personalizada e da valida��o
	 * 
	 * @param separator separador das mensagens personalizada e da valida��o 
	 * @param value valor a ser validado
	 * @param message mensagem a ser configurada para as valida��es
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param indexesValidations �ndices das valida��es que ser�o associadas a este item
	 */
	public ValidationItem(String separator, Object value,String message,MsgType msgType,Integer... indexesValidations){
		this(value,message,msgType,indexesValidations);
		setSeparator(separator);
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
	public Object getValue() {
		return value;
	}
	

	private void setMessages(String[] messages) {
		this.messages = messages;
	}
	
	
	public String[] getMessages() {
		return messages;
	}

	public Integer[] getIndexValidations() {
		return indexValidations;
	}
	
	public void setIndexValidations(Integer[] indexValidations) {
		this.indexValidations = indexValidations;
	}

	public String getSeparator() {
		return separator;
	}
	
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	private void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}
	
	public MsgType getMsgType() {
		return msgType;
	}
	
	/**
	 * Cria um array de tamanho passado como argumento para o parametro length <br>
	 * configurando cada elemento do array com a String message
	 */
	private String[] createArrayWithMessage(String message,int length){
	   String[] array = new String[length];
	   
	   for (int  i = 0;i < length;i++)
		   array[i] = message;
	   
	   return array;
	}
	
		
}
