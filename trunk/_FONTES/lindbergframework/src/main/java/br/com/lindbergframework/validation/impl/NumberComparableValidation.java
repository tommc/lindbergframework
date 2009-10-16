package br.com.lindbergframework.validation.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.AbstractComparableValidation;
import br.com.lindbergframework.validation.IExecutorValidation;

/**
 * 
 * Valida��o para verificar compara��es com n�meros. <br>
 * A valida��o funciona baseado em um valor de compara��o que pode ser passado via construtor ou pelo m�todo <br>
 * <i>setValorComparacao</i>. Essa valor ser� comparado com o valor passado como argumento ao m�todo <br>
 * validate dessa classe. <br><br>
 * 
 * A regra da compara��o � definida pelo fator da compara��o. Esse fator indica qual o resultado esperado <br>
 * da compara��o.<br><br>
 * 
 * Abaixo s�o descritos os fatores de compara��es poss�veis.<br><br>
 * 
 * <b>Fator - Descri��o</b>  <br>
 *    FatorComparacao.LESS_OR_EQUAL_THAN  ---- Menor ou igual que<br>
 *    FatorComparacao.LESS_THAN ---- Menor que<br>
 *    FatorComparacao.EQUAL ---- Igual a<br>
 *    FatorComparacao.GREATER_THAN ---- Maior que<br>
 *    FatorComparacao.GREATER_OR_EQUAL_THAN ---- Maior ou igual que<br><br>
 * 
 * Exemplo: Se valorComparacao for 10 e o fator de compara��o for FatorComparacao.LESS_THAN <br>
 * a execu��o dessa valida��o em um {@link IExecutorValidation} passando os valores <br>
 * abaixo como argumento resultariam no resultado abaixo.<br><br>
 * 
 * <b>Valor - Resultado</b><br>
 *    8  ---- OK, pois 8 � menor do que o valorCompara��o (10, neste caso)<br>
 *    11 ---- Lan�a exception pois 11 n�o � menor do que o valorCompara��o (10, neste caso)<br>
 *    10 ---- Lan�a exception pois 10 n�o � menor do que o valorCompara��o (10, neste caso)
 *    
 * 
 * @author Victor Lindberg
 *
 */
@Component("numberComparableValidation")
@Scope("prototype")
public class NumberComparableValidation extends AbstractComparableValidation<Number>{

	private Number valorComparacao = 0;
	
	public NumberComparableValidation(){
		//
	}
	
	public NumberComparableValidation(Number valorComparacao, FatorComparacao fatorComparacao) {
		super(fatorComparacao);
		this.valorComparacao = valorComparacao;
	}

	public void validate(Comparable<Number> valor) throws ValidationException {
		int resultComparacao = valor.compareTo(valorComparacao);
		int fator = getFatorComparacao().getFator();
		if ((fator == 0 ||
			fator == 1 ||
			fator == -1) && resultComparacao != fator)
			throwException(valor);
		
		if (fator == 2 && resultComparacao < 0)
			throwException(valor);
		
		if (fator == -2 && resultComparacao > 0)
			throwException(valor);
	}
	
	public void setValorComparacao(Number valorComparacao) {
		this.valorComparacao = valorComparacao;
	}
	
	
	public Number getValorComparacao() {
		return valorComparacao;
	}
	
	private void throwException(Comparable<Number> valor){
		String erro = String.format("Valida��o '%s' entre os valores "+valorComparacao.toString()+" e "+valor.toString()+" falhou" ,
				getFatorComparacao().getDescricao());
		
		throw new ValidationException(erro);
	}
	
	
}
