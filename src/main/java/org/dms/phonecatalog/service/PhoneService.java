/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.phonecatalog.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.dms.phonecatalog.entity.Phone;

/**
 * The Interface PhoneService.
 */
public interface PhoneService {

	/**
	 * Gets the all phones.
	 *
	 * @return the all phones
	 */
	List<Phone> getAllPhones();

	/**
	 * Gets the phone by id.
	 *
	 * @param id
	 *            the phone id
	 * @return the phone by id
	 */
	Optional<Phone> getPhoneById(Long id);

	/**
	 * Gets the total price by ids.
	 *
	 * @param ids
	 *            the phones ids
	 * @return the total price by ids
	 */
	BigDecimal getTotalPriceByIds(List<Long> ids);

	/**
	 * Validate order using phones ids of the order.
	 *
	 * @param ids
	 *            the phones ids
	 * @return true, if all the phones exists in the database, false if not.
	 */
	boolean validateOrder(List<Long> ids);
}
