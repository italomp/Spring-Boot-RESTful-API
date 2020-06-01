package com.crud.rest.service;

import org.springframework.stereotype.Service;

import com.crud.exceptions.product.ProductNotRegisteredException;
import com.crud.rest.dao.ProductDao;
import com.crud.rest.model.Product;

@Service
public class ProductService {

	private ProductDao productDao;
	
	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public Product create(Product product) {
		try {
			return this.productDao.save(product);
		}catch(Exception e) {
			throw new InternalError("Ocorreu um erro no servidor ao tentar salvar o produto");
		}	
	}
	
	public Product findById(long id) {
		Product product = this.productDao.findById(id);
		if(product == null) {
			throw new ProductNotRegisteredException("Produto não cadastrado");
		}
		return product;
	}
	
	public Product update(Product product) {
		Product oldProduct = findById(product.getId());
		return this.productDao.save(product);
	}
	
	public void delete(long id) {
		try {
			this.productDao.deleteById(id);
		}catch(Exception e) {
			throw new InternalError("Ocorreu um erro no servidor ao tentar deletar o produto");
		}
		
	}
	
}
