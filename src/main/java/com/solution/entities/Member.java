package com.solution.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table

public class Member {
   @Id
	private Integer mno;
   @Column
    private String name;
   @Column	
    private String role;
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "pno")
   @JsonIgnore
    private Project project;
   
	public Member() {
	}
	public Member(Integer mno, String name, String role) {
		this.mno = mno;
		this.name = name;
		this.role = role;
	}
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
}
