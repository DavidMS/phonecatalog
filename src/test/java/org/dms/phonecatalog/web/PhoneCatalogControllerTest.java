/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.phonecatalog.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.dms.phonecatalog.service.PhoneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(PhoneCatalogController.class)
public class PhoneCatalogControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	PhoneService phoneService;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void getTotalPrice() throws Exception {
		// return this.phoneService.getTotalPriceByIds(ids);
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);

		when(this.phoneService.getTotalPriceByIds(ids)).thenReturn(BigDecimal.valueOf(200.0));
		this.mockMvc
				.perform(post("/phone/getTotalPrice").contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(ids)))
				.andExpect(status().isOk()).andExpect(content().string("200.0"));
	}

	@Test
	public void validateOrder() throws Exception {
		List<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);

		when(this.phoneService.validateOrder(ids)).thenReturn(true);
		this.mockMvc
				.perform(post("/phone/validateOrder").contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(ids)))
				.andExpect(status().isOk()).andExpect(content().string("true"));
	}
}
