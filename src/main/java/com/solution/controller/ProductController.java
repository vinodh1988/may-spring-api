package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Product;
import com.solution.exceptions.RecordAlreadyExistsException;
import com.solution.exceptions.RecordNotFoundException;
import com.solution.services.ProductService;
import com.solution.states.MessageFormat;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	/*@GetMapping("")
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(productService.getProducts());
	}*/
	
	@GetMapping("")
	public ResponseEntity<List<Product>> getProducts
	(@RequestParam(required  = false) Integer min,@RequestParam(required = false) Integer max) {
		if(min ==null && max == null) {
			return ResponseEntity.ok(productService.getProducts());
		}
		else if(min ==null && max !=null)
			min=0;
		else if(min !=null && max ==null)
			max=Integer.MAX_VALUE;
		
		List<Product> products=productService.getProducts(min, max);
		return new ResponseEntity<>(products, HttpStatus.OK); //OK
	}
	
	
	@GetMapping("/{pno}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer pno) throws RecordNotFoundException {
		Product p=productService.getProduct(pno);
	
		return new ResponseEntity<>(p, HttpStatus.OK); //OK
	}


	@PostMapping("")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) throws RecordAlreadyExistsException {
	
		productService.addProduct(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED); //CREATED
	 
}
    @RequestMapping(value="" , method = {RequestMethod.PUT,RequestMethod.PATCH})
    public ResponseEntity<Object> updateProduct
    (@RequestBody Product product) throws RecordNotFoundException {
    	if(product.getPno() == null) {
			return new ResponseEntity<>("Product number is required", HttpStatus.BAD_REQUEST);
		}
		Product updated =productService.updateProduct(product);
		return new ResponseEntity<>(updated, HttpStatus.OK); //OK
  }
    
    @DeleteMapping("/{pno}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer pno) throws RecordNotFoundException {
		productService.deleteProduct(pno);
		return new ResponseEntity<>(new MessageFormat("Product deleted",true), HttpStatus.OK); //OK
	}
    
/*
@RequestMapping(value="/alternate" , method = {RequestMethod.PUT,RequestMethod.PATCH})
public ResponseEntity<Object> updateProduct2
(@RequestBody Product product) throws RecordNotFoundException {
	if(product.getPno() == null) {
		return new ResponseEntity<>("Product number is required", HttpStatus.BAD_REQUEST);
	}
	Product updated =productService.updateProduct(product);
	return new ResponseEntity<>(new MessageFormat("Product updated"), HttpStatus.OK); //OK
}
 */

}
