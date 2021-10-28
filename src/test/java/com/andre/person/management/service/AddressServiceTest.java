package com.andre.person.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.andre.person.management.model.entity.Address;
import com.andre.person.management.model.repository.AddressPersonRepository;
import com.andre.person.management.model.repository.AddressRepository;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

	@InjectMocks
	AddressService service;

	@Mock
	AddressRepository addressRepository;

	@Mock
	AddressPersonRepository addressPersonRepository;

	private Address address;
	private Address addressWithId;

	@BeforeEach
	public void setUp() {
		this.addressWithId = Address.builder().city("Dublin").postalCode("D01Y99K").street("Dublin Street")
				.state("Co. Dublin").addressId(1L).build();
		this.address = Address.builder().city("Dublin").postalCode("D01Y99K").street("Dublin Street")
				.state("Co. Dublin").build();
	}

	@Test
	@Order(1)
	public void testAddNew() {
		when(addressRepository.save(address)).thenReturn(addressWithId);

		Address resultAddress = service.addNew(address);
		assertEquals(addressWithId, resultAddress);
	}

	@Test
	@Order(2)
	public void update() {
		Address changedAddress = Address.builder().city("Ashbourne").postalCode("A01Y99K").street("Meath Street")
				.state("Co. Meath").addressId(1L).build();
		when(addressRepository.save(changedAddress)).thenReturn(changedAddress);
		
		Address resultAddress = service.update(changedAddress);
		assertEquals(changedAddress, resultAddress);		
	}

	@Test
	@Order(3)
	public void delete() {
		when(addressRepository.save(address)).thenReturn(addressWithId);
		when(addressRepository.findById(1L)).thenReturn(Optional.of(addressWithId));
		service.addNew(address);
		Address insertedAddress = addressRepository.findById(1L).get();
		assertEquals(1L, insertedAddress.getAddressId());
		service.delete(1L);
		verify(addressRepository).deleteById(1L);		
	}

}
