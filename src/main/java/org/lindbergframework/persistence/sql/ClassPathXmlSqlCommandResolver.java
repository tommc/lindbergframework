package org.lindbergframework.persistence.sql;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.lindbergframework.util.ArrayUtil;
import org.lindbergframework.util.CollectionsUtil;
import org.lindbergframework.util.ResourceUtil;

/**
 * Sql command resolver for XML mapped commands on project class path.
 * 
 * The XML schema  is defined in http://www.lindbergframework.org/schema/linp-sqlMapping.xsd
 * 
 * @author Victor Lindberg
 *
 */
public class ClassPathXmlSqlCommandResolver extends XmlSqlCommandResolver{
	
	public ClassPathXmlSqlCommandResolver(){
		//
	}
	
	public ClassPathXmlSqlCommandResolver(List<String> xmlResources){
	    this(xmlResources.toArray(new String[]{}));
	}
	
	/**
	 * Creates a ClassPathXmlSqlCommandResolver with the specified sql mapping files on project class path. 
	 * 
	 * @param xmlResources sql mapping files on project class path.
	 */
	public ClassPathXmlSqlCommandResolver(String... xmlResources){
		List<InputStream> inputResources = new ArrayList<InputStream>();
		for (String resource : xmlResources){
			InputStream in = ResourceUtil.getInputStream(resource);
			inputResources.add(in);
		}
		
		initialize(inputResources.toArray(new InputStream[0]));
	}

}
