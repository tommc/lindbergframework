package org.lindbergframework.test.persistence.dao.oracle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlFunction;
import org.lindbergframework.test.persistence.dao.PersistTemplateDaoTest;
import org.lindbergframework.test.testBeans.Person;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class OraclePersistTemplateDaoTest extends PersistTemplateDaoTest{
	
	public OraclePersistTemplateDaoTest(){
		//
	}
	
	public List<Person> listPersonsFromProcedure(String nick){
	       Map map = getPersistTemplate().callProcedure("queryPersonsFromProcedure", new SqlArg("PNICK",nick));
	       return (List<Person>) map.get("PERSONS");
		}
		
		public List<Person> out3PersonsFromProcedure(){
			Map map = getPersistTemplate().callProcedure("queryOut3PersonsFromProcedure");
			Person person = ((List<Person>) map.get("PERSON")).get(0);
			Person person2 = ((List<Person>) map.get("PERSON2")).get(0);
			Person person3 = ((List<Person>) map.get("PERSON3")).get(0);
			
			List<Person> persons = new ArrayList<Person>();
			persons.add(person);
			persons.add(person2);
			persons.add(person3);
			
			return persons;
		}
		
		public List<Person> listPersonsFromFunction(String nick){
			Map map = getPersistTemplate().callFunction("queryPersonsFromFunction", new SqlArg("PNICK",nick));
			List<Person> persons = (List<Person>) map.get("personsList");
			String strOut = (String) map.get("STR");
			
			if (! persons.isEmpty())
			   persons.get(0).setNickname(strOut);
			
			return persons;
		}
		
		//TODO: Remove when the case sencitive problem is ok
		public void updatePersonNickNameBirthDateFromProcedure(int id, String nick, Date birthDate){
			getPersistTemplate().callProcedure("updatePersonNickNameBirthDateProcedure", SqlArg.get("PID", id),
					                                                                   SqlArg.get("PNICKNAME", nick),
					   																   SqlArg.get("PBIRTH_DATE", birthDate));	
		}
			
		//TODO: Remove when the case sencitive problem is ok
		public Date updatePersonNickNameBirthDateFromFunction(int id, String nick, Date birthDate){
				Map map = getPersistTemplate().callFunction("updatePersonNickBirthDateFunction", SqlArg.get("PID", id),
						SqlArg.get("PNICKNAME", nick),
						SqlArg.get("PBIRTH_DATE", birthDate));
				
				return (Date) map.get(SqlFunction.DEFAULT_RESULT_NAME);
		}

}
