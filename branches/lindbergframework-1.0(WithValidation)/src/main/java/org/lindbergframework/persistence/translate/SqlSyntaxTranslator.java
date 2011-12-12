package org.lindbergframework.persistence.translate;

import org.lindbergframework.persistence.PersistenceTemplate;

/**
 * Interface that defines the contract for sql syntax translator implementations.
 * 
 * A sql syntax transalator is used by default {@link PersistenceTemplate} implementation
 * to make translation on sql syntax.
 * 
 * @author Victor Lindberg
 *
 */
public interface SqlSyntaxTranslator<E,T> {
	
    /**
     * Executes sql translation.
     * 
     * @param sql sql to translate.
     * @return sql translated.
     */
	public T translate(E sql); 

}
