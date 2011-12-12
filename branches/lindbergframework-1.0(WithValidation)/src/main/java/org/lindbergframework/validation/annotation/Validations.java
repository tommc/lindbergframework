package org.lindbergframework.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Annotation que é usada para a definição de várias annotation Valid para um mesmo campo
 * 
 * @author Victor Lindberg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Validations {

	/**
	 * Conjunto de annotations Valid que definem as validações para o campo anotado com Validations
	 */
	Valid[] value();
	
}
