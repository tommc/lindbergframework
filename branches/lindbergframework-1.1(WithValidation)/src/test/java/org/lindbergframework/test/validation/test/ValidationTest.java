package org.lindbergframework.test.validation.test;

import java.util.Date;

import junit.framework.TestCase;

import org.lindbergframework.core.configuration.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.configuration.Configuration;
import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.test.beans.ValidationBean1;
import org.lindbergframework.util.CollectionsUtil;
import org.lindbergframework.validation.annotation.engine.IExecutorAnnotationEngine;
import org.lindbergframework.validation.executors.factory.ExecutorFactory;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class ValidationTest extends TestCase{

    @Override
    protected void setUp() throws Exception {
        if (! CoreContext.getInstance().isActive()) {
            Configuration configuration = new ClassPathXmlCoreConfiguration("org/lindbergframework/test/persistence/resource/mysql/configMySql.xml");
            configuration.initializeContext();
        }
    }
    
    @Override
    protected void tearDown() throws Exception {
        CoreContext.getInstance().close();
    }

    public boolean verifyMsgs(ValidationException ex, String... msgs){
        if (ex.getMessages().size() != msgs.length)
            return false;
        
        for (String str : msgs)
            if (! ex.getMessages().contains(str))
                return false;
                
        return true;
    }
    
    public void test1(){
        ValidationBean1 bean = new ValidationBean1();
        bean.setDate(new Date());
        IExecutorAnnotationEngine engine = ExecutorFactory.newExecutorAnnotationEngine();
        engine.addBeans(bean);
        try{
            engine.execute();
            fail();
        }catch(ValidationException ex){
            assertTrue(verifyMsgs(ex, "msg1","msg2","msg3"));
        }
    }
    
    public void testWithAction1(){
        ValidationBean1 bean = new ValidationBean1();
        IExecutorAnnotationEngine engine = ExecutorFactory.newExecutorAnnotationEngine();
        engine.addBeans(bean);
        try{
            engine.executeInActions("action1");
            fail();
        }catch(ValidationException ex){
            assertTrue(verifyMsgs(ex, "msg4"));
        }
    }
    
    public void testNoAction(){
        ValidationBean1 bean = new ValidationBean1();
        IExecutorAnnotationEngine engine = ExecutorFactory.newExecutorAnnotationEngine();
        engine.addBeans(bean);
        try{
            engine.executeInActions("xxx");
        }catch(ValidationException ex){
            fail();
        }
    }
    
    public void testMustBeEmptyList(){
        ValidationBean1 bean = new ValidationBean1();
        bean.setList(CollectionsUtil.asList("test"));
        IExecutorAnnotationEngine engine = ExecutorFactory.newExecutorAnnotationEngine();
        engine.addBeans(bean);
        try{
            engine.executeInActions("mustBeEmptyListTest");
            fail();
        }catch(ValidationException ex){
            assertTrue(verifyMsgs(ex, "msg5"));
        }
    }
    
}
