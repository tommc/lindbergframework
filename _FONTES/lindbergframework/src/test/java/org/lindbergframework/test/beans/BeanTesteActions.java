package org.lindbergframework.test.beans;

import org.lindbergframework.validation.Types;
import org.lindbergframework.validation.annotation.CrudActions;
import org.lindbergframework.validation.annotation.Valid;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class BeanTesteActions {
	//Bean para demostração de definição de validações de acordo com ações.
	//Por exemplo podemos ter 3 campos em um bean onde 2 são validados quando a ação for X
	//e 1 quando a ação for Y. Outro exemplo seria um bean com 3 campos onde 2 são validados
	//de forma diferente de acordo com a ação. Quando a ação for X valida de um jeito mas 
	//quando a ação for Y valida de outro jeito. 
	//Este bean esta anotado definindo ações para cada validação. Na hora de executar as validações
	// usando uma implementação de IExecutorAnnotationEngine fazendo a execução através do método executeInActions
	//só serão processadas as validações que estejam relacionadas a no mínimo uma das ações passadas
	//como parametro para o método executeInActions. 
	
	//OBSERVAÇÃO: Veja que todos os campo são public, isto foi feito de propósito para 
	//demostrar que o framework verifica se o campo está acessível, se estiver o acessa diretamente
	//caso não esteja tentar invocar um método get do campo seguindo a especificação JAVABEAN.
	//Por exemplo um campo "private nome" o framework procura getNome
	
	//essa validação só será usada quando a ação for "cadastrar" ou quando a execução não for feita pelo método 
	//executeInActions de IExecutorAnnotationEngine ou nenhuma ação for definida no momento da execução
	@Valid(value = Types.NOT_NULL,msg = "falha campo1", actions = "cadastrar")
	public String campo1;
	
	//essa validação só será usada quando a ação for "cadastrar" ou "qualquerAcao" ou quando a execução não for feita pelo método 
	//executeInActions de IExecutorAnnotationEngine ou nenhuma ação for definida no momento da execução
	@Valid(value = Types.NOT_NULL, msg = "falha campo2",actions = {"consultar", "qualquerAcao"})
	public String campo2;
	
	//essa validação só será usada quando a ação for "cadastrar", "excluir" ou "qualquerAcao" ou quando a execução não for feita pelo método 
	//executeInActions de IExecutorAnnotationEngine ou nenhuma ação for definida no momento da execução
	@Valid(value = Types.NOT_NULL, msg = "falha campo3",actions = {"cadastrar", "excluir", "qualquerAcao"})
	public String campo3;
	
	//essa validação usa uma interface de constantes fornecida pelo framework para padronizar e 
	//facilitar a referencia a ações do tipo CRUD 
	@Valid(value = Types.NOT_NULL, msg = "falha campo4",actions = CrudActions.UPDATE)
	public String campo4;
	
	//essa validação não esta relacionada a nenhuma ação então só será executada quando a execução não realizada
	//referenciando nenhuma ação específica
	@Valid(value = Types.NOT_NULL, msg = "falha campo5")
	public String campo5;
	
	public BeanTesteActions(){
		//
	}

	
}
