package br.com.lindbergframework.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergSpringFactory extends SpringBeanFactory{
	
	private static LindbergSpringFactory springFactory;
	
	private static String[] conf = new String[] {"br\\com\\lindbergframework\\spring\\conf\\appContext.xml"};
	
	public LindbergSpringFactory(ApplicationContext applicationContext){
		super(applicationContext);
	}
	
	public static LindbergSpringFactory getInstance(){
	   if (springFactory == null){
		   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(conf);
		   springFactory = new LindbergSpringFactory(context);
	   }
	   
	   return springFactory;
	}
	
}
