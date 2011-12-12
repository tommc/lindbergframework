package org.lindbergframework.util;

import java.util.Date;

/**
 * Classe utilitária com métodos para manipulação de datas
 * 
 * @author Victor Lindberg
 *
 */
@SuppressWarnings("deprecation")
public class DateUtil {
	
	/**
	 * Compara a date com date2 desprezando a hora, minuto e <br>
	 * segundo de cada uma de modo que apenas o dia, mês e ano são levados em conta. <br><br>
	 * 
	 * Retorna <i>true</i> caso <b>date</b> seja anterior a <b>date2</b>. <br><br>
	 * 
	 * Esse método difere do método <i>before</i> da classe {@link Date} pelo fato de que <br>
	 * o método <i>before</i> leva em conta o tempo (hora:min:segun:milisegundo) o que faz com que <br>
	 * uma data <b>1/1/2001 HR 10:00...</b> seja menor do que <b><b>1/1/2001 HR 10:30...</b></b> quando na verdade <br>
	 * muitas vezes precisamos comparar apenas se a data é anterior. <br>
	 * Este método corrige isso e considera apenas neste caso por exemplo <b>1/1/2001</b>
	 * 
	 * @param date
	 * @param date2
	 * @return
	 */
	public static boolean isBeforeDespisingTime(Date date, Date date2){
       return despiseTime(date).before(despiseTime(date2));
	}
	
	/**
	 * Compara a date com date2 desprezando a hora, minuto e <br>
	 * segundo de cada uma de modo que apenas o dia, mês e ano são levados em conta. <br><br>
	 * 
	 * Retorna <i>true</i> caso <b>date</b> seja posterior a <b>date2</b>. <br><br>
	 * 
	 * Esse método difere do método <i>after</i> da classe {@link Date} pelo fato de que <br>
	 * o método <i>after</i> leva em conta o tempo (hora:min:segun:milisegundo) o que faz com que <br>
	 * uma data <b>1/1/2001 HR 10:30...</b> seja maior do que <b><b>1/1/2001 HR 10:00...</b></b> quando na verdade <br>
	 * muitas vezes precisamos comparar apenas se a data é posterior. <br>
	 * Este método corrige isso e considera apenas neste caso por exemplo <b>1/1/2001</b>
	 * 
	 * @param date
	 * @param date2
	 * @return
	 */
	public static boolean isAfterDespisingTime(Date date, Date date2){
		return despiseTime(date).after(despiseTime(date2));
	}

	/**
	 * Compara a date com date2 desprezando a hora, minuto e <br>
	 * segundo de cada uma de modo que apenas o dia, mês e ano são levados em conta. <br><br>
	 * 
	 * Retorna <i>true</i> caso <b>date</b> seja igual a <b>date2</b>. <br><br>
	 * 
	 * Esse método difere do método <i>equal</i> da classe {@link Date} pelo fato de que <br>
	 * o método <i>equal</i> leva em conta o tempo (hora:min:segun:milisegundo) o que faz com que <br>
	 * uma data <b>1/1/2001 HR 10:00...</b> seja diferente de <b><b>1/1/2001 HR 10:30...</b></b> quando na verdade <br>
	 * muitas vezes precisamos comparar apenas se a data é igual. <br>
	 * Este método corrige isso e considera apenas neste caso por exemplo <b>1/1/2001</b>
	 * 
	 * @param date
	 * @param date2
	 * @return
	 */
	public static boolean isEqualDespisingTime(Date date, Date date2){
		return despiseTime(date).equals(despiseTime(date2));
	}
	
	/**
	 * Retorna uma data baseada na data passada como argumento desconsiderando <br>
	 * hora:min:seg:milisegund da data ao qual a nova data foi baseada 
	 * 
	 * @param date
	 * @return
	 */
	public static Date despiseTime(Date date){
		return new Date(date.getYear(),date.getMonth(),date.getDate());
	}
	

}
