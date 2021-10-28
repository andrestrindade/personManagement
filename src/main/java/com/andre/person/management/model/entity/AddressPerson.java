package com.andre.person.management.model.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Address_Person")
@Builder
public class AddressPerson implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AddressPerson(Long addressId, Long personId) {
		this.id = new AddressPersonPK(addressId, personId);
	}

	@EmbeddedId
	private AddressPersonPK id;

}