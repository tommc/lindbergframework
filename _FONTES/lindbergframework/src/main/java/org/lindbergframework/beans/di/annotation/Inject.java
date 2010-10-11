package org.lindbergframework.beans.di.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * annotation that defines an bean auto injection in the lindberg IOC context.
 *  
 * @author Victor Lindberg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Inject {
	
    /**
     * Bean id for injection. The bean for injection must be annotated with @Bean annotation.
     */
	String value();

}
