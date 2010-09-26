package org.lindbergframework.persistence.sql;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.lindbergframework.util.ResourceUtil;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ClassPathXmlSqlCommandResolver extends XmlSqlCommandResolver{
	
	public ClassPathXmlSqlCommandResolver(){
		//
	}
	
	public ClassPathXmlSqlCommandResolver(String... xmlResources){
		List<InputStream> inputResources = new ArrayList<InputStream>();
		for (String resource : xmlResources){
			InputStream in = ResourceUtil.getInputStream(resource);
			inputResources.add(in);
		}
		
		initialize(inputResources.toArray(new InputStream[0]));
	}

}
