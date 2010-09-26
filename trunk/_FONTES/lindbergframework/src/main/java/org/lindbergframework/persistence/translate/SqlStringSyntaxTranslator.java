package org.lindbergframework.persistence.translate;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface SqlStringSyntaxTranslator<T> extends SqlSyntaxTranslator<String,T>{
	
   public static final String PARAMETER_STRING_RESERVED = "\\?";
   
   public static final String PROPERTY_SEPARATOR = ".";
   
   public static final String PROPERTY_SEPARATOR_STRING_RESERVED = "$";
   
   public static final String PROPERTY_SEPARATOR_STRING_RESERVED_REPLACEMENT_ESCAPE = 
	                                 String.format("_%s_", PROPERTY_SEPARATOR_STRING_RESERVED);	
   
   public static final String PROPERTY_SEPARATOR_REPLACEMENT = String.format("%s%s", PROPERTY_SEPARATOR_STRING_RESERVED,
		   																			PROPERTY_SEPARATOR_STRING_RESERVED);
   
   public static final String PROPERTY_PATTERN_SPLIT_SEPARATOR_REPLACEMENT = String.format("\\%s\\%s", PROPERTY_SEPARATOR_STRING_RESERVED,
		    																				   PROPERTY_SEPARATOR_STRING_RESERVED);

   public static final String PROPERTY_PATTERN_SPLIT_SEPARATOR = String.format("\\%s", PROPERTY_SEPARATOR);
   
}
