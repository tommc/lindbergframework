package org.lindbergframework.persistence.beans;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Collection;

import org.lindbergframework.beans.util.BeanUtil;
import org.lindbergframework.exception.BeanPopulateException;
import org.lindbergframework.exception.LoadPropertyException;
import org.lindbergframework.persistence.sql.DataSet;
import org.lindbergframework.persistence.sql.RowDataTree;
import org.lindbergframework.persistence.sql.SqlNode;
import org.lindbergframework.util.ReflectionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Component("multLevelsBeanPopulator")
@Scope("prototype")
public class MultLevelsBeanPopulator extends BeanPopulatorBase implements BeanPopulator{
	
	public MultLevelsBeanPopulator(){
		//
	}
	
	public <E> E populate(Class<E> beanClass, RowDataTree rowDataTree) throws SQLException, BeanPopulateException{
		try {
			E beanInstance = beanClass.newInstance();
			SqlNode root = rowDataTree.getTree();
			populateMultLevel(beanInstance, root.getChilds());
			
			return beanInstance;
		} catch (InstantiationException ex) {
		   throw new BeanPopulateException(ex);
		} catch (IllegalAccessException ex) {
		   throw new BeanPopulateException(ex);
		}
	}
	
	public <E> E populate(Class<E> beanClass, DataSet dataSet) throws SQLException, BeanPopulateException {
		return populate(beanClass,new RowDataTree(dataSet));
	}
	
	protected <E> void populateMultLevel(E bean,Collection<SqlNode> protetiesNodes) 
	                 throws LoadPropertyException, InstantiationException, IllegalAccessException{
		for (SqlNode node : protetiesNodes){ 
           String propertyName = sqlColumnToJavaProperyPattern(node.getProperty());		   
		   
		   Field property = ReflectionUtil.getField(bean, propertyName,true);
		
		   if (propertyName == null || property == null)
			  continue;
        
		   if (node.isLeaf())
			   BeanUtil.loadProperty(bean, propertyName, node.getValue());
		   else{//node has children
			     Object beanPropertyInstance = property.getType().newInstance();
			     populateMultLevel(beanPropertyInstance, node.getChilds());
			     BeanUtil.loadProperty(bean, propertyName, beanPropertyInstance);
		   }
		}
	}

}
