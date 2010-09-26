package org.lindbergframework.persistence.context;

import org.lindbergframework.core.context.ConfigurationInitializer;
import org.lindbergframework.schema.LindbergConfigurationDocument.LindbergConfiguration.Persistence;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface XmlLinpConfigurationInitializer extends ConfigurationInitializer{
    
    public void initialize(Persistence persistenceConfig);

}
