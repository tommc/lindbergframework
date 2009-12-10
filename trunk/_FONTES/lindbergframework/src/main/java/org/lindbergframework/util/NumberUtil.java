package org.lindbergframework.util;

import java.math.BigDecimal;

import org.springframework.util.NumberUtils;

/**
 * Classe utilitária com operações para manipular Number's
 * 
 * @author Victor Lindberg
 *
 */
@SuppressWarnings("unchecked")
public class NumberUtil {
	
	/**
	 * Efetua a conversão de um objeto para o tipo de retorno necessário definido pelo tipo genérico <i>E</i>.<br><br>
	 * 
	 * Por exemplo:<br>
	 * BigDecimal bigValor = NumberUtil.convert(BigDecimal.class, valor);
	 *  
	 * @param <E> tipo esperado como resultado da conversão
	 * @param classReturn tipo de classe de E
	 * @param objToCAst objeto a sofrer a conversão
	 * @return
	 */
	public static <E extends Number> E convert(Class<E> classReturn,Object objToCAst){
		return (E) NumberUtils.parseNumber(objToCAst.toString(), classReturn);
	}

}
