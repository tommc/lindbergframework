package org.lindbergframework.beans.di.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * annotation that defines beans in the lindberg IOC context.
 * 
 * @author Victor Lindberg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Bean {
	
    /**
     * Bean id.
     */
	String value();

	/**
	 * True id the bean is a singleton instance. Default value is false.
	 * @return
	 */
	boolean singleton() default false;
	
}
