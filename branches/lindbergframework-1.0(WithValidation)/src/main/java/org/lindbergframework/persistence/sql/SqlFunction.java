package org.lindbergframework.persistence.sql;

/**
 * Stored function abractration. This class is used to define a stored function call.
 * 
 * @author Victor Lindberg
 * 
 */
public class SqlFunction extends SqlProcedure {

    /**
     * Default result name. This name will be used as a key parameter of the result.
     */
	public static final String DEFAULT_RESULT_NAME = "result";
	
	/**
	 * name of the result parameter.
	 */
	private String resultName = DEFAULT_RESULT_NAME;
	
	public SqlFunction(String name) {
	    super(name);
	}

	/**
	 * creates a function definition for specified output cursors parameters.
	 *  
	 * @param outCursorParams output cursors parameters.
	 */
	public SqlFunction(SqlOutCursorParam... outCursorParams) {
		super(outCursorParams);
	}

	/**
	 * creates a function definition for specified id, catalog, schema, package,
	 * name, name of the result parameter and output cursors parameters.
	 * 
	 * @param id function id.
	 * @param catalog function catalog.
	 * @param schema function schema.
	 * @param pack function package.
	 * @param name function name.
	 * @param nameResult name of the result parameter.
	 * @param outCursorParams output cursors parameters.
	 */
	public SqlFunction(String id, String catalog, String schema, String pack, String name,
			String nameResult,SqlOutCursorParam... outCursorParams) {
       super(id, catalog, schema, pack, name,outCursorParams);
       setResultName(nameResult);
	}
	
	/**
	 * creates a function definition for specified catalog, schema, package,
	 * name, name of the result parameter and output cursors parameters.
	 * 
	 * @param catalog function catalog.
	 * @param schema function schema.
	 * @param pack function package.
	 * @param name function name.
	 * @param nameResult name of the result parameter.
	 * @param outCursorParams output cursors parameters.
	 */
	public SqlFunction(String catalog, String schema, String pack, String name,
			String nameResult,SqlOutCursorParam... outCursorParams) {
		this(null, catalog, schema, pack, name, nameResult,outCursorParams);
	}

	/**
	 * creates a function definition for name, name of the result parameter and output cursors parameters.
	 * 
	 * @param name function name.
	 * @param nameResult name of the result parameter.
	 * @param outCursorParams output cursors parameters.
	 */
	public SqlFunction(String name, String resultName,SqlOutCursorParam... outCursorParams) {
		super(name,outCursorParams);
		this.resultName = resultName;
	}

	/**
	 * creates a function definition for specified schema, package,
	 * name, name of the result parameter and output cursors parameters.
	 * 
	 * @param pack function package.
	 * @param name function name.
	 * @param nameResult name of the result parameter.
	 * @param outCursorParams output cursors parameters.
	 */
	public SqlFunction(String pack, String name, String nameResult,SqlOutCursorParam... outCursorParams) {
		super(pack, name,outCursorParams);
		this.resultName = nameResult;
	}

	/**
     * creates a function definition for specified schema, package,
     * name, name of the result parameter and output cursors parameters.
     * 
     * @param schema function schema.
     * @param pack function package.
     * @param name function name.
     * @param nameResult name of the result parameter.
     * @param outCursorParams output cursors parameters.
     */
	public SqlFunction(String schema, String pack, String name,
			String nameResult,SqlOutCursorParam... outCursorParams) {
		super(schema, pack, name,outCursorParams);
		this.resultName = nameResult;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String nameResult) {
		this.resultName = nameResult;
	}
	
}
