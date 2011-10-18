package org.lindbergframework.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * Base exception of lindbergframewrok. This exception adds several
 * error messages. Contains utilitary methods to manipulate this messages. 
 * 
 * @author Victor Lindberg
 * 
 */
public class LindbergException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default separator messages.
	 */
	public static final String DEFAULT_SEPARATOR_MESSAGES = "; ";

	/**
	 * Error messages of this exception.
	 */
	private List<String> msgs = new ArrayList<String>();
	
	/**
	 * separator message specified. Default is DEFAULT_SEPARATOR_MESSAGES constant.
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
	 * adds a new error message.
	 * 
	 * @param msg new error message.
	 */
	public void addMessage(String msg) {
		synchronized (msg) {
			msgs.add(msg);
		}
	}

	/**
	 * adds a new error message for specified index.
	 * 
	 * @param index index of message position int the error list.
	 * @param msg error message.
	 */
	public void addMessage(int index, String msg) {
		synchronized (msg) {
			msgs.add(index, msg);
		}
	}

	/**
	 * adds all message from specified message collection. 
	 * @param msgs error message collection.
	 */
	public void addAllMessages(Collection<String> msgs) {
	   synchronized (msgs) {
		   this.msgs.addAll(msgs);
	   }
	}

	public List<String> getMessages() {
		return msgs;
	}

	/**
	 * get message treated using {@link #separatorMessages} attribute.
	 * 
	 * @return message treated using {@link #separatorMessages} attribute.
	 */
	public String getMessageTreated() {
		String str = "";

		for (int i=0; i < msgs.size();i++)
			str = str + msgs.get(i) + (i == msgs.size()-1 ? "" : separatorMessages);

		return str;
	}

	/**
	 * checks if contains error messages.
	 * 
	 * @return true if contains error message.
	 */
	public boolean hasMessages() {
		return !msgs.isEmpty();
	}

	/**
	 * Get message treated for this exception.
	 * @return message treated for this exception.
	 */
	@Override
	public String getMessage() {
		return getMessageTreated();
	}

	/**
	 * Throws this exception if contais error messages.
	 */
	public void throwIfContainsErrorMessages() {
		if (hasMessages())
			throw this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
	    String className = getClass().getName();
        String message = getMessageTreated();
        return (message != null) ? (className + ": " + message) : className;
	}
	
	public void setSeparatorMessages(String separatorMessages) {
		this.separatorMessages = separatorMessages;
	}
	
	
	public String getSeparatorMessages() {
		return separatorMessages;
	}

}
