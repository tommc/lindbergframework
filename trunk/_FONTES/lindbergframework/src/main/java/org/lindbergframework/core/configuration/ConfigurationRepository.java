package org.lindbergframework.core.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that implements a configuration property values repository cache.
 * 
 * @author Victor Lindberg
 *
 */
public abstract class ConfigurationRepository implements Configuration{
    
    /**
     * property values repository map.
     */
    private Map<String, Object> mapKeys = new HashMap<String, Object>();
    
    public ConfigurationRepository(){
        //
    }
    
    /**
     * Get a property value.
     * 
     * @param <E> property value type.
     * @param key key of configuration property.
     * @return property value.
     */
    public <E> E getPropertyValue(String key) {
        return (E) mapKeys.get(key);
    }
    
    /**
     * Register an the new property value in the repository.
     * 
     * @param key property key.
     * @param value property value.
     */
    protected void registerProperty(String key, Object value){
        mapKeys.put(key, value);
    }

    /**
     * Get the property values repository map.
     * @return repository map.
     */
    protected Map<String, Object> getMapKeys() {
        return mapKeys;
    }

}
