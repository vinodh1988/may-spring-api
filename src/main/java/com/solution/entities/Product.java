package com.solution.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
	@Id
   	private Integer pno;
	@Column
   	private String name;
	@Column
	private String description;
	@Column
	private Double price;
	
	public Product() {
	}
	
	public Product(Integer pno, String name, String description, Double price) {
		this.pno = pno;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
    
    
}
