package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Product;
import com.solution.exceptions.RecordAlreadyExistsException;
import com.solution.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(productService.getProducts());
	}

	@PostMapping("")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) throws RecordAlreadyExistsException {
	
		productService.addProduct(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED); //CREATED
	 
}}
