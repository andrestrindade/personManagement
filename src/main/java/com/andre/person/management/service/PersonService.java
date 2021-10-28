package com.andre.person.management.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.andre.person.management.model.entity.Person;
import com.andre.person.management.model.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public Person addNew(Person person) throws InvalidDataAccessApiUsageException {
		if (person.getPersonId() != null) {
			throw new InvalidDataAccessApiUsageException(
					"In order to create a new person, the person ID should be null.");
		}
		return personRepository.save(person);
	}

	public Person update(Person person) throws InvalidDataAccessApiUsageException {
		if (person.getPersonId() == null) {
			throw new InvalidDataAccessApiUsageException("Person ID is mandatory to update a person.");
		}
		return personRepository.save(person);
	}

	public void delete(Long personId) {
		personRepository.deleteById(personId);
	}

	public List<Person> list() {
		return StreamSupport.stream(personRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public long count() {
		return StreamSupport.stream(personRepository.findAll().spliterator(), false).count();
	}

}
