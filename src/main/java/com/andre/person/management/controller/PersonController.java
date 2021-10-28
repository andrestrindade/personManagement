package com.andre.person.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.andre.person.management.model.entity.Person;
import com.andre.person.management.service.PersonService;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	final RestTemplate restTemplate = new RestTemplate();

	@PostMapping(value = "/add", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Person> addPerson(@RequestBody() Person person) {
		Person newPerson = personService.addNew(person);
		return new ResponseEntity<Person>(newPerson, HttpStatus.OK);
	}

	@PutMapping(value = "/edit", produces = "application/json")
	public ResponseEntity<Person> editPerson(@RequestBody() Person person) {
		Person editedPerson;
		try {
			editedPerson = personService.update(person);
		} catch (InvalidDataAccessApiUsageException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return new ResponseEntity<Person>(editedPerson, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public void deletePerson(
			@ApiParam(value = "Person ID", required = true, example = "123") @RequestBody() Long personId) {
		personService.delete(personId);
	}

	@GetMapping("/count")
	public @ResponseBody long countPersons() {
		return personService.count();
	}

	@GetMapping(value = "/list", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Person>> listPersons() {
		List<Person> persons = personService.list();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

}
