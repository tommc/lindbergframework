package org.lindbergframework.validation.settings;

/**
 * 
 * @author Victor Lindberg
 *
 */
public enum ValidationMode {
	
	/**
	 * Lan�ar exce��es no final aninhando as exce��es. Este modo indica que um <br>
	 * executor validation vai aninhar as mensagens as exce��es que ocorrerem na <br>
	 * valida��o e lan�ar apenas no final da valida��o caso tenha havido alguma exce��o
	 */
	THROW_FINAL("THROW FINAL","Throw exceptions in the final"),
	
	/**
	 * Lan�ar exce��es imediatamente n�o aninhando as exce��es. Este modo indica <br>
	 * que um executor validation n�o vai aninhar as exce��es ou seja que assim que <br>
	 * alguma valida��o falhar ser� lan�ada uma exce��o
	 */
	THROW_IMMEDIATELY("THROW IMMEDIATELY","immediately Throw exceptions");
	
	public String nome,descricao;
	
	private ValidationMode(String nome,String descricao){
       setNome(nome);
       setDescricao(descricao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
