package br.com.lindbergframework.validation;

import br.com.lindbergframework.validation.settings.MsgType;

/**
 * Item de validação. Este item contem a configuração da validação de um determinado valor <br>
 * que auxiliará ExecutorsValidations no correto processamento das validações. <br><br>
 * 
 * Esta classe é usada para configurar elementos de uma validação como: mensagem da validação, <br>
 * concatenação ou não da mensagem da validação e da mensagem personalizada, <br>
 * tipo de concatenação baseada no enum {@link MsgType}, etc...<br>
 * 
 * 
 * @author Victor Lindberg
 *
 */
public class ValidationItem {
 
	/**
	 * Separador padrão quando a mensagem da <br>
	 * validação e a personalizada forem utilizadas ao mesmo tempo na validação
	 */
	public static final String DEFAULT_SEPARATOR = ":";

	/**
	 * valor a ser validado
	 */	
	private Object value;
	
	/**
	 * Lista de mensagens onde cada mensagem corresponde a uma validação que é adicionada junto com este item
	 */
	private String[] messages = new String[0];
	
	/**
	 * Índices de validações que indicam com quais validações este item será validado.<br><br>
	 * 
	 * Obs: Esta propriedade é definida explicitamente quando o método <br>
	 * addValidations de um ExecutorValidation é usado para adiciona um ou mais validationItems
	 */
	private Integer[] indexValidations = new Integer[] {0};
	
	/**
	 * Tipo de uso da mensagem que será lançada na exception quando a validação falhar.<br><br>
	 * 
	 * O enum {@link MsgType} define se será usada uma mensagem externa ou não, <br>
	 * se será usada apenas esta, se esta será usada em conjunto com a mensagem vinda da exceção, <br>
	 * como se dará a formação da concatenação das duas mensagens e se a externa será prefixo ou sufixo da mensagem da validação
	 */
	private MsgType msgType = MsgType.NO_USING_CUSTOM;
	
	/**
	 * Separador das mensagem quando a mensagem externa e a da validação forem utilizadas ao mesmo tempo na vaidação 
	 */
	private String separator = DEFAULT_SEPARATOR;

	/**
	 * Cria um novo item apenas com a mensagem da validação 
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
	 * Este método recebe um conjunto de Strings onde cada uma corresponde a uma <br>
	 * validação que será associada ao item onde por exemplo se forem passadas 3 Strings para o parametro <br>
	 * {@link #messages} internamente os índices de validação serão configurados como 0,1,2 <br>
	 * onde cada validação correspondente a um dos índices será associada a String de mesmo índice <br>
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
	 * só que configurando o separador das mensagens personalizada e da validação
	 * 
	 * @param separator separador da mensagem personalizada e da validaçao
	 * @param value valor a ser validado
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param messages lista de mensagens
	 */
	public ValidationItem(String separator, Object value,MsgType msgType,String... messages){
		this(value,msgType,messages);
		setSeparator(separator);
	}
	
	
	/**
	 * Cria um item que utilizará as validações de índices descritos no parametro indexesValidations <br><br>
	 * 
	 * Este construtor é usado geralmente no método addValidations de um executorValidation na ação de adição de validações
	 * 
	 * @param value valor a ser validado
	 * @param indexesValidations índices das validações que serão utilizadas para este item
	 */
	public ValidationItem(Object value,Integer... indexesValidations){
		setValue(value);
		setIndexValidations(indexesValidations);
		setMessages(createArrayWithMessage(null, indexesValidations.length));
	}
	
	/**
	 * Cria um item definindo os índices de validações<br>
	 * e um array de mensagens onde cada mensagem corresponde <br>
	 * a uma validação que será adicionada a este item segundo o conjunto <br>
	 * de índices de validações passados para o parametro indexesValidations
	 * 
	 * @param value valor a ser validado
	 * @param msgType tipo de uso da mesnagem personalizada
	 * @param messages mensagens de cada validação
	 * @param indexesValidations índices das validações que serão associadas a este item
	 */
	public ValidationItem(Object value,MsgType msgType,
			   String[] messages,Integer... indexesValidations){
		this(value,indexesValidations);
		setMessages(messages);
		setMsgType(msgType);
	}
	
	/**
	 * Cria um item da mesma forma que o construtor {@link #ValidationItem(Object, MsgType, String[], Integer...)} <br>
	 * só que configura o separador da mensagem personalizada e da validação
	 * 
	 * @param separator separador das mensagens personalizada e da validação
	 * @param value valor a ser validado
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param messages mensagens das validações
	 * @param indexesValidations índices das validações que serão associadas a este item
	 */
	public ValidationItem(String separator, Object value,MsgType msgType,
			String[] messages,Integer... indexesValidations){
		this(value,msgType,messages,indexesValidations);
		setSeparator(separator);
	} 
	
	/**
	 * Cria um novo item da mesma forma que o construtor {@link #ValidationItem(Object, MsgType, String[], Integer...)} <br>
	 * só que como só recebe uma mensagem então configura a mesma mensagem para todas as validações
	 * 
	 * @param value valor a ser validado
	 * @param message mensagem a ser configurada para as validações
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param indexesValidations índices das validações que serão associadas a este item
	 */
	public ValidationItem(Object value,String message,MsgType msgType,Integer... indexesValidations){
		this(value,indexesValidations);
		setMessages(createArrayWithMessage(message, indexesValidations.length));
		setMsgType(msgType);
	}
	
	/**
	 * Cria um item da mesma forma que o construtor {@link #ValidationItem(Object, String, MsgType, Integer...)} <br>
	 * só que configura o separador da mensagem personalizada e da validação
	 * 
	 * @param separator separador das mensagens personalizada e da validação 
	 * @param value valor a ser validado
	 * @param message mensagem a ser configurada para as validações
	 * @param msgType tipo de uso da mensagem personalizada
	 * @param indexesValidations índices das validações que serão associadas a este item
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
