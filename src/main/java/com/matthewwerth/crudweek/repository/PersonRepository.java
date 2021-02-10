package com.matthewwerth.crudweek.repository;

import com.matthewwerth.crudweek.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
