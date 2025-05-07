package com.solution.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.entities.Product;
import com.solution.exceptions.RecordAlreadyExistsException;
import com.solution.exceptions.RecordNotFoundException;
import com.solution.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	
	public Product getProduct(Integer pno) throws RecordNotFoundException {
	
		Product p=productRepository.findByPno(pno);
		if(p==null) {
			throw new RecordNotFoundException();
		}
		return p;
	}
	
	public List<Product> getProducts(Integer min, Integer max) {
	
		return productRepository.findByPrice(min, max);
	}
	
	public void addProduct(Product product) throws RecordAlreadyExistsException {
	   if(productRepository.findByPno(product.getPno()) != null) {
		   throw new RecordAlreadyExistsException();
	   }
		productRepository.save(product);
	}
	
	public Product updateProduct(Product product) throws RecordNotFoundException {
		Product p=productRepository.findByPno(product.getPno());
		if(p==null) {
			throw new RecordNotFoundException();
		}
		p.setName(product.getName()!=null?product.getName():p.getName());
		p.setDescription(product.getDescription()!=null?product.getDescription():p.getDescription());
		p.setPrice(product.getPrice()!=null?product.getPrice():p.getPrice());
		productRepository.save(p);
		return p;
	}
	
	public void deleteProduct(Integer pno) throws RecordNotFoundException {
		Product p=productRepository.findByPno(pno);
		if(p==null) {
			throw new RecordNotFoundException();
		}
		productRepository.delete(p);
	}
	
	
}

