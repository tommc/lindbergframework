package org.lindbergframework.core.context;

import org.lindbergframework.core.configuration.Configuration;
import org.lindbergframework.exception.IllegalStateContextException;


/**
 * Interface that defines the contract for component Context´s implementations.
 * 
 * @author Victor Lindberg
 *
 */
public interface ComponentContext<E extends Configuration> {
  
    /**
     * load a configuration in context.
     * @param configuration configuration to load.
     * @return instance of context loaded.
     */
    public void initialize(E configuration);
    
    public void finalize();
    
    /**
     * checks if the context is active.
     * @return true if this context is active.
     */
    public boolean isActive();
    
    /**
     * verify the context.
     * 
     * @throws IllegalStateContextException this context is with illegal state.
     */
    public void verifyContext() throws IllegalStateContextException;

}
