package org.lindbergframework.validation.impl;

import java.math.BigDecimal;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.util.NumberUtil;
import org.lindbergframework.validation.AbstractComparableValidation;
import org.lindbergframework.validation.IExecutorValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


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
		String erro = String.format("Valida��o '%s' entre os valores "+getValorComparacao().toString()+" e "+valor.toString()+" falhou" ,
				getFatorComparacao().getDescricao());
		
		throw new ValidationException(erro);
	}

	
}
