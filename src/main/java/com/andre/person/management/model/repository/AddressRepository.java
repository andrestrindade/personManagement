package com.andre.person.management.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andre.person.management.model.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>  {
	

}
