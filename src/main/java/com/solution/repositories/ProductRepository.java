package com.solution.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solution.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
   public Product findByPno(Integer pno);//you can use findBy or getBy
   
   @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max") //JPQL query
   public List<Product> findByPrice(@Param("min") Integer min,@Param("max") Integer max);
   
   
}
