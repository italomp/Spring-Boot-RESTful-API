package com.crud.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.rest.model.Product;

/**
 * This interface make the connection with the data 
 * base to manipulate products. 
 * @author Italo Modesto
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

	/**
	 * This is a JpaRepository API method to save an 
	 * object (in this case, a product) in the data base.
	 * @param product: It's the product that will be save.
	 * @return the saved product.
	 */
	public Product save(Product product);
	
	/**
	 * This is a JpaRepository API method to get a product by its id.
	 * @param id: It's the product id i want get.
	 * @return the product that owns this id.
	 */
	public Product findById(long id);
}
