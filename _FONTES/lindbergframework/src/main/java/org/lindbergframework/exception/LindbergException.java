package org.lindbergframework.exception;

import java.util.List;
import java.util.Vector;

/**
 * 
 * Classe pai de todas as excecoes do framework
 * 
 * @author Victor Lindberg
 * 
 */
public class LindbergException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Separador de mensagens padrão. Se nenhum separador de mensagens <br>
	 * for configurado este é utilizado como padrão
	 */
	public static final String DEFAULT_SEPARATOR_MESSAGES = ";";

	/**
	 * Mensagens que compõem esta exceção 
	 */
	private List<String> msgs = new Vector<String>();
	
	/**
	 * Separador de mensagens. Esta String é utilizada para separar cada mensagem. <br>
	 * Por exemplo se o separador for ";" então a mensagem completa será msg1; msg2; msg3 
	 */
	private String separatorMessages = DEFAULT_SEPARATOR_MESSAGES; 

	public LindbergException() {
		//
	}

	public LindbergException(String msg) {
		super(msg);
		addMessage(msg);
	}

	public LindbergException(String msg, Throwable cause) {
		super(msg, cause);
		addMessage(msg);
	}

	public LindbergException(Throwable cause) {
		super(cause);
		addMessage(cause.getMessage());
	}

	public LindbergException(List<String> msgs) {
		addAllMessages(msgs);
	}

	public LindbergException(List<String> msgs, Throwable cause) {
		super(cause);
		addAllMessages(msgs);
	}

	/**
	 * adiciona uma nova mensagem a lista de mensagem que compõem a exceção
	 */
	public void addMessage(String msg) {
		synchronized (msg) {
			msgs.add(msg);
		}
	}

	/**
	 * adiciona uma nova mensagem a lista de mensagem em um determinado índice na lista 
	 */
	public void addMessage(int index, String msg) {
		synchronized (msg) {
			msgs.add(index, msg);
		}
	}

	/**
	 * adiciona todas as mensagem contidas na lista passada como argumento e adiciona <br>
	 * na lista de mensagens da exceção
	 */
	public void addAllMessages(List<String> msgs) {
	   synchronized (msgs) {
		   this.msgs.addAll(msgs);
	   }
	}

	/**
	 * retorna a lista de mensagem que compõem a exceção
	 */
	public List<String> getMessages() {
		return msgs;
	}

	/**
	 * retorna a mensagem tratada composta por todas as mensagens que compõem <br>
	 * a exceção em uma única String onde o {@link #separatorMessages} é usado <br>
	 * para separar cada mensagem na String retornada
	 */
	public String getMessageTreated() {
		String str = "";

		for (int i=0; i < msgs.size();i++)
			str = str + (i == 0 ? "" : " ") + msgs.get(i) + (i == msgs.size()-1 ? "" : separatorMessages);

		return str;
	}

	/**
	 * Retorna true se ha alguma mensagem na lista de mensagens da exceção
	 */
	public boolean hasMessages() {
		return !msgs.isEmpty();
	}

	@Override
	public String getMessage() {
		return getMessageTreated();
	}

	/**
	 * Lança esta exceção caso haja alguma mensagem na lista
	 */
	public void lancarEssaExcecaoSeHouverMensagens() {
		if (hasMessages())
			throw this;
	}

	@Override
	public String toString() {
		return getMessageTreated();
	}
	
	public void setSeparatorMessages(String separatorMessages) {
		this.separatorMessages = separatorMessages;
	}
	
	
	public String getSeparatorMessages() {
		return separatorMessages;
	}

}
