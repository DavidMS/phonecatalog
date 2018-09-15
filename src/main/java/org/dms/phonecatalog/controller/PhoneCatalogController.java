/*
 * @author: ${author}
 * @date: 15-sep-2018
 * 
 */
package org.dms.phonecatalog.controller;

import java.math.BigDecimal;
import java.util.List;

import org.dms.phonecatalog.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/phone")
public class PhoneCatalogController {

	private PhoneService phoneService;

	@Autowired
	public PhoneCatalogController(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	@PostMapping(value = "/getTotalPrice")
	@ResponseBody
	public BigDecimal getTotalPrice(@RequestBody List<Long> ids) {
		return this.phoneService.getTotalPriceByIds(ids);
	}

	@PostMapping(value = "/validateOrder")
	@ResponseBody
	public boolean validateOrder(@RequestBody List<Long> ids) {
		return this.phoneService.validateOrder(ids);
	}

	@GetMapping(value = "/test")
	public int test() {
		return 1;
	}
}
