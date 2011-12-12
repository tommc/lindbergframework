package org.lindbergframework.util;

import java.io.InputStream;

/**
 * Utilitary class to resource operations.
 * 
 * @author Victor Lindberg
 *
 */
public class ResourceUtil {
	
	/**
	 * get the {@link InputStream} to string resource.
	 */
	public static InputStream getInputStream(String resource){
		return ResourceUtil.class.getClassLoader().getResourceAsStream(resource);
	}

}
