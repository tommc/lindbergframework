package org.lindbergframework.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.lindbergframework.validation.Types;
import org.lindbergframework.validation.Item;
import org.lindbergframework.validation.annotation.engine.IExecutorAnnotationEngine;
import org.lindbergframework.validation.context.LindbergSpringValidationsBeanFactory;
import org.lindbergframework.validation.settings.MsgType;

/**
 * Annotation que define uma validação a ser associada a um campo
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
	 * id do bean de validação dentro do contexto spring em {@link LindbergSpringValidationsBeanFactory} ou <br>
	 * caminho completamente qualificado da classe do bean de validação.<br>
	 * Use a interface {@link Types} para obter um conjunto de constantes de ID´s <br>
	 * dos beans de validação padrão definidos dentro do contexto do spring em {@link LindbergSpringValidationsBeanFactory}<br><br>
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
	String separator() default Item.DEFAULT_SEPARATOR;
	
	/**
	 * Atributo que deve ser definido quando a validação deve ser considerada apenas em determinada(s) ação (ções). <br><br>
	 * 
	 *  Por exemplo: Um campo <i>xxx</i> tem 2 validações <i>notnuul</i> e <i>hasbenull</i>. <br>
	 *  Supomos que a primeira validação só seja usada na ação de insert e update <br>
	 *  e a segunda só seja usada na ação de research (consultar) e checarPermissao e nada mais que isso. <br><br>
	 *  
	 *  Então definimos esse atributo com o nome das ações que a validação definida pela annotation será usada.<br><br>
	 *  
	 *  (arroba)Validations({@Valid(value = Types.NOT_NULL, actions = {"insert","update"}),<br>
	 *		     (arroba)Valid(value = Types.HAS_BE_NULL, actions = {"research","checarPermissao"})})<br>
	 *   private String xxx;<br><br>
	 *   
	 *   A interface {@link CrudActions} define alguns cnstantes para a padronizacao de ações do tipo crud <br>
	 *   que neste caso ficaria da seguinte forma<br><br>
	 *   
	 *   (arroba)Validations({@Valid(value = Types.NOT_NULL, actions = {CrudActions.INSERT,CrudActions.UPDATE}), <br>
	 *		     (arroba)Valid(value = Types.HAS_BE_NULL, actions = {CrudActions.RESEARCH,"checarPermissao"})})<br>
	 *   private String xxx; <br><br>
	 *   
	 *   Para fazer valer a definição das ações no processamento das ações é necessário que seja utilizado o método <br>
	 *   que executeInActions da interface {@link IExecutorAnnotationEngine}
	 * 
	 */
	String[] actions() default {};

}
