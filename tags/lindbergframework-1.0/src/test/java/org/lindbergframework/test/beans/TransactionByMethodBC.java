package org.lindbergframework.test.beans;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.persistence.transaction.annotation.Transax;
import org.lindbergframework.test.testBeans.Person;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Bean("transactionByMethodBC")
public class TransactionByMethodBC extends NoTransactionalBC{
    
    @Transax
    public void insertInsertDeleteInsertPerson(Person personInsert1,
        Person personInsert2, Person personDelete, Person personInsert3) {
        super.insertInsertDeleteInsertPerson(personInsert1, personInsert2,
            personDelete, personInsert3);
    }
    
    @Transax
    public void insertPersons(Person... persons) {
        super.insertPersons(persons);
    }
    
}
