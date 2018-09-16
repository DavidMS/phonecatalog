/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.phonecatalog.web;

import java.math.BigDecimal;
import java.util.List;

import org.dms.phonecatalog.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PhoneCatalogController.
 */
@RestController
@RequestMapping(value = "/phone")
public class PhoneCatalogController {

	private PhoneService phoneService;

	/**
	 * Instantiates a new phone catalog controller.
	 *
	 * @param phoneService
	 *            the phone service
	 */
	@Autowired
	public PhoneCatalogController(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	/**
	 * Gets the total price of an order using its phones ids.
	 *
	 * @param ids
	 *            the phones ids
	 * @return the total price
	 */
	@PostMapping(value = "/getTotalPrice")
	@ResponseBody
	public BigDecimal getTotalPrice(@RequestBody List<Long> ids) {
		return this.phoneService.getTotalPriceByIds(ids);
	}

	/**
	 * Validate order.
	 *
	 * @param ids
	 *            the phones ids
	 * @return true, if all the phones ids exists in the database, false if not.
	 */
	@PostMapping(value = "/validateOrder")
	@ResponseBody
	public boolean validateOrder(@RequestBody List<Long> ids) {
		return this.phoneService.validateOrder(ids);
	}
}
