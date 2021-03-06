package org.lindbergframework.persistence.beans;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Collection;

import org.apache.commons.beanutils.Converter;
import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.persistence.sql.DataSet;
import org.lindbergframework.persistence.sql.RowDataTree;
import org.lindbergframework.persistence.sql.SqlNode;
import org.lindbergframework.util.ReflectionUtil;

/**
 * Bean populator that implements the multi level population.
 * 
 * The mult level population occurs setting properties values
 * in several levels. 
 * 
 * E.g. 
 * A Person bean and a Address bean.
 * 
 *  Person
 *    - String name
 *    - Address address
 *    
 *  Address
 *     - String street
 *     - int number
 *     
 *  This bean populator works with ({@link RowDataTree}). 
 *  This enables to populate the Address street property inside of Person bean
 *  like a data tree creating Adress instance and setting street property value and 
 *  setting after the created Address instance in Person. 
 * 
 * @author Victor Lindberg
 *
 */
@Bean("multLevelsBeanPopulator")
public class MultiLevelsBeanPopulator extends BeanPopulatorBase{
	
	public MultiLevelsBeanPopulator(){
		//
	}
	
	/**
	 * Creates and Populates a bean based on {@link RowDataTree}.
	 * 
	 * @param <E> bean type.
     * @param beanClass bean class to populate.
     * @param rowDataTree {@link RowDataTree} that will be used to populate the bean.
     * @return populated bean.
     * @throws BeanPopulateException bean population failed.
	 */
	public <E> E populate(Class<E> beanClass, RowDataTree rowDataTree) throws BeanPopulateException{
		try {
			E beanInstance = beanClass.newInstance();
			beanInstance = applyContextsPrePopulate(beanInstance);
			SqlNode root = rowDataTree.getTree();
			populateMultLevel(beanInstance, root.getChildren());
			
			return beanInstance;
		} catch (InstantiationException ex) {
		   throw new BeanPopulateException(ex);
		} catch (IllegalAccessException ex) {
		   throw new BeanPopulateException(ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public <E> E populate(Class<E> beanClass, DataSet dataSet) throws BeanPopulateException {
		return populate(beanClass,new RowDataTree(dataSet));
	}
	
	/**
	 * {@inheritDoc}
	 */
	public <E> E populateDirectValue(Class<E> beanClass, DataSet dataSet) throws BeanPopulateException {
	    try {
	        if (dataSet.getMetaData().getColumnCount() != 1)
	            throw new BeanPopulateException("Could not populate direct value. Query has more than one column. Try to use the populate method.");
	    
	        Converter converter = BeanUtil.getConverter(beanClass);
	        if (converter == null)
	            throw new BeanPopulateException("Could not populate bean. Converter not found for the specified type ["+beanClass+"]. Try to use the populate method");
        
            Object value = dataSet.getValue(1);
            return (E) converter.convert(beanClass, value);
        } catch (SQLException ex) {
            throw new BeanPopulateException(ex);
        }
	}
	
	/**
	 * Executes recursive mult level population in bean instance based on {@link SqlNode} {@link Collection} argument.
	 * 
	 * @param <E> bean type.
	 * @param bean bean instance to populate.
	 * @param protetiesNodes {@link SqlNode} {@link Collection} containing sql result values.
	 * @throws BeanPopulateException error populating bean.
	 * @throws InstantiationException error creating some bean property.
	 * @throws IllegalAccessException error accessing some bean property.
	 * 
	 * @return populated bean.
	 */
	protected <E> void populateMultLevel(E bean,Collection<SqlNode> protetiesNodes) 
	                 throws BeanPopulateException, InstantiationException, IllegalAccessException{
		for (SqlNode node : protetiesNodes){ 
           String propertyName = sqlColumnToJavaProperyPattern(node.getProperty());		   
		   
		   Field property = ReflectionUtil.getField(bean, propertyName,true);
		
		   if (propertyName == null || property == null)
			  continue;
        
		   if (node.isLeaf())
			   BeanUtil.loadProperty(bean, propertyName, node.getValue());
		   else{//node has children
			     Object beanPropertyInstance = property.getType().newInstance();
			     populateMultLevel(beanPropertyInstance, node.getChildren());
			     BeanUtil.loadProperty(bean, propertyName, beanPropertyInstance);
		   }
		}
	}
	
}
