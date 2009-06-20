package br.com.lindbergframework.validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.settings.MsgType;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ValidationItem {

	public static final String SEPARADOR_PADRAO = ":";
	
	private Object valor;
	private List<String> messages = new Vector<String>();
	private Integer[] indexValidacoes = new Integer[] {0};
	private MsgType msgType = MsgType.NO_USING_CUSTOM;
	
	private String separador = SEPARADOR_PADRAO;
	
	public ValidationItem(Object valor){
		setValor(valor);
	}
	
	public ValidationItem(Object valor,MsgType msgType,String... messages){
		setValor(valor);
		setMessages(Arrays.asList(messages));
		setMsgType(msgType);
	}
	
	public ValidationItem(Object valor,Integer... indexesValidacoes){
		setValor(valor);
		setIndexValidacoes(indexesValidacoes);
	}
	
	public ValidationItem(Object valor,MsgType msgType,
			   List<String> messages,Integer... indexesValidacoes){
		this(valor,indexesValidacoes);
		setMessages(messages);
		setMsgType(msgType);
	}
	
	
	public ValidationItem(Object valor,String message,MsgType msgType,Integer... indexesValidacoes){
		this(valor,msgType,Arrays.asList(message),indexesValidacoes);
	}

	public ValidationItem(Object valor, List<String> messages,
			Integer[] indexValidacoes,String separador) {
		this.valor = valor;
		this.messages = messages;
		this.indexValidacoes = indexValidacoes;
		this.separador = separador;
	}
	
	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public List<String> getMessages() {
		return messages;
	}

	public Integer[] getIndexValidacoes() {
		return indexValidacoes;
	}

	public void setIndexValidacoes(Integer[] indexValidacoes) {
		this.indexValidacoes = indexValidacoes;
	}

	public String getSeparador() {
		return separador;
	}

	public void setSeparador(String separador) {
		this.separador = separador;
	}
	
	public void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}
	
	
	public MsgType getMsgType() {
		return msgType;
	}
	
}
