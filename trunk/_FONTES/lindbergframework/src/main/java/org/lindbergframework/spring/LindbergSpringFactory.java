package org.lindbergframework.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Fábrica de beans do spring do lindbergframework <br>
 * baseada no contexto org\lindbergframework\spring\conf\appContext.xml <br><br>
 * 
 * Essa classe mantem uma instancia singleton. Para obter uma instancia use o método {@link #getInstance()}
 *   
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergSpringFactory extends SpringBeanFactory{
	
	private static LindbergSpringFactory springFactory;
	
	private static String[] conf = new String[] {"org\\lindbergframework\\spring\\conf\\appContext.xml"};
	
	private LindbergSpringFactory(ApplicationContext applicationContext){
		super(applicationContext);
	}
	
	/**
	 * retorna a instancia da fábrica 
	 */
	public static LindbergSpringFactory getInstance(){
	   if (springFactory == null){
		   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(conf);
		   springFactory = new LindbergSpringFactory(context);
	   }
	   
	   return springFactory;
	}
	
}
