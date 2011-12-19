package org.lindbergframework.test.beans;

import java.util.List;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;
import org.lindbergframework.test.persistence.dao.PersistTemplateDaoTest;
import org.lindbergframework.test.testBeans.Person;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Bean("noTransactionalBC")
public class NoTransactionalBC {
    
    @Inject("daoTest")
    private PersistTemplateDaoTest dao; 
    
    public NoTransactionalBC(){
        //
    }
    
    public void insertPersons(Person... persons){
        for (Person person : persons)
            dao.insertPerson(person);
    }
    
    public void insertInsertDeleteInsertPerson(Person personInsert1, Person personInsert2 ,Person personDelete, Person personInsert3){
        dao.insertPerson(personInsert1);
        dao.insertPerson(personInsert2);
        dao.deletePerson(personDelete.getId());
        dao.insertPerson(personInsert3);
    }
    
    public void updateNickPersonAndInsertNewPerson(Person personUpdate, Person personInsert){
         dao.updateNickNamePerson(personUpdate);
         dao.insertPerson(personInsert);
    }
    
    public void updateNickBirthDatePersonFromProcedureAndInsertNewPerson(Person personUpdate, Person personInsert){
        dao.updatePersonNickNameBirthDateFromProcedure(personUpdate.getId(), personUpdate.getNickname(), personUpdate.getBirthDate());
        dao.insertPerson(personInsert);
    }
    
    public List<Person> listPersons(){
        return dao.listPersons();
    }
    
    public void deletePersons(Person... persons){
        for (Person person : persons)
            dao.deletePerson(person.getId());
        
    }

}
