package org.lindbergframework.test.persistence.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.persistence.dao.LinpDAO;
import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlFunction;
import org.lindbergframework.test.testBeans.Employee;
import org.lindbergframework.test.testBeans.Person;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Bean("daoTest")
public class PersistTemplateDaoTest extends LinpDAO{
	
	public PersistTemplateDaoTest(){
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
	
}
