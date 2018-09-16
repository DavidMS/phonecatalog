/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.phonecatalog.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class Phone.
 */
@Entity
public class Phone {

	/**
	 * The id
	 */
	@Id
	private Long id;
	/**
	 * The phone name
	 */
	private String name;
	/**
	 * The phone description
	 */
	private String description;
	/**
	 * The phone price
	 */
	private BigDecimal price;
	/**
	 * The phone image ref
	 */
	private String img;

	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return this.img;
	}

	/**
	 * @param img
	 *            the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

}
