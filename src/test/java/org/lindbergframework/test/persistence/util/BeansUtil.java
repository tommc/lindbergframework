package org.lindbergframework.test.persistence.util;

import java.util.Date;

import org.lindbergframework.test.testBeans.Address;
import org.lindbergframework.test.testBeans.Person;

/**
 * @author Victor Lindberg
 */
public final class BeansUtil {

    public static Person createPerson(Integer id, String nickname,
        String profession, String street, int addresNumber, Date birthDate) {
        Person person = new Person();
        person.setId(id);
        person.setNickname(nickname);
        person.setProfession(profession);
        person.setBirthDate(birthDate);

        Address address = new Address();
        address.setStreet(street);
        address.setNumber(addresNumber);
        person.setAddres(address);

        return person;
    }

    public static Person createPerson(Integer id, String nickname,
        String profession, String street, int addresNumber) {
        return createPerson(id, nickname, profession, street, addresNumber,
            null);
    }

}
