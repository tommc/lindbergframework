package org.lindbergframework.persistence.sql;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class SqlFunction extends SqlProcedure {

	public static final String DEFAULT_RESULT_NAME = "result";
	private String resultName;

	public SqlFunction(SqlOutCursorParam... outCursorParams) {
		super(outCursorParams);
	}

	public SqlFunction(String id, String catalog, String schema, String pack, String name,
			String nameResult,SqlOutCursorParam... outCursorParams) {
       super(id, catalog, schema, pack, name,outCursorParams);
       this.resultName = nameResult;
	}
	
	public SqlFunction(String catalog, String schema, String pack, String name,
			String nameResult,SqlOutCursorParam... outCursorParams) {
		this(null, catalog, schema, pack, name, nameResult,outCursorParams);
	}

	public SqlFunction(String name, String resultName,SqlOutCursorParam... outCursorParams) {
		super(name,outCursorParams);
		this.resultName = resultName;
	}

	public SqlFunction(String pack, String name, String nameResult,SqlOutCursorParam... outCursorParams) {
		super(pack, name,outCursorParams);
		this.resultName = nameResult;
	}

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
	
	@Override
	public String toString() {
		return super.toString() + " ResultName: "+getResultName(); 
	}

}
