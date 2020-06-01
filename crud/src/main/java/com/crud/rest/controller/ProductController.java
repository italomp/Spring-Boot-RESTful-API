package com.crud.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.model.Product;
import com.crud.rest.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/")
	public ResponseEntity create(@RequestBody Product product) {
		Product prodSaved = this.productService.create(product);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable long id){
		Product product = this.productService.findById(id);
		return new ResponseEntity(product, HttpStatus.OK);
	}
	
	//update
	@PutMapping("/")
	public ResponseEntity update(@RequestBody Product product) {
		this.productService.update(product);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable long id) {
		this.productService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
