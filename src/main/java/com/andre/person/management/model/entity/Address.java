package com.andre.person.management.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Address")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	
	public Address(Long addressId) {
        this.addressId = addressId;
    }
	
	@Id
	@GeneratedValue
	private Long addressId;
	
	@Column
	private String street;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String postalCode;
	
	@Transient
	Set<Long> personIds;
}
