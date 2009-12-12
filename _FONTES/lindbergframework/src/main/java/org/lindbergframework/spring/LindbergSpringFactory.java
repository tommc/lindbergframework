package org.lindbergframework.spring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.lindbergframework.util.ArrayUtil;
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
	
	private static final String[] defaultConf = new String[] {"org\\lindbergframework\\spring\\conf\\appContext.xml"};
	
	private static String[] conf = defaultConf;
	
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
	
	/**
	 * Inicializa o contexto baseado no contexto padrão do lindbergframework mais um contexto <br>
	 * adicional passado como argumento. Se o contexto já tiver sido inicializado anteriormente <br>
	 * este é finalizado e recriado com base nas novas configurações
	 * 
	 * @param additionalContext
	 * @return
	 */
	public static LindbergSpringFactory initAdditionalContext(String[] additionalContext){
		setConf(ArrayUtil.merge(conf, additionalContext, new String[conf.length + additionalContext.length]));
		
		finishInstance();
		return getInstance();
	}
	
	/**
	 * Inicializa o contexto padrão do lindbergframework. O padrão do método {@link #getInstance()} é retorna uma instancia <br>
	 * configurada com o contexto padrão. Por isso esse método só é necessário para reverter um contexto criado <br>
	 * através do método {@link #initAdditionalContext(String[])} que cria contextos adicionais.
	 * 
	 * @return
	 */
	public static LindbergSpringFactory initDefaultContext(){
		setConf(defaultConf);
		
		finishInstance();
		return getInstance();
	}
	
	/**
	 * 
	 * Reinicializa o contexto configurado
	 * 
	 * @return
	 */
	public LindbergSpringFactory reInitContext(){
		finishInstance();
		return getInstance();
	}
	
	private static void finishInstance(){
		springFactory = null;
	}
	
	private static void setConf(String[] conf) {
		LindbergSpringFactory.conf = conf;
	}
	
	
	
}
