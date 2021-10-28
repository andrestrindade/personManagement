package com.andre.person.management.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Person")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	public Person(Long personId) {
		this.personId = personId;
	}
	
	@Id
	@GeneratedValue
	private Long personId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	

}
