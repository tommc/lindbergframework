package org.lindbergframework.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.lindbergframework.validation.ValidationItem;
import org.lindbergframework.validation.settings.MsgType;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Valid {
	
	String value();
	
    String msg() default "";
	
	MsgType msgType() default MsgType.CUSTOM_ONLY;
	
	String separator() default ValidationItem.DEFAULT_SEPARATOR;
	

}
