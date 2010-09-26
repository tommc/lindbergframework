package org.lindbergframework.persistence.sql;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class SqlFunctionForCursor extends SqlFunction {

	private Class beanResult;

	public SqlFunctionForCursor(SqlOutCursorParam... outCursorParams) {
		super(outCursorParams);
	}

	public SqlFunctionForCursor(String id, String catalog, String schema, String pack,
			String name, String nameResult, Class beanResult,SqlOutCursorParam... outCursorParams) {
	   super(id,catalog,schema,pack,name,nameResult,outCursorParams);	
	   this.beanResult = beanResult;
	}
	
	public SqlFunctionForCursor(String catalog, String schema, String pack,
			String name, String nameResult, Class beanResult,SqlOutCursorParam... outCursorParams) {
		this(null, catalog, schema, pack, name, nameResult, beanResult,outCursorParams);
	}

	public SqlFunctionForCursor(String name, String nameResult, Class beanResult,SqlOutCursorParam... outCursorParams) {
		super(name, nameResult,outCursorParams);
		this.beanResult = beanResult;
	}

	public SqlFunctionForCursor(String pack, String name, String nameResult,
			Class beanResult,SqlOutCursorParam... outCursorParams) {
		super(pack, name, nameResult,outCursorParams);
		this.beanResult = beanResult;
	}

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
	
	@Override
	public String toString() {
		return  super.toString() + " BeanResult: "+getBeanResult().getSimpleName();
	}
	
}
