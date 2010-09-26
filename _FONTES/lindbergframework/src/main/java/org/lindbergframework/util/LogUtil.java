package org.lindbergframework.util;

import java.util.logging.Logger;

/**
 * 
 * @author Victor Lindberg
 *
 */
public final class LogUtil {
    
    public static void logInfo(String msg){
        getLogger().info(msg);
    }
    
    public static void logWarning(String msg){
        getLogger().warning(msg);
    }
    
    public static Logger getLogger(String name){
        return Logger.getLogger(name);
    }
    
    public static Logger getLogger(){
        return getLogger("logger");
    }

}
