package org.lindbergframework.util;

import java.util.logging.Logger;

/**
 * Utilitary class to log operations.
 * 
 * @author Victor Lindberg
 *
 */
public final class LogUtil {
  
	/**
	 * log a info.
	 * @param msg info.
	 */
    public static void logInfo(String msg){
        getLogger().info(msg);
    }
    
    /**
     * log a warning.
     * @param msg warning.
     */
    public static void logWarning(String msg){
        getLogger().warning(msg);
    }
    
    /**
     * get the logger.
     * @param name logger name.
     * @return logger instance.
     */
    public static Logger getLogger(String name){
        return Logger.getLogger(name);
    }
    
    public static Logger getLogger(){
        return getLogger("logger");
    }

}
