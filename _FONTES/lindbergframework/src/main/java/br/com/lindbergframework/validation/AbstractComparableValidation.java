package br.com.lindbergframework.validation;


/**
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractComparableValidation<E> implements IComparableValidation<E>{
	
	private FatorComparacao fatorComparacao = FatorComparacao.EQUAL;
	
	public AbstractComparableValidation(){
		//
	}
	
	public AbstractComparableValidation(FatorComparacao fatorComparacao){
		this.fatorComparacao = fatorComparacao;
	}
	
    public void setFatorComparacao(FatorComparacao fatorComparacao) {
		this.fatorComparacao = fatorComparacao;
	}
    
    public FatorComparacao getFatorComparacao() {
		return fatorComparacao;
	}
	
	public enum FatorComparacao{
		LESS_OR_EQUAL_THAN (-2,"menor ou igual que"),
		LESS_THAN (-1,"menor que"),
		EQUAL (0,"igual a"),
		GREATER_THAN(1,"maior que"),
		GREATER_OR_EQUAL_THAN (2,"maior ou igual que");
		
		private int fator;
		private String descricao;
		
		private FatorComparacao(int fatorComparacao,String descricao){
			fator = fatorComparacao;
			this.descricao = descricao;
		}
		
		public int getFator() {
			return fator;
		}
		
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
	}

}
