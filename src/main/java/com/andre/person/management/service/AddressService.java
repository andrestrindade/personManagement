package com.andre.person.management.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.andre.person.management.model.entity.Address;
import com.andre.person.management.model.entity.AddressPerson;
import com.andre.person.management.model.repository.AddressPersonRepository;
import com.andre.person.management.model.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	AddressPersonRepository addressPersonRepository;

	public Address addNew(Address address) throws InvalidDataAccessApiUsageException {
		if (address.getAddressId() != null) {
			throw new InvalidDataAccessApiUsageException(
					"In order to create a new address, the address ID should be null.");
		}
			Address newAddress = addressRepository.save(address);
			savePersonsToAddress(newAddress);
			return newAddress;			 
	}

	public Address update(Address address) throws InvalidDataAccessApiUsageException {
		if (address.getAddressId() == null) {
			throw new InvalidDataAccessApiUsageException("Address ID is mandatory to update an address.");
		}
		return addressRepository.save(address);
	}

	public void delete(Long addressId) {
		addressPersonRepository.deleteByAddressId(addressId);
		addressRepository.deleteById(addressId);
	}
	
	private void savePersonsToAddress(Address address) {
		Set<AddressPerson> addressPersons = new HashSet<>();
		
		if(address.getPersonIds() == null) {
			return;
		}
		
		address.getPersonIds().forEach(personId -> {
			AddressPerson addressPerson = new AddressPerson(address.getAddressId(), personId);
			addressPersons.add(addressPerson);
		});		
		addressPersonRepository.saveAll(addressPersons);
	}

}
