package org.lindbergframework.persistence.impl;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.lindbergframework.exception.PersistenceException;
import org.lindbergframework.exception.RegisterParameterProceduresAndFunctionsFailedException;
import org.lindbergframework.persistence.beans.MultiLevelBeanRowMapperForProcedureCursor;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlFunction;
import org.lindbergframework.persistence.sql.SqlFunctionForCursor;
import org.lindbergframework.persistence.sql.SqlOutCursorParam;
import org.lindbergframework.persistence.sql.SqlProcedure;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

/**
 * StoredProcedure extension class for lindberg persistence.
 * 
 * This extension does auto parameters detection by procedure metadata.
 * 
 * @author Victor Lindberg 
 *
 */
class LinpProcedure extends StoredProcedure{
    
    /**
     * Row mappers registered (out cursors).
     */
	private List<RowMapperAdapter> rowMappers = new ArrayList<RowMapperAdapter>();
	
	/** defined parameters for this procedure **/
	private Set<String> parametersDefined = new HashSet<String>();
	
	/**
	 * function result parameter stereotype.
	 */
	protected static final short RESULT_FUNCTION_STEREOTYPE = 5;
	
	private SqlProcedure procedure;
	
	/**
	 * default error message.
	 */
	public static final String DEFAULT_MESSAGE_ERROR = "Make sure the name of the procedure or function exists and is correct. " +
			"There is another procedure or function with the " +
			"same name in another schema or catalog?";
	
	/**
	 * creates a LinpProcedure with the specified data source to call a stored function.
	 * 
	 * @param ds data source
	 * @param function function to execute.
	 * @throws SQLException error doing auto parameter detection.
	 */
	public LinpProcedure(DataSource ds,SqlFunction function) throws SQLException{
		super(ds,function.getName());
		this.procedure = function;
        setFunction(true);
        ResultSet rsMapping = getProcedureMapping(ds, function);
		
        //Maps the function result. The function result is always the first record of the ResultSet
		if (rsMapping.next()){
			if (function instanceof SqlFunctionForCursor)
				declareParameter(new SqlOutParameter(function.getResultName(),LinpContext.getInstance().getCursorType(),
						new MultiLevelBeanRowMapperForProcedureCursor(((SqlFunctionForCursor) function).getBeanResult())));
			else
			    declareParameter(getSqlParam(function.getResultName(), rsMapping.getInt(6), rsMapping.getShort(5)));
		}
		
		parametersDefined.add(function.getResultName());
		registerParameters(rsMapping);
	}
	
	/**
	 * creates a LinpProcedure with the specified data source to call a stored procedure.
	 * @param ds data source
	 * @param procedure procedure to execute.
	 * @throws SQLException error doing auto parameter detection.
	 */
	public LinpProcedure(DataSource ds,SqlProcedure procedure) throws SQLException{
		super(ds,procedure.getName());
		this.procedure = procedure;
		ResultSet rsMapping = getProcedureMapping(ds, procedure);
		registerParameters(rsMapping);
	}
	
	/**
	 * Register parameter by auto detection.
	 * 
	 * @param rsMapping result set with procedure (or function) metadata.
	 */
	public void registerParameters(ResultSet rsMapping){
		try {
			while (rsMapping.next()){
			   String name = rsMapping.getString(4);
			   short stereotype = rsMapping.getShort(5);
			   if (stereotype != RESULT_FUNCTION_STEREOTYPE && ! parametersDefined.contains(name)){	
			      declareParameter(getSqlParam(name, rsMapping.getInt(6), stereotype));
			      parametersDefined.add(name);
			   }
			}
		} catch (Exception ex) {
		   throw new RegisterParameterProceduresAndFunctionsFailedException(ex);
		} 
	}
	
	/**
	 * Get a {@link ResultSet} wit the procedure (or function) metadata.
	 * @param ds data source to get the procedure metadata.
	 * @param procedure procedure to get the metadata.
	 * @return {@link ResultSet} with procedure metadata.
	 * @throws SQLException error getting procedure metadata.
	 */
	public ResultSet getProcedureMapping(DataSource ds,SqlProcedure procedure) throws SQLException{
		try{
		   DatabaseMetaData meta =  ds.getConnection().getMetaData();
		
		   return meta.getProcedureColumns(procedure.getCatalog(), procedure.getSchema(), procedure.getName(), null);
		}catch(SQLException ex){
			throw new SQLException(ex.getMessage()+ " : " + DEFAULT_MESSAGE_ERROR);
		}
	}
	
	/**
	 * records the out cursors detected in this procedure.
	 *  
	 * @param outCursors out cursors detected.
	 */
	public void declareOutCursors(SqlOutCursorParam... outCursors){
		if (rowMappers.size() != outCursors.length)
			throw new PersistenceException("Number of OUT CURSORS defined does not match expected in "+procedure.getName());
			
		for (int i = 0;i < outCursors.length;i++){
			RowMapperAdapter rmad = rowMappers.get(i);
			SqlOutCursorParam outCur = outCursors[i];
			
			rmad.setRm(new MultiLevelBeanRowMapperForProcedureCursor(outCur.getBeanClass()));
		}
	}
	
	/**
	 * Get {@link SqlParameter} instance for specified parameter name, type and stereotype.
	 * 
	 * @param name parameter name.
	 * @param type parameter type.
	 * @param stereotype parameter stereotype.
	 * 
	 * @return if type == Types.OTHER then (considers that is out cursor)
	 *             returns SqlOutParameter with sqlType equals to LinpContext.getInstance().getCursorType()
	 *         else    
	 *         if stereotype == 1 then (IN PARAMETER)
     *             returns SqlParameter
     *         else    
     *         if stereotype == 2 then (IN AND OUT PARAMETER)
     *             returns SqlInOutParameter
     *         else SqlOutParameter (OUT PARAMETER)
     *                
     *                    
	 */
	public SqlParameter getSqlParam(String name, int type,short stereotype){
		//If the parameter is an out cursor, then declares an adapter rowmapper. 
		//Output parameters rowmapper over will be declared when the execute 
		//method is called, then these will be set adapters rowmapper
		if (type == Types.OTHER){
			RowMapperAdapter rm = new RowMapperAdapter();
	        rowMappers.add(rm);
	        
	        return new SqlOutParameter(name,LinpContext.getInstance().getCursorType(),rm);
		}
		
		switch (stereotype) {
		   case 1 : return new SqlParameter(name,type);//in parameter 
		   case 2 : return new SqlInOutParameter(name,type);//inOut parameter
		   default: return new SqlOutParameter(name,type);//outparameter 
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map execute(Map inParams) {
		compile();
		
		clear();
		
		if (inParams == null)
			inParams = Collections.emptyMap();
		
		try{
		   return super.execute(inParams);
		}catch(DataAccessException ex){
			throw new PersistenceException("Invalid data access : "+DEFAULT_MESSAGE_ERROR, ex); 
		}
	}

	/**
	 * Execute the procedure with the specified in parameters map and defines out sql cursors for this procedure.
	 * 
	 * @param inParams in parameters map.
	 * @param outCursors out cursors defined for this procedure.
	 * 
	 * @return out parameters map.
	 */
	public Map execute(Map inParams, SqlOutCursorParam... outCursors) {
		declareOutCursors(outCursors);
		
		return execute(inParams);
	}
	
	/**
	 * Execute the procedure with the specified in sql arguments.
	 * 
	 * @param inArgs in sql arguments.
	 * 
	 * @return out parameters map.
	 */
	public Map execute(SqlArg... inArgs) {
		Map map = new HashMap();
		
		for (SqlArg arg : inArgs)
			map.put(arg.getName(),arg.getValue());
        
		return execute(map);
	}
	
	/**
	 * Execute the procedure with the specified in sql arguments and defines out sql cursors for this procedure.
	 * 
	 * @param inArgs in sql arguments.
	 * @param outCursors defined out sql cursors for this procedure
	 * 
	 * @return out parameters map.
	 */
	public Map execute(SqlArg[] inArgs,SqlOutCursorParam... outCursors)  {
		declareOutCursors(outCursors);
		
		return execute(inArgs);
	}
	
	/**
	 * Execute the procedure defining out sql cursors for this procedure.
	 * 
	 * @param outCursors defined out sql cursors for this procedure
	 * 
	 * @return out parameters map.
	 */
	public Map execute(SqlOutCursorParam... outCursors) {
		declareOutCursors(outCursors);
		
		return execute(Collections.emptyMap());
	}
	
	/**
	 * clean defined rowmappers and parameters in this procedure.
	 */
	public void clear(){
		rowMappers.clear();
		parametersDefined.clear();
	}
	
	/**
	 * RowMapper adapter to work with sql out cursors.
	 * 
	 * @author Victor Lindberg
	 *
	 */
	private class RowMapperAdapter implements RowMapper{
		
		private RowMapper rm;
		
		public RowMapperAdapter(){
			//
		}
		
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (rm == null)
				throw new SQLException("RowMapper not specified");
				
			return rm.mapRow(rs, rowNum);
		}

		public RowMapper getRm() {
			return rm;
		}

		public void setRm(RowMapper rm) {
			this.rm = rm;
		}
		
	}
}
