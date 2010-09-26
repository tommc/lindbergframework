package org.lindbergframework.persistence.translate;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface SqlSyntaxTranslator<E,T> {
	
	public T translate(E sql); 

}
