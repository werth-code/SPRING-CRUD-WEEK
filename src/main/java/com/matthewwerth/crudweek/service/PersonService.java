package com.matthewwerth.crudweek.service;

import com.matthewwerth.crudweek.model.Person;
import com.matthewwerth.crudweek.model.Product;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);
    Person updatePerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(Long id);
    void deletePerson(Long id);
}
