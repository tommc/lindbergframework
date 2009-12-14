package org.lindbergframework.validation.annotation;

/**
 * 
 * Interface que define constantes para ações CRUD que podem ser reutilizadas para anotar beans para validações <br>
 * usando a annotation {@link Valid} no atributo action.
 * 
 * @author Victor Lindberg
 *
 */
public interface CrudActions {
	/**
	 * Constante que define a ação de insert 
	 */
	public static final String INSERT = "insert";
	
	/**
	 * Constante que define a ação de update 
	 */
	public static final String UPDATE = "update";
	
	/**
	 * Constante que define a ação de delete 
	 */
	public static final String DELETE = "delete";
	
	/**
	 * Constante que define a ação de research 
	 */
	public static final String RESEARCH = "research";

}
