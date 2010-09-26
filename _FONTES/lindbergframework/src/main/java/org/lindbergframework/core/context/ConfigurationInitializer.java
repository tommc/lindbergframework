package org.lindbergframework.core.context;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface ConfigurationInitializer {
    
    public void initialize(File xmlConfig);
     
    public void initialize(URL xmlConfig);
     
    public void initialize(InputStream xmlConfig);
}
