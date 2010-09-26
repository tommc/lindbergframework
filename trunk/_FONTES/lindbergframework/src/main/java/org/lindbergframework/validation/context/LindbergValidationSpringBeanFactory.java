package org.lindbergframework.validation.context;

import org.lindbergframework.spring.SpringBeanFactory;
import org.lindbergframework.util.ArrayUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Fábrica de beans devalidação do spring do lindbergframework <br>
 * baseada no contexto org\lindbergframework\spring\conf\validationContext.xml <br><br>
 * 
 * Essa classe mantem uma instancia singleton. Para obter uma instancia use o método {@link #getInstance()}
 *   
 * 
 * @author Victor Lindberg
 *
 */
public class LindbergValidationSpringBeanFactory extends SpringBeanFactory{
	
	private static LindbergValidationSpringBeanFactory instance;
	
	private static final String[] defaultConf = new String[] {"org\\lindbergframework\\spring\\conf\\validationContext.xml"};
	
	private static String[] conf = defaultConf;
	
	private LindbergValidationSpringBeanFactory(ApplicationContext applicationContext){
		super(applicationContext);
	}
	
	/**
	 * retorna a instancia da fábrica 
	 */
	public static LindbergValidationSpringBeanFactory getInstance(){
	   if (instance == null){
		   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(conf);
		   instance = new LindbergValidationSpringBeanFactory(context);
	   }
	   
	   return instance;
	}
	
	/**
	 * Inicializa o contexto baseado no contexto padrão do lindbergframework mais um contexto <br>
	 * adicional passado como argumento. Se o contexto já tiver sido inicializado anteriormente <br>
	 * este é finalizado e recriado com base nas novas configurações. <br><br>
	 * 
	 * O lindbergframework usa o spring e para extender o contexto de validações é necessário usar um xml <br>
	 * de contexto do spring. Neste xml devem estar definidos os beans que implementam IValidation de modo a extender<br>
	 * o contexto das validations de modo que as validations fornecidas pelo framework podem "conviver" diretamente<br>
	 * com as validations definidas fora do framework<br><br>
	 * 
	 * Este método recebe um parametro que é um array com o endereço dentro do classpath do projeto de onde está <br>
	 * cada arquivo xml de contexto. Exemplo org/pacote1/pacote2/contexto.xml
	 * 
	 * @param additionalContext
	 * @return
	 */
	public static LindbergValidationSpringBeanFactory initAdditionalContext(String[] additionalContext){
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
	public static LindbergValidationSpringBeanFactory initDefaultContext(){
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
	public LindbergValidationSpringBeanFactory reInitContext(){
		finishInstance();
		return getInstance();
	}
	
	private static void finishInstance(){
		instance = null;
	}
	
	private static void setConf(String[] conf) {
		LindbergValidationSpringBeanFactory.conf = conf;
	}
	
	
	
}
