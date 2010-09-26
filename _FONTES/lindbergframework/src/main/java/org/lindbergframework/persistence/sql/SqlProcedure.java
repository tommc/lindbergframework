package org.lindbergframework.persistence.sql;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class SqlProcedure extends SqlCommand{

	private String catalog, schema, pack, name;
	private List<SqlOutCursorParam> sqlOutCursorParams;

	public SqlProcedure(SqlOutCursorParam... outCursorParams) {
		setSqlOutCursorParams(outCursorParams);
	}

	public SqlProcedure(String schema, String pack, String name,SqlOutCursorParam... outCursorParams) {
		this(null,schema,pack,name);
	}

	public SqlProcedure(String pack, String name,SqlOutCursorParam... outCursorParams) {
		this(null,pack,name);
	}

	public SqlProcedure(String name,SqlOutCursorParam... outCursorParams) {
		this(null,name);
	}

	public SqlProcedure(String id, String catalog, String schema, String pack, String name,SqlOutCursorParam... outCursorParams) {
		super(id);
		this.catalog = catalog;
		this.schema = schema;
		this.pack = pack;
		this.name = name;
		setSqlOutCursorParams(outCursorParams);
	}
	
	public SqlProcedure(String catalog, String schema, String pack, String name,SqlOutCursorParam... outCursorParams) {
		this(null, catalog, schema, pack, name);
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public SqlOutCursorParam[] getSqlOutCursorParams() {
		return sqlOutCursorParams.toArray(new SqlOutCursorParam[0]);
	}

	public void setSqlOutCursorParams(SqlOutCursorParam[] sqlOutCursorParamsArray) {
        sqlOutCursorParams = new ArrayList<SqlOutCursorParam>();	
		Collections.addAll(sqlOutCursorParams, sqlOutCursorParamsArray);
	}
	
	public void registerSqlOutCursorsParam(List<SqlOutCursorParam> outCursorParamList){
	   registerSqlOutCursorsParam(outCursorParamList.toArray(new SqlOutCursorParam[0]));   	
	}
	
	public void registerSqlOutCursorsParam(SqlOutCursorParam... outCursorParamArray){
		for (SqlOutCursorParam param : outCursorParamArray)
			sqlOutCursorParams.add(param);	
	}

	@Override
	public String toString() {
		return String.format("Id: %s Catalog: %s Schema: %s Package: %s Name: %s", getId(),
				                                                                   getCatalog(),
				                                                                   getSchema(),
				                                                                   getPack(),
				                                                                   getName());
	}
	
}
