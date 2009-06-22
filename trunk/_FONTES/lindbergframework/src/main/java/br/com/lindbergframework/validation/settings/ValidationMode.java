package br.com.lindbergframework.validation.settings;

/**
 * 
 * @author Victor Lindberg
 *
 */
public enum ValidationMode {
	
	LANCAR_NO_FINAL("FINAL","Lançar exceções no final"),
	LANCAR_IMEDIATAMENTE("IMEDIATAMENTE","Lançar exceções imediatamente");
	
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
