package org.lindbergframework.validation.settings;

import org.lindbergframework.validation.IExecutorValidationItems;

/**
 * 
 * Modo de execução de validações. Este enum indica a um {@link IExecutorValidationItems} <br>
 * como deve executar as validações e qual será o critério adotado para lançamento <br>
 * de exceções que sejam decorrentes de falhas das validaçoes
 * 
 * @author Victor Lindberg
 *
 */
public enum ValidationMode {
	
	/**
	 * Lançar exceções no final aninhando as exceções. Este modo indica que um <br>
	 * executor validation vai aninhar as mensagens as exceções que ocorrerem na <br>
	 * validação e lançar apenas no final da validação caso tenha havido alguma exceção
	 */
	THROW_FINAL("THROW FINAL","Throw exceptions in the final"),
	
	/**
	 * Lançar exceções imediatamente não aninhando as exceções. Este modo indica <br>
	 * que um executor validation não vai aninhar as exceções ou seja que assim que <br>
	 * alguma validação falhar será lançada uma exceção
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
