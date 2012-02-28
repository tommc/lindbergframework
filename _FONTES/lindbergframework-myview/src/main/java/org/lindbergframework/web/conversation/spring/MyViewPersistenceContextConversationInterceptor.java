package org.lindbergframework.web.conversation.spring;

import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.myfaces.orchestra.conversation.spring.PersistenceContextConversationInterceptor;
import org.apache.myfaces.orchestra.conversation.spring.PersistenceContextFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * {@link PersistenceContextConversationInterceptor} extension that verify automatically the 
 * defined {@link PersistenceContextFactory} and decides if the conversation interceptor must be applied.
 *  
 * @author Victor Lindberg
 *
 */
public class MyViewPersistenceContextConversationInterceptor extends PersistenceContextConversationInterceptor
				implements ApplicationContextAware{

	private boolean applyInterceptor;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private ApplicationContext context;
	
	public MyViewPersistenceContextConversationInterceptor() {
		//
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}
	
	public void init(){
		String[] beanNamesForContextFactory = context.getBeanNamesForType(PersistenceContextFactory.class);
		
		if (beanNamesForContextFactory.length > 1)
			throw new BeanInstantiationException(getClass(), "Não foi possível inicializar ["+getClass().getName()+"]. " +
					"Mais de um bean do tipo [PersistenceContextFactory] foi encontrado quando no máximo um era esperado", null);
		
		applyInterceptor = beanNamesForContextFactory.length != 0;
		
		if (applyInterceptor){
			PersistenceContextFactory factory = (PersistenceContextFactory) context.getBean(beanNamesForContextFactory[0]);
			setPersistenceContextFactory(factory);
		}else
			logger.warning("Nenhum PersistenceContextFactory foi definido dentro do contexto do spring. Isto pode ocasionar " +
					"alguns problemas, de lazy por exemplo, referentes a Sessions do hibernate e EntityManagers da JPA. " +
					"Defina um em seu arquivo de configuração do spring. " +
					"Para hibernate, use [org.lindbergframework.web.conversation.spring.HibernatePersistenceContextFactory] " +
					"passando [sessionFactory]. Para JPA use [org.apache.myfaces.orchestra.conversation.spring.JpaPersistenceContextFactory] " +
					"passando [entityManagerFactory].");
	}
	
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		if (applyInterceptor)
			return super.invoke(methodInvocation);
		
		return methodInvocation.proceed();
	}
	
}
