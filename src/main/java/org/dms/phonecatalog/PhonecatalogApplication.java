/*
 * @author: David Martinez Sepulveda
 * @date: 15-sep-2018
 * 
 */
package org.dms.phonecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhonecatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonecatalogApplication.class, args);
	}
}
