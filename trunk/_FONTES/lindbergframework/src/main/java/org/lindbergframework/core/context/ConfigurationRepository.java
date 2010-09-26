package org.lindbergframework.core.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Victor Lindberg
 *
 */
public abstract class ConfigurationRepository{
    
    private Map<String, Object> mapKeys = new HashMap<String, Object>();
    
    public ConfigurationRepository(){
        //
    }
    
    public <E> E getConfigValue(String key) {
        return (E) mapKeys.get(key);
    }
    
    protected void registerProperty(String key, Object value){
        mapKeys.put(key, value);
    }

    protected Map<String, Object> getMapKeys() {
        return mapKeys;
    }


}
