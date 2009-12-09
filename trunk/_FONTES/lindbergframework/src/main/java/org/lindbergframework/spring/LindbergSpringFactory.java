package org.lindbergframework.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * F�bri de beans do spring do lindbergframework <br>
 * baseada no contexto org\lindbergframework\spring\conf\appContext.xml <br><br>
 * 
 * Essa classe mantem uma instancia singleton. Para obter uma instancia use o m�todo {@link #getInstance()}
 *   
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergSpringFactory extends SpringBeanFactory{
	
	private static LindbergSpringFactory springFactory;
	
	private static String[] conf = new String[] {"org\\lindbergframework\\spring\\conf\\appContext.xml"};
	
	public LindbergSpringFactory(ApplicationContext applicationContext){
		super(applicationContext);
	}
	
	/**
	 * retorna a instancia da f�brica 
	 */
	public static LindbergSpringFactory getInstance(){
	   if (springFactory == null){
		   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(conf);
		   springFactory = new LindbergSpringFactory(context);
	   }
	   
	   return springFactory;
	}
	
}
