/*
 * @author: ${author}
 * @date: 16-sep-2018
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

/**
 * The Class PhoneServiceImpl.
 */
@Service
public class PhoneServiceImpl implements PhoneService {

	/** The repository. */
	private PhoneRepository repository;

	/**
	 * Instantiates a new phone service impl.
	 *
	 * @param repository
	 *            the repository
	 */
	@Autowired
	public PhoneServiceImpl(PhoneRepository repository) {
		this.repository = repository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dms.phonecatalog.service.PhoneService#getAllPhones()
	 */
	@Override
	public List<Phone> getAllPhones() {
		return this.repository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dms.phonecatalog.service.PhoneService#getPhoneById(java.lang.Long)
	 */
	@Override
	public Optional<Phone> getPhoneById(Long id) {
		return this.repository.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dms.phonecatalog.service.PhoneService#getTotalPriceByIds(java.util.List)
	 */
	@Override
	public BigDecimal getTotalPriceByIds(List<Long> ids) {
		List<Phone> phones = this.repository.findAllById(ids);
		if (phones != null && !phones.isEmpty()) {
			List<BigDecimal> prices = phones.stream().map(Phone::getPrice).collect(Collectors.toList());
			return prices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		} else {
			return BigDecimal.valueOf(0.0);
		}

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
