/*
 * @author: ${author}
 * @date: 15-sep-2018
 * 
 */
package org.dms.phonecatalog.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.dms.phonecatalog.entity.Phone;

public interface PhoneService {

	List<Phone> getAllPhones();

	Optional<Phone> getPhoneById(Long id);

	BigDecimal getTotalPriceByIds(List<Long> ids);

	boolean validateOrder(List<Long> ids);
}
