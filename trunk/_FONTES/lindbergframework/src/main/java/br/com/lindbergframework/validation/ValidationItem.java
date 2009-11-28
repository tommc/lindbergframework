package br.com.lindbergframework.validation;

import br.com.lindbergframework.validation.settings.MsgType;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ValidationItem {
 
	public static final String DEFAULT_SEPARATOR = ":";
	
	private Object value;
	private String[] messages = new String[0];
	private Integer[] indexValidations = new Integer[] {0};
	private MsgType msgType = MsgType.NO_USING_CUSTOM;
	
	private String separator = DEFAULT_SEPARATOR;
	
	public ValidationItem(Object value){
		setValue(value);
	}
	
	public ValidationItem(Object value,String msg){
		this(value,MsgType.CUSTOM_ONLY,msg);
	}
	
	public ValidationItem(Object value,MsgType msgType,String... messages){
		setValue(value);
		setMessages(messages);
		setMsgType(msgType);
		Integer[] indexes = new Integer[messages.length];
		for (int i = 0;i < messages.length;i++)
			indexes[i] = i;
		setIndexValidations(indexValidations);
	}
	
	public ValidationItem(String separator, Object value,MsgType msgType,String... messages){
		this(value,msgType,messages);
		setSeparator(separator);
	}
	
	
	
	public ValidationItem(Object value,Integer... indexesValidations){
		setValue(value);
		setIndexValidations(indexValidations);
		String[] msgs = new String[indexesValidations.length];
		for (int i = 0; i < indexesValidations.length;i++)
			msgs[i] = null;
		setMessages(msgs);
	}
	
	public ValidationItem(Object value,MsgType msgType,
			   String[] messages,Integer... indexesValidations){
		this(value,indexesValidations);
		setMessages(messages);
		setMsgType(msgType);
	}
	
	public ValidationItem(String separator, Object value,MsgType msgType,
			String[] messages,Integer... indexesValidations){
		this(value,msgType,messages,indexesValidations);
		setSeparator(separator);
	} 
	
	public ValidationItem(Object value,String message,MsgType msgType,Integer... indexesValidations){
		this(value,indexesValidations);
		setMessages(createArrayWithMessage(message, indexesValidations.length));
		setMsgType(msgType);
	}
	
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
	
	private String[] createArrayWithMessage(String message,int length){
	   String[] array = new String[length];
	   
	   for (int  i = 0;i < length;i++)
		   array[i] = message;
	   
	   return array;
	}
	
}
