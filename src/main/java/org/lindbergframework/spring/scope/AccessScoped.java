package org.lindbergframework.spring.scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;

/**
 * Keeps alive the bean as long as it´s being accessed by a view.
 * 
 * @author Victor Lindberg
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Scope(Scopes.ACCESS)
public @interface AccessScoped {

}
