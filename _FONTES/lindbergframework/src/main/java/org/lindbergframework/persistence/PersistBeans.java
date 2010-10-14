package org.lindbergframework.persistence;

/**
 * Constants interface with persistent beans id inside of persistence context.
 * 
 * @author Victor Lindberg
 *
 */
public interface PersistBeans {
	
    /**
     * bean id of default bean populator implementation.
     */
	public static final String MULT_LEVEL_BEAN_POPULATOR = "multLevelsBeanPopulator";
	
	/**
	 * bean id of default PersistenceTemplate implementation.
	 */
	public static final String DEFAULT_LINP_TEMPLATE = "defaultLinpTemplate";
	

}
