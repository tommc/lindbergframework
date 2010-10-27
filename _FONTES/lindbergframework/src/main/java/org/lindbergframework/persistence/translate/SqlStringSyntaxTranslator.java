package org.lindbergframework.persistence.translate;

/**
 * Interface to translator implementation to sql string syntax.
 * 
 * @author Victor Lindberg
 *
 */
public interface SqlStringSyntaxTranslator<T> extends SqlSyntaxTranslator<String,T>{
   
   /**
    * property separator token. 
    */
   public static final String PROPERTY_SEPARATOR = ".";
   
   /**
    * reserved string to property separator replacement.
    */
   public static final String PROPERTY_SEPARATOR_RESERVED_STRING = "$";
   
   /**
    * property separator replacement escape token.
    */
   public static final String PROPERTY_SEPARATOR_RESERVED_STRING_REPLACEMENT_ESCAPE = 
	                                 String.format("_%s_", PROPERTY_SEPARATOR_RESERVED_STRING);	
   
   /**
    * property separator replacement string.
    */
   public static final String PROPERTY_SEPARATOR_REPLACEMENT = String.format("%s%s", PROPERTY_SEPARATOR_RESERVED_STRING,
		   																			PROPERTY_SEPARATOR_RESERVED_STRING);
   
   /**
    * string pattern replacement to split properties based on property separator token. 
    */
   public static final String PROPERTY_PATTERN_SPLIT_SEPARATOR_REPLACEMENT = String.format("\\%s\\%s", PROPERTY_SEPARATOR_RESERVED_STRING,
		    																				   PROPERTY_SEPARATOR_RESERVED_STRING);
   /**
    * string pattern to split properties based on property separator token
    */
   public static final String PROPERTY_PATTERN_SPLIT_SEPARATOR = String.format("\\%s", PROPERTY_SEPARATOR);
   
}
