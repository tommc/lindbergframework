package org.lindbergframework.core.configuration;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * Interface that defines a configuration initializer.
 * 
 * @author Victor Lindberg
 *
 */
public interface ConfigurationInitializer {
    
    /**
     * Initialize the configuration using a {@link File}.
     * 
     * @param xmlConfig configuration File.
     */
    public void initialize(File xmlConfig);
     
    /**
     * Initialize the configuration using a {@link URL}.
     * 
     * @param xmlConfig configuration URL.
     */
    public void initialize(URL xmlConfig);
     
    /**
     * Initialize the configuration using a {@link InputStream}.
     * 
     * @param xmlConfig configuration InputStream.
     */
    public void initialize(InputStream xmlConfig);
}
