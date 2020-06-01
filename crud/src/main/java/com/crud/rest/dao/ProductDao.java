package com.crud.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.rest.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

	public Product save(Product product);
	
	public Product findById(long id);
}
