package br.com.lindbergframework.validation;

import br.com.lindbergframework.validation.settings.MsgType;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ValidationItem {
 
	public static final String SEPARADOR_PADRAO = ":";
	
	private Object valor;
	private String[] messages = new String[0];
	private Integer[] indexValidacoes = new Integer[] {0};
	private MsgType msgType = MsgType.NO_USING_CUSTOM;
	
	private String separador = SEPARADOR_PADRAO;
	
	public ValidationItem(Object valor){
		setValor(valor);
	}
	
	public ValidationItem(Object valor,String msg){
		this(valor,MsgType.CUSTOM_ONLY,msg);
	}
	
	public ValidationItem(Object valor,MsgType msgType,String... messages){
		setValor(valor);
		setMessages(messages);
		setMsgType(msgType);
		Integer[] indexes = new Integer[messages.length];
		for (int i = 0;i < messages.length;i++)
			indexes[i] = i;
		setIndexValidacoes(indexes);
	}
	
	public ValidationItem(Object valor,String separador,MsgType msgType,String... messages){
		this(valor, msgType, messages);
		setSeparador(separador);
	}
	
	public ValidationItem(Object valor,Integer... indexesValidacoes){
		setValor(valor);
		setIndexValidacoes(indexesValidacoes);
		String[] msgs = new String[indexesValidacoes.length];
		for (int i = 0; i < indexesValidacoes.length;i++)
			msgs[i] = null;
		setMessages(msgs);
	}
	
	public ValidationItem(Object valor,MsgType msgType,
			   String[] messages,Integer... indexesValidacoes){
		this(valor,indexesValidacoes);
		setMessages(messages);
		setMsgType(msgType);
	} 
	
	public ValidationItem(MsgType msgType,Object valor,String separador,
			   String[] messages,Integer... indexesValidacoes){
		this(valor,msgType,messages,indexesValidacoes);
		setSeparador(separador);
	}
	
	 
	public ValidationItem(Object valor,String message,MsgType msgType,Integer... indexesValidacoes){
		this(valor,msgType,new String[] {message},indexesValidacoes);
	}

	public ValidationItem(Object valor, String[] messages,
			Integer[] indexValidacoes,String separador) {
		setValor(valor);
		setMessages(messages);
		setIndexValidacoes(indexValidacoes);
		setSeparador(separador);
	}
	
	public Object getValor() {
		return valor;
	}

	private void setMessages(String[] messages) {
		this.messages = messages;
	}
	
	private void setValor(Object valor) {
		this.valor = valor;
	}

	public String[] getMessages() {
		return messages;
	}

	public Integer[] getIndexValidacoes() {
		return indexValidacoes;
	}

	private void setIndexValidacoes(Integer[] indexValidacoes) {
		this.indexValidacoes = indexValidacoes;
	}

	public String getSeparador() {
		return separador;
	}

	private void setSeparador(String separador) {
		this.separador = separador;
	}
	
	private void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}
	
	public MsgType getMsgType() {
		return msgType;
	}
	
}
