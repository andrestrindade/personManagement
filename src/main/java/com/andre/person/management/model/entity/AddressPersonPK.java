package com.andre.person.management.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class AddressPersonPK implements Serializable {

	private static final long serialVersionUID = 1L;

	public AddressPersonPK(Long addressId, Long personId) {
		this.address = new Address(addressId);
		this.person = new Person(personId);
	}

	@OneToOne
	@JoinColumn(name = "personId", referencedColumnName = "personId")
	protected Person person;

	@ManyToOne
	@JoinColumn(name = "addressId", referencedColumnName = "addressId")
	protected Address address;

}
