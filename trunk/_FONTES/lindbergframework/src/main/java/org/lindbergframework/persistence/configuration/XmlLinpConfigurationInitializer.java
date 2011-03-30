package org.lindbergframework.persistence.configuration;

import org.lindbergframework.core.configuration.ConfigurationInitializer;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Linp;

/**
 * Interface that defines the lindberg persistence configuration initializer contract.
 * 
 * A linp configuration initializer is used to start up the linp configurations. 
 * Core Configuration uses implementation from this interface to initialize the persistence module.
 *  
 * @author Victor Lindberg
 *
 */
public interface XmlLinpConfigurationInitializer extends ConfigurationInitializer{
    
    /**
     * initializes the lindberg persistence configuration based on defined {@link Linp} xml node.
     *  
     * @param linpConfig xml node.
     */
    public void initialize(Linp linpConfig);

}
