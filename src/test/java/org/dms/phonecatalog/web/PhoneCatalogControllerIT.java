/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.phonecatalog.web;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class PhoneCatalogControllerIT. Eureka Server must be up and running in
 * order for this tests to be executed.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhoneCatalogControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void validateOrderIT() throws Exception {
		List<Long> phonesIds = new ArrayList<>();
		phonesIds.add(1L);
		ResponseEntity<Boolean> responseEntity = this.restTemplate.postForEntity("/phone/validateOrder", phonesIds,
				Boolean.class);
		boolean response = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(true, responseEntity.getBody()); // We should assert this only if we have a mocked database.
	}

	@Test
	public void getTotalPriceIT() throws Exception {
		List<Long> phonesIds = new ArrayList<>();
		phonesIds.add(1L);
		ResponseEntity<BigDecimal> responseEntity = this.restTemplate.postForEntity("/phone/getTotalPrice", phonesIds,
				BigDecimal.class);
		BigDecimal response = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(BigDecimal.valueOf(1699.99), responseEntity.getBody()); // We should assert this only if we have a
																				// mocked
																				// database using profiles.
	}
}
