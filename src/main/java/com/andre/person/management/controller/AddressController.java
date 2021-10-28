package com.andre.person.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andre.person.management.model.entity.Address;
import com.andre.person.management.service.AddressService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping(value = "/add", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Address> addAddress(@RequestBody() Address address) {
		Address newAddress = addressService.addNew(address);
		return new ResponseEntity<Address>(newAddress, HttpStatus.OK);
	}

	@PutMapping(value = "/edit", produces = "application/json")
	public ResponseEntity<Address> editAddress(@RequestBody() Address address) {
		Address editedAddress;
		try {
			editedAddress = addressService.update(address);
		} catch (InvalidDataAccessApiUsageException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return new ResponseEntity<Address>(editedAddress, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public void deleteAddress(
			@ApiParam(value = "Address ID", required = true, example = "123") @RequestBody() Long addressId) {
		addressService.delete(addressId);
	}

}
