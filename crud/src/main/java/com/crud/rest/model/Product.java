package com.crud.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a system's product
 * @author Italo Modesto
 */
@Entity
public class Product {
	/**
	 * The id attribute is the class identifier and
	 * it's generated automatically by JPA.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private float price;
	
	/**
	 * This is an empty constructor that JPA requires us to use in models.
	 * @return a new instance of the product object.
	 */
	public Product() {
		
	}
	
	/**
	 * This is the product constructor used to instantiate new product objects.
	 * @param name: It's the product name.
	 * @param description: It's the product description.
	 * @param price: It's the product price.
	 * @return a new instance of the product object.
	 */
	public Product(String name, String description, float price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/**
	 * This method return the product id.
	 * @return the product id
	 */
	public long getId() {
		return id;
	}

	/**
	 * This method sets the product id.
	 * @param id: It's the new id value.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * This method return the product name.
	 * @return the product name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the product name.
	 * @param name:It's the new name value.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method return the product description.
	 * @return the product description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets the product description.
	 * @param description: It's the new description value.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method return the product price.
	 * @return the product price.
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * This method sets the product price.
	 * @param price: It's the new price value.
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
