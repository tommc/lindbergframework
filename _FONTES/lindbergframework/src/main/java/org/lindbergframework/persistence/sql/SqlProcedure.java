package org.lindbergframework.persistence.sql;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sql command for stored procedures.
 * 
 * @author Victor Lindberg
 * 
 */
public class SqlProcedure extends SqlCommand{

    /**
     * procedure catalog.
     */
	private String catalog;
	
	/**
	 * procedure schema.
	 */
	private String schema;
	
	/**
	 * procedure package.
	 */
	private String pack;
	
	/**
	 * procedure name.
	 */
	private String name;
	
	/**
	 * registered output cursor parameters.
	 */
	private List<SqlOutCursorParam> sqlOutCursorParams;

	/**
	 * creates a {@link SqlProcedure} with the output parameters.
	 * 
	 * @param outCursorParams procedure output cursor parameters.
	 */
	public SqlProcedure(SqlOutCursorParam... outCursorParams) {
		setSqlOutCursorParams(outCursorParams);
	}

	/**
	 * creates a {@link SqlProcedure} with the procedure schema, package, name and output parameters.
	 * 
	 * @param schema procedure schema.
	 * @param pack procedure package.
	 * @param name procedure name.
     * @param outCursorParams procedure output cursor parameters.
	 */
	public SqlProcedure(String schema, String pack, String name,SqlOutCursorParam... outCursorParams) {
		this(null,schema,pack,name);
		setSqlOutCursorParams(outCursorParams);
	}

	/**
	 * creates a {@link SqlProcedure} with the package, name and output parameters.
	 * 
	 * @param pack procedure package.
	 * @param name procedure name.
     * @param outCursorParams procedure output cursor parameters.
	 */
	public SqlProcedure(String pack, String name,SqlOutCursorParam... outCursorParams) {
		this(null,pack,name);
		setSqlOutCursorParams(outCursorParams);
	}

	/**
	 * creates a {@link SqlProcedure} with the name and output parameters.
	 * 
	 * @param name procedure name.
     * @param outCursorParams procedure output cursor parameters.
	 */
	public SqlProcedure(String name,SqlOutCursorParam... outCursorParams) {
		this(null,name);
		setSqlOutCursorParams(outCursorParams);
	}

	/**
     * creates a {@link SqlProcedure} with the command id, procedure catalog, schema, package, name and output parameters.
     * 
     * @param id command id.
     * @param catalog procedure catalog.
     * @param schema procedure schema.
     * @param pack procedure package.
     * @param name procedure name.
     * @param outCursorParams procedure output cursor parameters.
     */
	public SqlProcedure(String id, String catalog, String schema, String pack, String name,SqlOutCursorParam... outCursorParams) {
		super(id);
		setCatalog(catalog);
		setSchema(schema);
		setPack(pack);
		setName(name);
		setSqlOutCursorParams(outCursorParams);
	}
	
	/**
     * creates a {@link SqlProcedure} with the command id, procedure catalog, schema, package, name and output parameters.
     * 
     * @param catalog procedure catalog.
     * @param schema procedure schema.
     * @param pack procedure package.
     * @param name procedure name.
     * @param outCursorParams procedure output cursor parameters.
     */
	public SqlProcedure(String catalog, String schema, String pack, String name,SqlOutCursorParam... outCursorParams) {
		this(null, catalog, schema, pack, name);
		setSqlOutCursorParams(outCursorParams);
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = toUpperCase(catalog);
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = toUpperCase(schema);
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = toUpperCase(pack);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = toUpperCase(name);
	}
	
	public SqlOutCursorParam[] getSqlOutCursorParams() {
		return sqlOutCursorParams.toArray(new SqlOutCursorParam[0]);
	}

	public void setSqlOutCursorParams(SqlOutCursorParam[] sqlOutCursorParamsArray) {
        sqlOutCursorParams = new ArrayList<SqlOutCursorParam>();	
		Collections.addAll(sqlOutCursorParams, sqlOutCursorParamsArray);
	}

	/**
	 * Records the output cursor parameters of procedure.
	 * 
	 * @param outCursorParamList list of procedure output cursor parameters.
	 */
	public void registerSqlOutCursorsParam(List<SqlOutCursorParam> outCursorParamList){
	   registerSqlOutCursorsParam(outCursorParamList.toArray(new SqlOutCursorParam[0]));   	
	}
	
	/**
	 * Records the output cursor parameters of procedure.
	 * 
	 * @param outCursorParamArray procedure output cursor parameters.
	 */
	public void registerSqlOutCursorsParam(SqlOutCursorParam... outCursorParamArray){
		for (SqlOutCursorParam param : outCursorParamArray)
			sqlOutCursorParams.add(param);	
	}
	
	private String toUpperCase(String str){
	    if (str != null)
	        return str.toUpperCase();
	    
	    return str;
	}

}
