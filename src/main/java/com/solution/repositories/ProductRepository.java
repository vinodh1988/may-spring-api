package com.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solution.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
