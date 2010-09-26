package org.lindbergframework.util;

import java.io.InputStream;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class ResourceUtil {
	
	public static InputStream getInputStream(String resource){
		return ResourceUtil.class.getClassLoader().getResourceAsStream(resource);
	}

}
