package br.com.lindbergframework.validation.settings;

/**
 * 
 * @author Victor Lindberg
 *
 */
public enum MsgType {
	 
	CUSTOM_ONLY("CUSTOM_ONLY",true,false,false),
	USING_CUSTOM_SUFFIX("USING_CUSTOM_SUFFIX",true,true,true),
	USING_CUSTOM_PREFIX("USING_CUSTOM_PREFIX",true,true,false),
	NO_USING_CUSTOM("NO_USING_CUSTOM",false,false,false);
	
	private String name;
	private boolean usandoMsgPersonalizada,
	                concatenarComMsgValidacao,
	                concatenarNoFinal;
	
	private MsgType(String name,boolean usandoMsgPersonalizada,
			         boolean concatenarComMsgValidacao, boolean concatenarNoFinal){
	   setName(name);
	   setUsandoMsgPersonalizada(usandoMsgPersonalizada);
	   setConcatenarComMsgValidacao(concatenarComMsgValidacao);
	   setConcatenarNoFinal(concatenarNoFinal);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public boolean isUsandoMsgPersonalizada() {
		return usandoMsgPersonalizada;
	}

	public void setUsandoMsgPersonalizada(boolean usandoMsgPersonalizada) {
		this.usandoMsgPersonalizada = usandoMsgPersonalizada;
	}

	public boolean isConcatenarComMsgValidacao() {
		return concatenarComMsgValidacao;
	}

	public void setConcatenarComMsgValidacao(boolean concatenarComMsgValidacao) {
		this.concatenarComMsgValidacao = concatenarComMsgValidacao;
	}

	public boolean isConcatenarNoFinal() {
		return concatenarNoFinal;
	}

	public void setConcatenarNoFinal(boolean concatenarNoFinal) {
		this.concatenarNoFinal = concatenarNoFinal;
	}
	
	

}
