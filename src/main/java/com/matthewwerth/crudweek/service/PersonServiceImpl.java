package com.matthewwerth.crudweek.service;

import com.matthewwerth.crudweek.model.Person;
import com.matthewwerth.crudweek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
      return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Optional<Person> personDb = this.personRepository.findById(person.getId());

        if(personDb.isPresent()){
            Person personUpdate = personDb.get();
            personUpdate.setId(person.getId());
            personUpdate.setName(person.getName());
            personUpdate.setBio(person.getBio());
            personRepository.save(personUpdate);
            return personUpdate;
        }
        return null;
    }

    @Override
    public List<Person> getAllPersons() {
        return this.personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> personDB = this.personRepository.findById(id);
        return personDB.orElse(null);
    }

    @Override
    public void deletePerson(Long id) {
        Optional<Person> personDB = this.personRepository.findById(id);
        personDB.ifPresent(person -> this.personRepository.delete(person));
    }
}
