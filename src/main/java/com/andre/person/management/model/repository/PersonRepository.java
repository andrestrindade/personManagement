package com.andre.person.management.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andre.person.management.model.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>  {
	

}
