package org.lindbergframework.persistence.context;

import org.lindbergframework.core.context.ConfigurationInitializer;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Persistence;

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
     * initializes the lindberg persistence configuration based on defined {@link Persistence} xml node.
     *  
     * @param persistenceConfig xml node.
     */
    public void initialize(Persistence persistenceConfig);

}
