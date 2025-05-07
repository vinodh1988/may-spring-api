package com.solution.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.entities.Product;
import com.solution.exceptions.RecordAlreadyExistsException;
import com.solution.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public void addProduct(Product product) throws RecordAlreadyExistsException {
	   if(productRepository.findByPno(product.getPno()) != null) {
		   throw new RecordAlreadyExistsException();
	   }
		productRepository.save(product);
	}
}

