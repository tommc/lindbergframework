package br.com.lindbergframework.exception;

import java.util.List;
import java.util.Vector;

/**
 * 
 * Classe pai de todas as excecoes da aplicação
 * 
 * @author Victor Lindberg
 * 
 */
public class LindbergException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
	public static final String DEFAULT_SEPARATOR_MESSAGES = ";";

	private List<String> msgs = new Vector<String>();
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

	public void addMessage(String msg) {
		msgs.add(msg);
	}

	public void addMessage(int index, String msg) {
		msgs.add(index, msg);
	}

	public void addAllMessages(List<String> msgs) {
		for (String msg : msgs)
			this.msgs.add(msg);
	}

	public List<String> getMessages() {
		return msgs;
	}

	public String getMessageTreated() {
		String str = "";

		for (int i=0; i < msgs.size();i++)
			str = str + (i == 0 ? "" : " ") + msgs.get(i) + (i == msgs.size()-1 ? "" : separatorMessages);

		return str;
	}

	public boolean hasMessages() {
		return !msgs.isEmpty();
	}

	@Override
	public String getMessage() {

		return getMessageTreated();
	}

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
