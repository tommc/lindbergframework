package org.lindbergframework.persistence.sql;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.apache.xmlbeans.XmlException;
import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.exception.DuplicatedSqlMappingIdException;
import org.lindbergframework.exception.InvalidSqlMappingException;
import org.lindbergframework.exception.NoSuchSqlCommandException;
import org.lindbergframework.exception.NoSuchSqlStatementException;
import org.lindbergframework.exception.SqlCommandLoadingFailedException;
import org.lindbergframework.exception.SqlMappingException;
import org.lindbergframework.persistence.configuration.LinpConfigurationInitializer;
import org.lindbergframework.schema.LinpMappingDocument;
import org.lindbergframework.schema.TFunction;
import org.lindbergframework.schema.TFunctionResultCursor;
import org.lindbergframework.schema.TOutCursor;
import org.lindbergframework.schema.TProcedure;
import org.lindbergframework.schema.TSqlCommand;
import org.lindbergframework.schema.LinpMappingDocument.LinpMapping;
import org.springframework.util.StringUtils;

/**
 * Sql command resolver implementation to work with XML mapping for sql commands.
 * 
 * The XML schema  is defined in http://www.lindbergframework.org/schema/linp-sqlMapping.xsd
 * 
 * @author Victor Lindberg
 *
 */
@Bean("defaultSqlCommandResolver")
public class XmlSqlCommandResolver implements SqlCommandResolver, LinpConfigurationInitializer{

    /**
     * lindberg persistence mapping files nodes.
     */
	private LinpMapping[] linpMappings;
	
	public XmlSqlCommandResolver(){
		//
	}
	
	/**
	 * creates a XmlSqlCommandResolver for xml Files.
	 * 
	 * @param xmlSqlCommandLocations mapping files.
	 */
	public XmlSqlCommandResolver(File... xmlSqlCommandLocations){
		load(xmlSqlCommandLocations);
	}
	
	/**
	 * creates a XmlSqlCommandResolver for xml URLs.
	 * 
	 * @param xmlSqlCommandLocations mapping URLs.
	 */
	public XmlSqlCommandResolver(URL... xmlSqlCommandLocations){
		load(xmlSqlCommandLocations);
	}
	
	/**
	 * creates a XmlSqlCommandResolver for xml inputStreams.
	 * 
	 * @param xmlSqlCommandLocations mapping inputStreams.
	 */
	public XmlSqlCommandResolver(InputStream... xmlSqlCommandLocations){
		load(xmlSqlCommandLocations);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(File... xmlSqlCommandLocations){
		load(xmlSqlCommandLocations);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(URL... xmlSqlCommandLocations){
		load(xmlSqlCommandLocations);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(InputStream... xmlSqlCommandLocations){
		load(xmlSqlCommandLocations);
	}
	
	/**
	 * loads the configuration objects in this command resolver.
	 * 
	 * @param xmlSqlCommandLocations configuration objects.
	 */
	private void load(Object[] xmlSqlCommandLocations){
		if (linpMappings != null)
			   throw new IllegalStateException("Sql Mapping context is already initialized");
		
		linpMappings = new LinpMapping[xmlSqlCommandLocations.length];
		for(int i = 0;i < xmlSqlCommandLocations.length;i++){
			LinpMapping mapping = loadDocument(xmlSqlCommandLocations[i]);
			linpMappings[i] = mapping;
		}
		
		validate();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SqlStatement getSqlStatement(String id) throws NoSuchSqlCommandException {
		TSqlCommand command = getTSqlCommand(id);
		String statement = command.getSqlStatement();
		
		if (statement == null)
			throw new NoSuchSqlStatementException("No such SqlStatement with id : "+id);
		
		SqlStatement sqlStatement = new SqlStatement(
				             cleanStringCommand(command.getSqlStatement()),
				             id);
		
		return sqlStatement;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SqlProcedure getSqlProcedure(String id) throws NoSuchSqlCommandException {
		TSqlCommand command = getTSqlCommand(id);
		TProcedure tProcedure = command.getProcedure();

		if (tProcedure == null)
			throw new NoSuchSqlStatementException("No such Procedure with id : "+id);
		
		SqlProcedure procedure = new SqlProcedure(id,
                                                    tProcedure.getCatalog(),
                                                    tProcedure.getSchema(),
                                                    tProcedure.getPackage(),
                                                    tProcedure.getName()); 
		
		loadSqlOutCursorParams(procedure, tProcedure.getOutCursorArray());
		
		return procedure;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SqlFunction getSqlFunction(String id) throws NoSuchSqlCommandException{
		TSqlCommand command = getTSqlCommand(id);
		TFunction tFunction = command.getFunction();

		if (tFunction == null)
			throw new NoSuchSqlStatementException("No such Function with id : "+id);
		
		SqlFunction function;
		
		TFunctionResultCursor resultCursor = tFunction.getResultCursor();
        if (resultCursor == null)
        	function = new SqlFunction();
        else
        	function = new SqlFunctionForCursor();
		
        function.setId(id);
        loadSqlFunction(function, tFunction);
        
		return function;
	}
	
	/**
	 * loads a {@link SqlFunction} based on {@link TFunction} xml node.
	 * 
	 * @param sqlFunction {@link SqlFunction} to load.
	 * @param tFunction {@link TFunction} to load the {@link SqlFunction}.
	 */
	public void loadSqlFunction(SqlFunction sqlFunction,TFunction tFunction){
		sqlFunction.setCatalog(tFunction.getCatalog());
		sqlFunction.setSchema(tFunction.getSchema());
		sqlFunction.setPack(tFunction.getPackage());
		sqlFunction.setName(tFunction.getName());
		
		String resultName = tFunction.getResultName();
		if (org.apache.commons.lang.StringUtils.isBlank(resultName))
			resultName = SqlFunction.DEFAULT_RESULT_NAME;
		
		sqlFunction.setResultName(resultName);
		
		loadSqlOutCursorParams(sqlFunction, tFunction.getOutCursorArray());
		
		if (sqlFunction instanceof SqlFunctionForCursor){
			String className = tFunction.getResultCursor().getClass1();
			((SqlFunctionForCursor) sqlFunction).setBeanResult(toClass(className, sqlFunction.getId()));
		}
	}

	/**
	 * loads the output cursor parameters on {@link SqlProcedure} based on {@link TOutCursor} xml node array.
	 * 
	 * @param procedure {@link SqlProcedure} to load.
	 * @param outCursors {@link TOutCursor} output cursor array to load the procedure.
	 */
	protected void loadSqlOutCursorParams(SqlProcedure procedure, TOutCursor[] outCursors){
  	       for (TOutCursor outCursor : outCursors){
		      String className = outCursor.getClass1();
			  Class clazz = toClass(className, procedure.getId());
			  procedure.registerSqlOutCursorsParam(new SqlOutCursorParam(clazz));
		   }
	}
	
	/**
	 * Extracts the {@link Class} based on className argument.
	 * @param className className to extract.
	 * @param id id of current sql command.
	 * 
	 * @return class instance.
	 * @throws SqlCommandLoadingFailedException error getting class.
	 */
	private Class toClass(String className, String id) throws SqlCommandLoadingFailedException{
		try{
		   return Class.forName(className);	
		}catch (ClassNotFoundException ex) {
			  throw new SqlCommandLoadingFailedException("Error loading class "+className+" for Command with id: "+id,ex);
		}
	}
	
	/**
	 * Get the {@link TSqlCommand} node associated with the specified id.
	 * 
	 * @param id {@link SqlCommand} id.
	 * @return {@link TSqlCommand} associated with the specified id.
	 * 
	 * @throws NoSuchSqlCommandException sql command for specified id not found.
	 */
	protected TSqlCommand getTSqlCommand(String id) throws NoSuchSqlCommandException{
		TSqlCommand command = null;
		for (LinpMapping mapping : linpMappings){
			TSqlCommand sqlCommand = getTSqlCommand(mapping, id);
			if (sqlCommand != null)
				command = sqlCommand;
		}
		
		if (command == null)
			throw new NoSuchSqlCommandException("No such Sql Command with id : "+id);
		
		return command;
	}
	
	/**
	 * Get the {@link SqlCommand} associated with specified id in {@link LinpMapping} node.
	 * 
	 * @param mapping linp xml node to search.
	 * @param id sql command id.
	 * @return {@link TSqlCommand} associated with the specified id or null
	 * if a {@link TSqlCommand} with the specified id not found.
	 */
	protected TSqlCommand getTSqlCommand(LinpMapping mapping,String id){
		TSqlCommand[] commandArray = mapping.getSqlMapping().getSqlCommandArray();
		for (TSqlCommand command : commandArray)
			if (command.getId().equals(id))
				return command;
		
		return null;
	}
	
	/**
	 * loads the document getting {@link LinpMapping} node.
	 * 
	 * @param sqlMapping sql mapping object.
	 * @return {@link LinpMapping} node.
	 */
	private LinpMapping loadDocument(Object sqlMapping) {
		if (sqlMapping == null)
			throw new SqlMappingException(
					"Invalid Xml sql mapping");

		try {
			return buildDocument(sqlMapping);
		} catch (Exception ex) {
			throw new SqlMappingException("Xml sql mapping settings failed",ex);
		}
	}
	
	/**
	 * Builds the {@link LinpMapping} node based on sql mapping object argument.
	 * @param sqlMapping sql mapping object.
	 * @return {@link LinpMapping} node.
	 * @throws IOException Error getting {@link LinpMapping} node.
	 * @throws XmlException XML mapping invalid.
	 */
	private LinpMapping buildDocument(Object sqlMapping) throws IOException, XmlException {
		LinpMappingDocument doc = null;
		
		if (sqlMapping instanceof File)
			doc = LinpMappingDocument.Factory.parse((File) sqlMapping);
		else 
			if (sqlMapping instanceof URL)
			   doc = LinpMappingDocument.Factory.parse((URL) sqlMapping);
		    else 
			   if (sqlMapping instanceof InputStream) {
			      InputStream inputStreamConfig = (InputStream) sqlMapping;
			      try {
				     doc = LinpMappingDocument.Factory
					          .parse(inputStreamConfig);
			      } finally {
				     inputStreamConfig.close();
			      }
		       }
			   else
				  throw new IllegalStateException("invalid sql mapping file : "+sqlMapping);
		
		return doc.getLinpMapping();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void validate() throws InvalidSqlMappingException {
		validateConfigurationDocument(linpMappings);
		verifyUniqueIDs(linpMappings);	
	}
	
	/**
	 * validates the sql mappings.
	 * 
	 * @param linpMappings sql mappings to validate.
	 */
    private void validateConfigurationDocument(LinpMapping[] linpMappings){
       for (LinpMapping linpMapping : linpMappings){
          if (! linpMapping.validate())
    	     throw new InvalidSqlMappingException("One or more XML sql mapping is invalid");
       }
    }
    
    /**
     * checks duplicated ID´s in sql mappings. A ID must be unique in all context. 
     * 
     * @param linpMappings sql mappings.
     * @throws InvalidSqlMappingException invalid sql mapping.
     */
    private void verifyUniqueIDs(LinpMapping[] linpMappings) throws InvalidSqlMappingException{
    	if (linpMappings == null)
    		throw new InvalidSqlMappingException("Linp sql mappings is null");
    	
    	Set<String> ids = new HashSet<String>();
    	Set<String> duplicatedIDs = new HashSet<String>();
    	DuplicatedSqlMappingIdException ex = new DuplicatedSqlMappingIdException();
    	for (LinpMapping mapping : linpMappings){
    		TSqlCommand[] commands = mapping.getSqlMapping().getSqlCommandArray();
    		for (TSqlCommand command : commands){
    			String id = command.getId();
    			if (ids.contains(id) && ! duplicatedIDs.contains(id)){
    				ex.addMessage("Duplicated Sql Command ID : "+id);
    				duplicatedIDs.add(id);
    			}
    			ids.add(id);
    		}
    	}
    	
    	ex.throwIfContainsErrorMessages();
    }
    
    /**
     * clean the string value of a {@link SqlCommand}.
     * 
     * @param strCommand string value of {@link SqlCommand}.
     * 
     * @return string cleaned.
     */
    private String cleanStringCommand(String strCommand){
    	strCommand = StringUtils.delete(strCommand, "\n");
    	
    	return strCommand;
    }
    
}
