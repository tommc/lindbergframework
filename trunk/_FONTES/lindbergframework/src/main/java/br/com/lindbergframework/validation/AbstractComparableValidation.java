package br.com.lindbergframework.validation;


/**
 * Valida��o para compara��o de objetos. Essa classe fornece a base as valida��es <br>
 * que implementam compara��es entre objetos sejam eles valores ou n�o.<br><br>
 * 
 * Essa classe fornce o enum {@link FatorComparacao} que representa <br>
 * os tipos de compara��o como igual, maior que, maior ou igual que, etc..
 * 
 * @author Victor Lindberg
 *
 */
public abstract class AbstractComparableValidation<E> implements IComparableValidation<E>{
	
	/**
	 * Tipo de compara��o que ser� utilizado para a valida��o. <br>
	 * O padr�o � FatorComparacao.EQUAL
	 */
	private FatorComparacao fatorComparacao = FatorComparacao.EQUAL;
	
	/**
	 * Valor para compara��o
	 */
	private E valorComparacao;
	
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
    
   public E getValorComparacao() {
	  return valorComparacao;
   }
   
   public void setValorComparacao(E valorComparacao) {
	   this.valorComparacao = valorComparacao;
   };
    
    
    /**
     * Enum que representa os tipos de compra��o poss�veis para a valida��o 
     * 
     * @author Victor Lindberg
     *
     */
	public enum FatorComparacao{
		/**
		 * Menor ou igual que <=
		 */
		LESS_OR_EQUAL_THAN (-2,"menor ou igual que"),
		
		/**
		 * Menor que < 
		 */
		LESS_THAN (-1,"menor que"),
		
		/**
		 * igual =
		 */
		EQUAL (0,"igual a"),
		
		/**
		 * Maior que >
		 */
		GREATER_THAN(1,"maior que"),
		
		/**
		 * Maior ou igual que >=
		 */
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
