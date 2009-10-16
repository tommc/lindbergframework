package br.com.lindbergframework.validation.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.AbstractComparableValidation;
import br.com.lindbergframework.validation.IExecutorValidation;

/**
 * 
 * Validação para verificar comparações com números. <br>
 * A validação funciona baseado em um valor de comparação que pode ser passado via construtor ou pelo método <br>
 * <i>setValorComparacao</i>. Essa valor será comparado com o valor passado como argumento ao método <br>
 * validate dessa classe. <br><br>
 * 
 * A regra da comparação é definida pelo fator da comparação. Esse fator indica qual o resultado esperado <br>
 * da comparação.<br><br>
 * 
 * Abaixo são descritos os fatores de comparações possíveis.<br><br>
 * 
 * <b>Fator - Descrição</b>  <br>
 *    FatorComparacao.LESS_OR_EQUAL_THAN  ---- Menor ou igual que<br>
 *    FatorComparacao.LESS_THAN ---- Menor que<br>
 *    FatorComparacao.EQUAL ---- Igual a<br>
 *    FatorComparacao.GREATER_THAN ---- Maior que<br>
 *    FatorComparacao.GREATER_OR_EQUAL_THAN ---- Maior ou igual que<br><br>
 * 
 * Exemplo: Se valorComparacao for 10 e o fator de comparação for FatorComparacao.LESS_THAN <br>
 * a execução dessa validação em um {@link IExecutorValidation} passando os valores <br>
 * abaixo como argumento resultariam no resultado abaixo.<br><br>
 * 
 * <b>Valor - Resultado</b><br>
 *    8  ---- OK, pois 8 é menor do que o valorComparação (10, neste caso)<br>
 *    11 ---- Lança exception pois 11 não é menor do que o valorComparação (10, neste caso)<br>
 *    10 ---- Lança exception pois 10 não é menor do que o valorComparação (10, neste caso)
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
		String erro = String.format("Validação '%s' entre os valores "+valorComparacao.toString()+" e "+valor.toString()+" falhou" ,
				getFatorComparacao().getDescricao());
		
		throw new ValidationException(erro);
	}
	
	
}
