package org.lindbergframework.validation.impl;

import java.math.BigDecimal;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.NumberUtil;
import org.lindbergframework.validation.AbstractComparableValidation;
import org.lindbergframework.validation.IExecutorValidationItems;
import org.lindbergframework.validation.Types;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


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
 * a execução dessa validação em um {@link IExecutorValidationItems} passando os valores <br>
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
@Component(Types.NUMBER_COMPARABLE)
@Scope("prototype")
public class NumberComparableValidation extends AbstractComparableValidation<Number>{

	public NumberComparableValidation(){
		//
	}
	
	public NumberComparableValidation(Number valorComparacao, FatorComparacao fatorComparacao) {
		super(fatorComparacao);
		setValorComparacao(valorComparacao);
	}

	public void validate(Comparable<Number> valor) throws ValidationException {
		if (valor == null)
			return;
		
		BigDecimal bigValor = NumberUtil.convert(BigDecimal.class, valor);
		BigDecimal bigValorComparacao = NumberUtil.convert(BigDecimal.class, getValorComparacao());
		
		int resultComparacao = bigValor.compareTo(bigValorComparacao);
		int fator = getFatorComparacao().getFator();
		
		if ((fator == FatorComparacao.EQUAL.getFator() ||
			fator == FatorComparacao.GREATER_THAN.getFator() ||
			fator == FatorComparacao.LESS_THAN.getFator()) && resultComparacao != fator)
			throwException(valor);
		
		if (fator == FatorComparacao.GREATER_OR_EQUAL_THAN.getFator() && 
				resultComparacao < FatorComparacao.EQUAL.getFator())
			throwException(valor);
		
		if (fator == FatorComparacao.LESS_OR_EQUAL_THAN.getFator() && 
				resultComparacao > FatorComparacao.EQUAL.getFator())
			throwException(valor);
	}
	
	private void throwException(Comparable<Number> valor){
		String erro = String.format("Validação '%s' entre os valores "+getValorComparacao().toString()+" e "+valor.toString()+" falhou" ,
				getFatorComparacao().getDescricao());
		
		throw new ValidationException(erro);
	}

	
}
