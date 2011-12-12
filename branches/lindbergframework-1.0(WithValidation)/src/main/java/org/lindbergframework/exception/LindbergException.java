package org.lindbergframework.exception;

import java.util.ArrayList;
import java.util.Arrays;
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

	public LindbergException(String msg, String... causeMessages) {
		super(msg);
		addAllMessages(causeMessages);
	}

	public LindbergException(String msg, Throwable cause, String... causeMessages) {
		super(msg, cause);
		addAllMessages(causeMessages);
	}

	public LindbergException(Throwable cause, String... causeMessages) {
		super(cause);
		addAllMessages(causeMessages);
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
	
	public void addAllMessages(String... msgs) {
	    addAllMessages(Arrays.asList(msgs));
	}

	public List<String> getMessages() {
		return msgs;
	}

	/**
	 * checks if contains error messages.
	 * 
	 * @return true if contains error message.
	 */
	public boolean containsMessages() {
		return !msgs.isEmpty();
	}

	/**
	 * Throws this exception if contais error messages.
	 */
	public void throwIfContainsErrorMessages() {
		if (containsMessages())
			throw this;
	}
	
	/**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        String msg = super.getMessage();
        StringBuilder stringBuilder = new StringBuilder();
        if (msg != null)
            stringBuilder.append(msg);

        if (containsMessages()) {
            if (msg != null)
                stringBuilder.append(":");
            stringBuilder.append(" [");
        }

        List<String> messages = getMessages();
        for (int i = 0; i < messages.size(); i++) {
            stringBuilder.append(messages.get(i));
            if (i != messages.size() - 1)
                stringBuilder.append(separatorMessages+" ");
        }

        if (containsMessages())
            stringBuilder.append("]");

        return stringBuilder.toString();
    }
    
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
	    String className = getClass().getName();
        String message = getMessage();
        return (message != null) ? (className + ": " + message) : className;
	}
	
	public void setSeparatorMessages(String separatorMessages) {
		this.separatorMessages = separatorMessages;
	}
	
	public String getSeparatorMessages() {
		return separatorMessages;
	}

}
