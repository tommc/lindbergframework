package org.lindbergframework.persistence.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

import org.springframework.jdbc.core.StatementCreatorUtils;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class JdbcUtil {
	
	public static int[] javaTypesToSqlParameterTypes(Object... objectTypes){
	  int[] sqlTypes = new int[objectTypes.length];
	  for (int i = 0; i < objectTypes.length;i++){
		  Object param = objectTypes[i];
		  if (param == null){
			  sqlTypes[i] = Types.NULL;
			  continue;
		  }
			  
		  Class typeClass = param.getClass();
		  Integer sqlDateType = toSqlDateType(typeClass);
		  
		  if (sqlDateType != null){
			  sqlTypes[i] = sqlDateType;
		  }
		  else
		     sqlTypes[i] = StatementCreatorUtils.javaTypeToSqlParameterType(typeClass);
	  }
	  
	  return sqlTypes;
	}
	
	/**
	 * Return the sql type from Java type param. 
	 * 
	 * @param type
	 * @return sql date type or null if the type does not references a {@link Date}, {@link Time} or {@link Timestamp} type.
	 */
	public static Integer toSqlDateType(Class type){
		if (java.sql.Timestamp.class.isAssignableFrom(type))
			return Types.TIMESTAMP;
		else
			if (java.sql.Time.class.isAssignableFrom(type))
				return Types.TIME;
			else
		       if (java.util.Date.class.isAssignableFrom(type))
			      return Types.DATE;
		
		return null;
	}
	
	
	public static int[] javaTypesToSqlParameterTypes(Class... classTypes){
		int[] sqlTypes = new int[classTypes.length];
		for (int i = 0; i < classTypes.length;i++)
			sqlTypes[i] = StatementCreatorUtils.javaTypeToSqlParameterType(classTypes[i]);
		
		return sqlTypes;
	}

}
