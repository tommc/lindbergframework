package org.lindbergframework.persistence.sql;

/**
 * Function abstraction extension for stored functions that returns a cursor as result.
 * 
 * @author Victor Lindberg
 * 
 */
public class SqlFunctionForCursor extends SqlFunction {

    /**
     * class to map each row in the cursor's result as a bean.
     */
	private Class beanResult;

	public SqlFunctionForCursor(String name){
	    super(name);
	}
	
	/**
     * creates a function definition for specified output cursors parameters.
     *  
     * @param outCursorParams output cursors parameters.
     */
	public SqlFunctionForCursor(SqlOutCursorParam... outCursorParams) {
		super(outCursorParams);
	}

	/**
     * creates a function definition for specified id, catalog, schema, package,
     * name, name of the result parameter, class to map the result´s cursor and output cursors parameters.
     * 
     * @param id function id.
     * @param catalog function catalog.
     * @param schema function schema.
     * @param pack function package.
     * @param name function name.
     * @param nameResult name of the result parameter.
     * @param beanResult class to map each row in the cursor's result as a bean.
     * @param outCursorParams output cursors parameters.
     */
	public SqlFunctionForCursor(String id, String catalog, String schema, String pack,
			String name, String nameResult, Class beanResult,SqlOutCursorParam... outCursorParams) {
	   super(id,catalog,schema,pack,name,nameResult,outCursorParams);	
	   this.beanResult = beanResult;
	}
	
	/**
	 * creates a function definition for specified  catalog, schema, package,
	 * name, name of the result parameter, class to map the result´s cursor and output cursors parameters.
	 * 
	 * @param catalog function catalog.
	 * @param schema function schema.
	 * @param pack function package.
	 * @param name function name.
	 * @param nameResult name of the result parameter.
	 * @param beanResult class to map each row in the cursor's result as a bean.
	 * @param outCursorParams output cursors parameters.
	 */
	public SqlFunctionForCursor(String catalog, String schema, String pack,
			String name, String nameResult, Class beanResult,SqlOutCursorParam... outCursorParams) {
		this(null, catalog, schema, pack, name, nameResult, beanResult,outCursorParams);
	}

	/**
	 * creates a function definition for specified  name, 
	 * name of the result parameter, class to map the result´s cursor and output cursors parameters.
	 * 
	 * @param name function name.
	 * @param nameResult name of the result parameter.
	 * @param beanResult class to map each row in the cursor's result as a bean.
	 * @param outCursorParams output cursors parameters.
	 */
	public SqlFunctionForCursor(String name, String nameResult, Class beanResult,SqlOutCursorParam... outCursorParams) {
		super(name, nameResult,outCursorParams);
		this.beanResult = beanResult;
	}

	/**
	 * creates a function definition for specified package,
	 * name, name of the result parameter, class to
	 * map the result´s cursor and output cursors parameters.
	 * 
	 * @param pack function package.
	 * @param name function name.
	 * @param nameResult name of the result parameter.
	 * @param beanResult class to map each row in the cursor's result as a bean.
	 * @param outCursorParams output cursors parameters.
	 */
	public SqlFunctionForCursor(String pack, String name, String nameResult,
			Class beanResult,SqlOutCursorParam... outCursorParams) {
		super(pack, name, nameResult,outCursorParams);
		this.beanResult = beanResult;
	}

	/**
     * creates a function definition for specified  schema, package,
     * name, name of the result parameter, class to map the result´s cursor and output cursors parameters.
     * 
     * @param schema function schema.
     * @param pack function package.
     * @param name function name.
     * @param nameResult name of the result parameter.
     * @param beanResult class to map each row in the cursor's result as a bean.
     * @param outCursorParams output cursors parameters.
     */
	public SqlFunctionForCursor(String schema, String pack, String name,
			String nameResult, Class beanResult,SqlOutCursorParam... outCursorParams) {
		super(schema, pack, name, nameResult,outCursorParams);
		this.beanResult = beanResult;
	}

	public Class getBeanResult() {
		return beanResult;
	}

	public void setBeanResult(Class beanResult) {
		this.beanResult = beanResult;
	}
	
}
