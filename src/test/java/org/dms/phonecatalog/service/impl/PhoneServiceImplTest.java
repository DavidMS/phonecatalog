/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.phonecatalog.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dms.phonecatalog.entity.Phone;
import org.dms.phonecatalog.repository.PhoneRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceImplTest {

	@Mock
	PhoneRepository repository;

	@InjectMocks
	PhoneServiceImpl phoneService;

	@Test
	public void getAllPhonesTest() throws Exception {
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		List<Phone> phones = new ArrayList<>();
		phones.add(phone1);
		phones.add(phone2);

		when(this.repository.findAll()).thenReturn(phones);

		List<Phone> result = this.phoneService.getAllPhones();

		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	public void getPhoneByIdTest() throws Exception {
		Phone phone1 = new Phone();
		phone1.setId(1L);
		Optional<Phone> phoneOptional = Optional.of(phone1);

		when(this.repository.findById(1L)).thenReturn(phoneOptional);

		Optional<Phone> result = this.repository.findById(1L);
		assertTrue(result.isPresent());
		assertEquals(1L, result.get().getId(), 0);
	}

	@Test
	public void getTotalPriceByIdsTest() throws Exception {
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		phone1.setPrice(BigDecimal.valueOf(200.0));
		phone2.setPrice(BigDecimal.valueOf(200.0));
		phone1.setId(1L);
		phone2.setId(2L);
		List<Phone> phones = new ArrayList<>();
		phones.add(phone1);
		phones.add(phone2);
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);

		when(this.repository.findAllById(ids)).thenReturn(phones);

		BigDecimal result = this.phoneService.getTotalPriceByIds(ids);

		assertNotNull(result);
		assertEquals(BigDecimal.valueOf(400.0), result);
	}

	@Test
	public void getTotalPriceByIdsNoPhonesTest() throws Exception {
		List<Phone> phones = new ArrayList<>();
		List<Long> ids = new ArrayList<>();

		when(this.repository.findAllById(ids)).thenReturn(phones);

		BigDecimal result = this.phoneService.getTotalPriceByIds(ids);

		assertNotNull(result);
		assertEquals(BigDecimal.valueOf(0.0), result);
	}

	@Test
	public void validateOrderTrueTest() throws Exception {
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);

		when(this.repository.existsById(Mockito.anyLong())).thenReturn(true);

		boolean result = this.phoneService.validateOrder(ids);

		assertTrue(result);
	}

	@Test
	public void validateOrderFalseTest() throws Exception {
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);

		when(this.repository.existsById(Mockito.anyLong())).thenReturn(false);

		boolean result = this.phoneService.validateOrder(ids);

		assertFalse(result);
	}

}
