package org.lindbergframework.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Victor Lindberg
 *
 */
public final class CollectionsUtil {
    
    public static <T> List<T> asList(T... itens) {
        return fill(new ArrayList<T>(), itens);
    }
    
    public static <T> List<T> fill(List<T> list, T... itens){
        for (T t : itens)
            list.add(t);
        
        return list;
    }
    
    public static <E> List<E> setToList(Set<E> set){
        if (set == null)
            return new ArrayList<E>();
        
        return setToList(set, new ArrayList<E>());
    }
    
    
    public static <E> List<E> setToList(Set<E> set, List<E> list){
        if (set == null)
            return list;
        
       Iterator<E> it = set.iterator();
       while(it.hasNext())
           list.add(it.next());
       
       return list;
    }
    
    public static <E> Set<E> collectionToSetDefault(Collection<E> collection){
        return new HashSet<E>(collection);
    }
    
    public static void removeAll(Collection collection, Collection collectionRemove){
       for (Object e : collectionRemove)
           collection.remove(e);
    }

}
