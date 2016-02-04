# About lindbergframework - Plug and Use #

## - Easy Persistence JDBC framework; ##
## - IOC(Dependency Injection) provider; ##
## - Abstraction for transparent transaction Management; ##
## - WEB Integration; ##
## - JSF Integration; ##
## - Flex Integration. ##


**Full Documentation (PDF PT\_BR) - http://lindbergframework.googlecode.com/files/lindbergframework-1.0-doc.pdf**

**Contact: victorlindberg713@gmail.com**

## Get with Maven ##

### Maven repository ###
```
 <repository>
    <id>sonatype-releases</id>
    <name>Sonatype Releases Repository</name>
    <url>http://oss.sonatype.org/content/repositories/releases/</url>
 </repository>
```
### Maven Dependency ###

### - lindbergframework - Default/Minimal (Required) ###
```
 <dependency>
    <groupId>org.lindbergframework</groupId>
    <artifactId>lindbergframework</artifactId>
    <version>1.0</version>
 </dependency>
```
### - lindbergframework - General Web Applications (Genreal WEB Projects) ###
```
 <dependency>
    <groupId>org.lindbergframework.web</groupId>
    <artifactId>lindbergframework-web</artifactId>
    <version>1.0</version>
 </dependency>
```
### - lindbergframework - Java Server Faces (JSF) integration (JSF Projects) ###
```
 <dependency>
    <groupId>org.lindbergframework.web</groupId>
    <artifactId>lindbergframework-jsf</artifactId>
    <version>1.0</version>
 </dependency>
```
### - lindbergframework - Flex integration (Flex Projects) ###
```
 <dependency>
    <groupId>org.lindbergframework.web</groupId>
    <artifactId>lindbergframework-flex</artifactId>
    <version>1.0</version>
 </dependency>
```

## Step by Step ##

### 1 - Configuration ###

Configure e and put into your classpath the lindberg-config.xml file below.

Download lindberg configuration Schema (https://lindbergframework.googlecode.com/files/lindberg-config.xsd)

```
<?xml version="1.0" encoding="UTF-8"?>
<lindberg-configuration xmlns="https://lindbergframework.googlecode.com/files" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://lindbergframework.googlecode.com/files lindberg-config.xml ">


<core>
   <config-property name="lindberg.core.di-basepackage" value="com.mycompany.*"/>
   <config-property name="lindberg.core.beanfactory" value="org.lindbergframework.beans.di.context.AnnotationBeanFactory"/>
</core>

<linp>
		<dataSource class="org.springframework.jdbc.datasource.DriverManagerDataSource" 
		    driver="oracle.jdbc.OracleDriver" driverPropertyName="driverClassName">
			<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
			<property name="username" value="SYSTEM" />
			<property name="password" value="admin" />
		</dataSource>
  
		<config-properties>
			<config-property name="lindberg.persistence.Template" value="org.lindbergframework.test.persistence.dao.PersistenceTemplateImpl" />
			<config-property name="lindberg.persistence.IntegerCursorType" value="#oracle.jdbc.OracleTypes.CURSOR" /> <!-- Value specific for Oracle cursors example.  For mysql, for example, it´s not necessary-->
			<config-property name="lindberg.persistence.SqlCommandResolver" value="org.lindbergframework.persistence.sql.ClassPathXmlSqlCommandResolver">
				<property constructor-arg="true">
					<list> 
                       com/myconpany/sql/Updates.xml;
                       com/mycompany/sql/Queries.xml
					</list>
				</property>
			</config-property>
		</config-properties>

	</linp>

</lindberg-configuration>
```

### 2 - Edit your web.xml as below ###

```
<context-param>
<param-name>lindbergConfigLocation</param-name>
<param-value>*com/myconpany/lindberg-config.xml</param-value>
</context-param>
<context-param>
<param-name>lindbergConfigClass</param-name>
<param-alue>org.lindbergframework.core.context.WebClassPathXmlCoreConfiguration</param-value>
</context-param>
<listener>
<listener-class>org.lindbergframework.web.LindbergContextLoaderListener</listener-class>
</listener>
```

### Create your SQL´s mappings as below ###

Download lindberg persistence sql mapping schema (https://lindbergframework.googlecode.com/files/linp-sqlMapping.xsd)

**Defining update commands in sql file. E.g. Updates.sql file**

```
<?xml version="1.0" encoding="UTF-8"?>
<Linp-Mapping xmlns="https://lindbergframework.googlecode.com/files" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://lindbergframework.googlecode.com/files lindberg-config.xml ">

    <Description>Updates</Description>
    
    <Sql-Mapping>
       <Sql-Command id="updatePersonpNicknameAndProfession">
          <Sql-Statement>
              update person set nickname = ?, profession = ? where id = ?
          </Sql-Statement>
       </Sql-Command>
       
       <Sql-Command id="insertPerson">
          <Sql-Statement>insert into person(id,nickname,profession,street,addres_num,birth_date) values(?,?,?,?,?,?)</Sql-Statement>
       </Sql-Command>
       
       <Sql-Command id="deletePerson">
          <Sql-Statement>delete from person where id = ?</Sql-Statement>
       </Sql-Command>
       
       <Sql-Command id="updatePersonNickNameBirthDateProcedure">
          <Procedure name="updatePersonNicknameBirthdate" />
       </Sql-Command>
       
       <Sql-Command id="updatePersonNickBirthDateFunction">
          <Function name="updatePersonNickBirthdateFunc" />
       </Sql-Command>
       
    </Sql-Mapping>          

</Linp-Mapping>
```

**For queries, define SQL queries using JAVA BEANS convention to associate SQL columns (in result queries) and java bean properties. Define the  sql column alias as the associated path to java bean property**

Query for Person example:

- Person class

```
public class Person{
    private long id;
    private String name;
    private Address address;

    /**
        setter´s and getter´s
     **/

}
```

- Address class

```
public class Address{
    private int number;
    private int zipCode;
    private String street;

    /**
        setter´s and getter´s
     **/

}
```

> - MYSQL Example: Select id, name, number address.number, zipcode address.zipCode, street address.street from Person
> - Postgresql Example: Select id, name, number as 'address.number', zipcode as 'address.zipCode', street as 'address.street' from Person

> '**' The columns alias 'address.number', 'address.zipCode' and 'addres.street' corresponds to person.address.number, person.address.zipCode and person.address.street java bean properties.**

**Defining query commands in sql file. E.g. Queries.sql file**

```

<?xml version="1.0" encoding="UTF-8"?>
<Linp-Mapping xmlns="https://lindbergframework.googlecode.com/files" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="https://lindbergframework.googlecode.com/files lindberg-config.xml ">

    <Description>Queries</Description>
    
    <Sql-Mapping>
       <Sql-Command id="queryPersons">
          <Sql-Statement>select p.*,street addres.street, addres_num addres.number from person p</Sql-Statement>
       </Sql-Command>
       
       <Sql-Command id="queryPersonsLikeNickname">
          <Sql-Statement>select p.*,street addres.street, addres_num addres.number from person p where nickname like ?</Sql-Statement>
       </Sql-Command>
       
       <Sql-Command id="queryPersonsFromId">
          <Sql-Statement>select p.*,street addres.street, addres_num addres.number from person p where id = ?</Sql-Statement>
       </Sql-Command>
       
       <Sql-Command id="queryPersonsFromBirth_date">
          <Sql-Statement>select p.*,street addres.street, addres_num addres.number from person p where birth_date = ?</Sql-Statement>
       </Sql-Command>
       
       <Sql-Command id="queryEmployees">
          <Sql-Statement>select p.*,street addres.street, addres_num addres.number, 1000 wage from person p</Sql-Statement>
       </Sql-Command>
       
       <Sql-Command id="queryPersonsFromProcedure">
          <Procedure name="listPersonsLikeNickName" >
             <OutCursor population-class="org.lindbergframework.test.testBeans.Person"/>
          </Procedure>
       </Sql-Command>
              
       <Sql-Command id="queryOut3PersonsFromProcedure">
          <Procedure name="out3Persons" >
             <OutCursor population-class="org.lindbergframework.test.testBeans.Person"/>
             <OutCursor population-class="org.lindbergframework.test.testBeans.Person"/>
             <OutCursor population-class="org.lindbergframework.test.testBeans.Person"/>
          </Procedure>
       </Sql-Command>  
       
       <Sql-Command id="queryPersonsFromFunction">
          <Function name="listPersonsLikeNickNameFunc" resultName="personsList">
             <ResultCursor population-class="org.lindbergframework.test.testBeans.Person" />
          </Function>
       </Sql-Command>
       
       <Sql-Command id="simpleProcedure">
          <Procedure name="simpleProcedure" />
       </Sql-Command>
       
       <Sql-Command id="simpleFunction">
          <Function name="simpleFunction" />
       </Sql-Command>
              
    </Sql-Mapping>          

</Linp-Mapping>
```


### 4 - DAO´s ###

```
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.persistence.dao.LinpDAO;
import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlFunction;
import org.lindbergframework.test.testBeans.Employee;
import org.lindbergframework.test.testBeans.Person;

@Bean("personDAO")
public class PersonDAOImpl extends LinpDAO
                                  implements PersonDAO{

	public PersonDAO() {
		//
	}
	
	public List<Person> listPersons(){
		return getPersistTemplate().execQuery(Person.class, "queryPersons");
	}

	public List<Person> listPersonsLikeNickName(String nickname){
		return getPersistTemplate().execQuery(Person.class, "queryPersonsLikeNickname",nickname+"%");
	}
	
	public void insertPerson(Person person){
		getPersistTemplate().execUpdate("insertPerson", person.getId(),
				                                   person.getNickname(),
				                                   person.getProfession(),
				                                   person.getAddres().getStreet(),
				                                   person.getAddres().getNumber(),
				                                   person.getBirthDate());
	}
	
	public void updateNickNamePerson(Person person){
		getPersistTemplate().execUpdate("updatePersonpNicknameAndProfession", person.getNickname(),
				                                           person.getProfession(),
				                                           person.getId());
	}
	
	public Person getPersonFromId(int id){
		return getPersistTemplate().execQueryForObject(Person.class, "queryPersonsFromId", id);
	}
	
	public void deletePerson(int id){
		getPersistTemplate().execUpdate("deletePerson", id);
	}
	
	public List<Person> listPersonsFromBirthDate(Date date){
		return getPersistTemplate().execQuery(Person.class, "queryPersonsFromBirth_date", date);
	}
	
	public void updatePersonNickNameBirthDateFromProcedure(int id, String nick, Date birthDate){
		getPersistTemplate().callProcedure("updatePersonNickNameBirthDateProcedure", SqlArg.get("pid", id),
			                                                                   SqlArg.get("pnickname", nick),
			   																   SqlArg.get("pbirth_date", birthDate));	
	}
	
	public Date updatePersonNickNameBirthDateFromFunction(int id, String nick, Date birthDate){
		Map map = getPersistTemplate().callFunction("updatePersonNickBirthDateFunction", SqlArg.get("pid", id),
				SqlArg.get("pnickname", nick),
				SqlArg.get("pbirth_date", birthDate));
		
		return (Date) map.get(SqlFunction.DEFAULT_RESULT_NAME);
	}
	
	public List<Employee> queryEmployees(){
		return getPersistTemplate().execQuery(Employee.class, "queryEmployees");
	}
	
	public int getTotalPersons(){
        return getPersistTemplate().execSqlQueryForObject(Integer.class, "select count(*) from person");
    }
	
	public void callSimpleProcedure(){
	    getPersistTemplate().callProcedure("simpleProcedure");
	}
	
	public void callSimpleFunction(){
		getPersistTemplate().callFunction("simpleFunction");
	}
	
	public List<Person> listPersonsFromProcedure(String nick){
	       Map map = getPersistTemplate().callProcedure("queryPersonsFromProcedure", new SqlArg("pNick",nick));
	       return (List<Person>) map.get("persons");
	}
		
	public List<Person> out3PersonsFromProcedure(){
			Map map = getPersistTemplate().callProcedure("queryOut3PersonsFromProcedure");
			Person person = ((List<Person>) map.get("person")).get(0);
			Person person2 = ((List<Person>) map.get("person2")).get(0);
			Person person3 = ((List<Person>) map.get("person3")).get(0);
			
			List<Person> persons = new ArrayList<Person>();
			persons.add(person);
			persons.add(person2);
			persons.add(person3);
			
			return persons;
	}
		
	public List<Person> listPersonsFromFunction(String nick){
			Map map = getPersistTemplate().callFunction("queryPersonsFromFunction", new SqlArg("pnick",nick));
			List<Person> persons = (List<Person>) map.get("personsList");
			String strOut = (String) map.get("str");
			
			if (! persons.isEmpty())
			   persons.get(0).setNickname(strOut);
			
			return persons;
	}
}

```

**Business Controller accessing DAO using IOC - (LDIC Lindberg Dependency Injection Container)**

Use @Bean to define and register a BEAN into UserBeanContext - Managed beans by BeanFactory. BeanFactory will auto-detect annotated beans with @Bean.

Use @Inject within a annotated bean with @Bean to request an instance from dependency injection container.


```
import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;

@Bean("personBO")
public class PersonBOImpl implements PersonBO{
	
	@Inject("personDAO")
	private PersonDAO personDAO;

	public PersonBOImpl() {
		//
	}
	
	/**
	 * Methods...
	 */
}
```

**Defining a bean as 'singleton':**
```
@Bean(value = "facade",singleton = true)
public class Facade implements IsistemaFacade{}
```

### 5 - Transaction Management ###

**Note the method with @Transax for method scope transaction as below**

```
import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;
import org.lindbergframework.persistence.transaction.annotation.Transax;
import org.lindbergframework.test.testBeans.Person;

@Bean("personBO")
public class PersonBOImpl implements PersonBO{
	
	@Inject("personDAO")
	private PersonDAO personDAO;

	public PersonBOImpl() {
		//
	}
	
	*@Transax*
	public void insertPerson(Person person){
		personDAO.insertPerson(person);
	}
	
	/**
	 * Methods...
	 */
}
```


**Note the class with @Transax for class scope transaction as below**

```
import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;
import org.lindbergframework.persistence.transaction.annotation.Transax;
import org.lindbergframework.test.testBeans.Person;

@Bean("personBO")
*@Transax*
public class PersonBOImpl implements PersonBO{
	
	@Inject("personDAO")
	private PersonDAO personDAO;

	public PersonBOImpl() {
		//
	}
	
	/**
	 * Methods...
	 */
}
```

### 6 - Starting context programmatically (main method). For WEB Application, just configure your web.xml (Topic 2 in this document) ###
```
package org.lindbergframework.test.persistence.dao;

import org.lindbergframework.beans.di.context.UserBeanContext;
import org.lindbergframework.core.configuration.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.configuration.CoreConfiguration;
import org.lindbergframework.core.context.CoreContext;

public class Main {

	public static void main(String[] args) {
	      CoreConfiguration configuration = new ClassPathXmlCoreConfiguration("com/mycompany/lindberg-config.xml");
              configuration.initializeContext();
              Person p = new Person();
              //populate person
              PersonBO bo = UserBeanContext.getInstance().getBean("personBO");/*Get instance for Business Object from BeanFactory*/
              bo.insertPerson(p);
	}
}

```

### 7 - Integrating Bean Context with JSF ###

To integrate bean context with JSF, just register the Resolver below in your faces-config.xml.

```
<?xml version="1.0" encoding="UTF-8"?>
<faces-config xmlns="http://java.sun.com/xml/ns/javaee"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facesconfig_2_0.xsd"
version="2.0">
<application>
<el-resolver>org.lindbergframework.integration.web.jsf.beans.LindbergBeanJsfResolver</el-resolver>
</application>
</faces-config>
```

**ManagedBean example**

```
import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;
import org.lindbergframework.test.testBeans.Person;

@Bean("perosnMB")
public class PersonMB {
	
	@Inject
	private PersonBO personBO;
	
	private Person person;

	public MyMB() {
		//
	}
	
	public void insert(Person person){
		personBO.insert(person);
	}
	public PersonBO getPersonBO() {
		return personBO;
	}

	public void setPersonBO(PersonBO personBO) {
		this.personBO = personBO;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}

*Page example*

{{{
<h:commandButton action="#{personMB.insert}" value="Insert" />
}}}

```

### 8 - Integrating Bean Context with Adobe Flex ###

Define your servicesconfig.xm as below:
```
<?xml version="1.0" encoding="UTF-8"?>
<services-config>
<factories>
<factory id="lindbergFactory" class="org.lindbergframework.integration.web.flex.LindbergFlexBeanFactory" />
</factories>
</services-config>
```

### 9 - Full Documentation (only Portuguese-Brazil) ###
http://lindbergframework.googlecode.com/files/lindbergframework-1.0-doc.pdf

### 10 - Contact ###
**victorlindberg713@gmail.com**