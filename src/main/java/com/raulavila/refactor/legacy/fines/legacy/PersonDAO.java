package com.raulavila.refactor.legacy.fines.legacy;

import com.raulavila.refactor.legacy.fines.model.Person;

public class PersonDAO {
    public static final Person JOHN = new Person(1, "John");
    public static final Person RAUL = new Person(2, "Raul");
}


//private static List<Person> personList =
//        Lists.newArrayList(
//                new Person(1, "John"),
//                new Person(2, "Raul"));
//
//    public static Person getPersonByName(String name) {
//        for (Person person : personList) {
//            if (person.getName().equals(name)) {
//                return person;
//            }
//        }
//        return null;
//    }
