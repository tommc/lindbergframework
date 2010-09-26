package org.lindbergframework.test.beans.di.test;

import junit.framework.TestCase;

import org.lindbergframework.beans.di.context.AnnotationBeanFactory;
import org.lindbergframework.beans.di.context.UserBeanContext;
import org.lindbergframework.core.context.BeanContext;
import org.lindbergframework.core.context.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.context.CoreConfiguration;
import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.core.context.SimpleCoreConfiguration;
import org.lindbergframework.exception.BeanMappingNotFoundException;
import org.lindbergframework.test.beans.AClass;
import org.lindbergframework.test.beans.BClass;
import org.lindbergframework.test.beans.CClass;
import org.lindbergframework.test.beans.SingletonBean;
import org.lindbergframework.test.beans.SingletonTestBean;
import org.lindbergframework.test.beans.SubAClass;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class DiTest extends TestCase{
	
    @Override
    protected void setUp() throws Exception {
        CoreConfiguration configuration = new ClassPathXmlCoreConfiguration("org/lindbergframework/test/di/resource/configDI.xml");
        CoreContext.getInstance().loadConfiguration(configuration);
        super.setUp();
    }
    
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		CoreContext.getInstance().close();
	}
	
	public void testSimpleDependencyInjection() throws Exception {
		AClass aClass = UserBeanContext.getInstance().getBean("a_test");
		assertNotNull(aClass);
		
		BClass bClass = aClass.getBClass();
		assertNotNull(bClass);
		
		CClass cClass = bClass.getCClass();
		assertNotNull(cClass);
	}
	
	public void testHierarchicalDependencyInjection() throws Exception {
		SubAClass subAClass = UserBeanContext.getInstance().getBean("subA_test");
		assertNotNull(subAClass);
		
		BClass bClass = subAClass.getBClass();
		assertNotNull(bClass);
		
		CClass cClass = bClass.getCClass();
		assertNotNull(cClass);
	}
	
	public void testSetterInjection() throws Exception {
		SubAClass subAClass = UserBeanContext.getInstance().getBean("subA_test");
		assertNotNull(subAClass);
		
		CClass cClass = subAClass.getCClass2();
		assertNotNull(cClass);
		
		assertTrue(subAClass.isInjectionCClass2OK());
	}
	
	public void testDirectInjection() throws Exception {
		SubAClass subAClass = UserBeanContext.getInstance().getBean("subA_test");
		assertNotNull(subAClass);
		
		CClass cClass = subAClass.getCClass();
		assertNotNull(cClass);
	}
	
	public void testSingletonInjection() throws Exception {
		SingletonTestBean singleton = UserBeanContext.getInstance().getBean("singleton_test_bean");
		assertNotNull(singleton);
		
		SingletonBean singletonBean1 = singleton.getSingletonBean1();
		assertNotNull(singletonBean1);

		SingletonBean singletonBean2 = singleton.getSingletonBean2();
		assertNotNull(singletonBean2);
		
		assertTrue(singletonBean1 == singletonBean2);
		
		SingletonTestBean singleton2 = UserBeanContext.getInstance().getBean("singleton_test_bean");
		assertTrue(singleton == singleton2);
	}
	
	public void testNoSubPackageBeanMapping(){
	    CoreContext.getInstance().close();
	    SimpleCoreConfiguration configuration = new SimpleCoreConfiguration();
             	    
	    configuration.setDiBasePackage("org.lindbergframework.test");
	    AnnotationBeanFactory factory = new AnnotationBeanFactory(); 
	    configuration.setBeanFactory(factory);
	    
	    CoreContext.getInstance().loadConfiguration(configuration);
	    AClass aClass = null;
	    try{
	       UserBeanContext.getInstance().renew(); 
	       aClass = UserBeanContext.getInstance().getBean("a_test");
	       fail("bean a_test found where it should to throw BeanMappingNotFoundException");
	    }catch(BeanMappingNotFoundException ex){
	        //ok
	    }
	}
	
	public void testSubPackageBeanMapping(){
        CoreContext.getInstance().close();
        SimpleCoreConfiguration configuration = new SimpleCoreConfiguration();
                    
        configuration.setDiBasePackage("org.lindbergframework.test.*");
        AnnotationBeanFactory factory = new AnnotationBeanFactory(); 
        configuration.setBeanFactory(factory);
        
        CoreContext.getInstance().loadConfiguration(configuration);
        AClass aClass = null;
        try{
           UserBeanContext.getInstance().renew(); 
           aClass = UserBeanContext.getInstance().getBean("a_test");
           assertNotNull(aClass);
        }catch(BeanMappingNotFoundException ex){
            fail("bean a_test not found");
        }
        
    }
	
	public void testNoBasepackage(){
	    CoreContext.getInstance().close();
	    SimpleCoreConfiguration configuration = new SimpleCoreConfiguration();
	    
	    AnnotationBeanFactory factory = new AnnotationBeanFactory(); 
	    configuration.setBeanFactory(factory);
	    
	    CoreContext.getInstance().loadConfiguration(configuration);
	    UserBeanContext.getInstance().renew();
	    UserBeanContext bc = UserBeanContext.getInstance();
	    assertNotNull(bc);
	}
	
	public void testCreatingBeanContextCustom(){
	    AnnotationBeanFactory beanFactory = new AnnotationBeanFactory("org.lindbergframework.test.beans"); 
	    BeanContext context = new BeanContext(beanFactory);
	    AClass aClass = context.getBean("a_test");
        assertNotNull(aClass);
        
        BClass bClass = aClass.getBClass();
        assertNotNull(bClass);
        
        CClass cClass = bClass.getCClass();
        assertNotNull(cClass);
	}
	

}
