package com.crud.rest.service;

import org.springframework.stereotype.Service;

import com.crud.exceptions.product.ProductNotRegisteredException;
import com.crud.rest.dao.ProductDao;
import com.crud.rest.model.Product;

/**
 * This class represents the product service.
 * and executes the product's services.
 * @author Italo Modesto
 */
@Service
public class ProductService {

	private ProductDao productDao;
	
	/**
	 * This is the product service constructor.
	 * @param productDAO: It's the DAO (Data access object) that 
	 *                    manipulates the products in data base.
	 * @return a product service instance.
	 */
	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/**
	 * This method creates a new product and save it in data base.
	 * @param product: It's the product that will be saved.
	 * @return the product saved.
	 * @throws InternalError.
	 */
	public Product create(Product product) {
		try {
			return this.productDao.save(product);
		}catch(Exception e) {
			throw new InternalError("Ocorreu um erro no servidor ao tentar salvar o produto");
		}	
	}
	
	/**
	 * This method gets the product with id equal to the id parameter.
	 * @param id: It's product id.
	 * @return the product with id equal to the id parameter.
	 * @throws ProductNotRegisteredException.
	 */
	public Product findById(long id) {
		Product product = this.productDao.findById(id);
		if(product == null) {
			throw new ProductNotRegisteredException("Produto não cadastrado");
		}
		return product;
	}
	
	/**
	 * This method updates a product.
	 * It use the product id (encapsulated in product) to get the product.
	 * @param product: It's the product with the new data.
	 * @return the product updated.
	 */
	public Product update(Product product) {
		Product oldProduct = findById(product.getId());
		return this.productDao.save(product);
	}
	
	/**
	 * This method deletes a product by its id.
	 * @param id: It's the product id that will be deleted.
	 * @throws InternalError
	 */
	public void delete(long id) {
		try {
			this.productDao.deleteById(id);
		}catch(Exception e) {
			throw new InternalError("Ocorreu um erro no servidor ao tentar deletar o produto");
		}
		
	}
	
}
