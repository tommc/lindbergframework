package org.lindbergframework.util;

import org.springframework.util.NumberUtils;

/**
 * Classe utilitária com operações para manipular Number's
 * 
 * @author Victor Lindberg
 *
 */
@SuppressWarnings("unchecked")
public class NumberUtil {
	
	public static <E extends Number> E convert(Class<E> classReturn,Object objToCAst){
		return (E) NumberUtils.parseNumber(objToCAst.toString(), classReturn);
	}

}
