package org.lindbergframework.persistence.configuration;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * Interface that defines a linp configuration initializer.
 * 
 * @author Victor Lindberg
 *
 */
public interface LinpConfigurationInitializer {
    
    /**
     * Initialize the linp configurations using {@link File}.
     * 
     * @param xmlConfigFiles configuration Files.
     */
    public void initialize(File... xmlConfigFiles);
     
    /**
     * Initialize the linp configuration using {@link URL}.
     * 
     * @param xmlConfigURLs configuration URLs.
     */
    public void initialize(URL... xmlConfigURLs);
     
    /**
     * Initialize the linp configuration using {@link InputStream}.
     * 
     * @param xmlConfigInputStreams configuration InputStreams.
     */
    public void initialize(InputStream... xmlConfigInputStreams);
}
