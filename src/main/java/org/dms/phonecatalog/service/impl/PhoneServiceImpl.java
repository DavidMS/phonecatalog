/*
 * @author: ${author}
 * @date: 15-sep-2018
 * 
 */
package org.dms.phonecatalog.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dms.phonecatalog.entity.Phone;
import org.dms.phonecatalog.repository.PhoneRepository;
import org.dms.phonecatalog.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

	private PhoneRepository repository;

	@Autowired
	public PhoneServiceImpl(PhoneRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Phone> getAllPhones() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Phone> getPhoneById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public BigDecimal getTotalPriceByIds(List<Long> ids) {
		List<Phone> phones = this.repository.findAllById(ids);
		List<BigDecimal> prices = phones.stream().map(Phone::getPrice).collect(Collectors.toList());
		return prices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public boolean validateOrder(List<Long> ids) {
		for (Long id : ids) {
			if (!this.repository.existsById(id)) {
				return false;
			}
		}
		return true;
	}

}
