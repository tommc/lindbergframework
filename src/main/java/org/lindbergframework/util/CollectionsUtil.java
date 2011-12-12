package org.lindbergframework.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Utilitary class to collections operations.
 * 
 * @author Victor Lindberg
 *
 */
public final class CollectionsUtil {
    
	/**
	 * converts a array to list.
	 * @param array to convert.
	 */
    public static <T> List<T> asList(T... itens) {
        return fill(new ArrayList<T>(), itens);
    }
    
    /**
     * fills a list with the specified array.
     * @param list list to fill.
     * @param items array to fill the list.
     * @return populated list.
     */
    public static <T> List<T> fill(List<T> list, T... items){
        for (T t : items)
            list.add(t);
        
        return list;
    }
    
    /**
     * converts a set to list.
     * @param set set to convert.
     * @return converted list.
     */
    public static <E> List<E> setToList(Set<E> set){
        if (set == null)
            return new ArrayList<E>();
        
        return setToList(set, new ArrayList<E>());
    }
    
    /**
     * converts a set to list.
     * @param set set to convert.
     * @param list list to populate.
     * @return converted list.
     */
    public static <E> List<E> setToList(Set<E> set, List<E> list){
        if (set == null)
            return list;
        
       Iterator<E> it = set.iterator();
       while(it.hasNext())
           list.add(it.next());
       
       return list;
    }
    
    /**
     * converts a collection to set.
     * @param collection to convert.
     * @return converted set. 
     */
    public static <E> Set<E> collectionToSet(Collection<E> collection){
        return new HashSet<E>(collection);
    }
    
}
