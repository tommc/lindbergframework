package org.lindbergframework.exemplo;

import org.lindbergframework.beans.di.context.UserBeanContext;
import org.lindbergframework.core.configuration.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.configuration.CoreConfiguration;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class LinpTransactionTest {

    public static void main(String[] args) {
        CoreConfiguration coreConfiguration = new ClassPathXmlCoreConfiguration("org/lindbergframework/exemplo/conf/lindberg-config.xml");
        coreConfiguration.initializeContext();
        
        PessoaTransaction pessoaTransaction = UserBeanContext.getInstance().getBean("pessoaTransaction");
        pessoaTransaction.test();
    }

    
}
