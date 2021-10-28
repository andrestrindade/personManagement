package com.andre.person.management.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andre.person.management.model.entity.AddressPerson;
import com.andre.person.management.model.entity.AddressPersonPK;

@Repository
public interface AddressPersonRepository extends JpaRepository<AddressPerson, AddressPersonPK>  {
	
	@Transactional
	@Modifying
	@Query("delete from AddressPerson ap where ap.id.address.addressId = :addressId ")
	int deleteByAddressId(@Param("addressId") Long addressId);

}
