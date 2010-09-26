package org.lindbergframework.test.persistence.test;

import java.util.Date;

import org.lindbergframework.core.context.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.context.CoreConfiguration;
import org.lindbergframework.core.context.CoreContext;
import org.lindbergframework.persistence.context.LinpContext;
import org.lindbergframework.test.testBeans.Address;
import org.lindbergframework.test.testBeans.Person;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * @author Victor Lindberg
 */
public class LinpTestBase extends
    AbstractTransactionalDataSourceSpringContextTests {

    private CoreConfiguration configuration;

    private String configResourceLocation;

    public LinpTestBase(String configResourceLocation) {
        this.configResourceLocation = configResourceLocation;
    }

    @Override
    protected void onSetUp() throws Exception {
        if (!CoreContext.getInstance().isActive()) {
            configuration = new ClassPathXmlCoreConfiguration(
                configResourceLocation);
            CoreContext.getInstance().loadConfiguration(configuration);
        }
        setDataSource(LinpContext.getInstance().getDataSource());
        setTransactionManager(new DataSourceTransactionManager(LinpContext.getInstance().getDataSource()));

        super.onSetUp();
    }

    @Override
    protected void onTearDown() throws Exception {
        super.onTearDown();
        CoreContext.getInstance().close();
    }


}
