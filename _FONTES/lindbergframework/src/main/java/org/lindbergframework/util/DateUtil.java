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
	
	public static boolean isBeforeDespisingTime(Date date, Date date2){
       return despiseTime(date).before(despiseTime(date2));
	}
	
	public static boolean isAfterDespisingTime(Date date, Date date2){
		return despiseTime(date).after(despiseTime(date2));
	}
	
	public static boolean isEqualDespisingTime(Date date, Date date2){
		return despiseTime(date).equals(despiseTime(date2));
	}
	
	public static Date despiseTime(Date date){
		return new Date(date.getYear(),date.getMonth(),date.getDate());
	}
	
	

}
