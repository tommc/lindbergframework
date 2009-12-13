package org.lindbergframework.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.lindbergframework.spring.LindbergSpringFactory;
import org.lindbergframework.validation.Types;
import org.lindbergframework.validation.ValidationItem;
import org.lindbergframework.validation.settings.MsgType;

/**
 * Annotation que define uma validação a um campo
 * 
 * @see 
 *   {@link Types}
 *   
 * @author Victor Lindberg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Valid {
	
	/**
	 * id do bean de validação dentro do contexto spring em {@link LindbergSpringFactory} ou <br>
	 * caminho completamente qualificado da classe do bean de validação.<br>
	 * Use a interface {@link Types} para obter um conjunto de constantes de ID´s <br>
	 * dos beans de validação padrão definidos dentro do contexto do spring em {@link LindbergSpringFactory}<br><br>
	 * 
	 * Pode ser definido também o caminho totalmente qualificado da clase de bean de validação. <br><br>
	 * 
	 * Por exemplo: value="org.lindbergframework.validation.impl.NotNullValidation"
	 */
	String value();
	
	/**
	 * Mensagem da validação. Caso este atributo não seja informado a mensagem <br>
	 * da exceção originada da validação é usada como padrão
	 */
    String msg() default "";

    /**
     * Tipo indicando como a mensagem deve ser usada      
     */
	MsgType msgType() default MsgType.CUSTOM_ONLY;
	
	/**
	 * Separador da mensagem de validação e a mensagem personalizada que é definida no atributo <br>
	 * <i>msg</i> dessa annotation. O separador só é utilizado quando a mensagem da exceção e <br>
	 * da validação são utilizadas em conjunto
	 */
	String separator() default ValidationItem.DEFAULT_SEPARATOR;
	

}
