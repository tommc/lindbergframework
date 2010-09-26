package org.lindbergframework.core.context;


/**
 * 
 * @author Victor Lindberg
 *
 */
public interface Context<C extends Context,E extends Configuration> {
    
    public C loadConfiguration(E configuration);
    
    public boolean isActive();
    
    public void close();
    
    public void verifyContext();

}
