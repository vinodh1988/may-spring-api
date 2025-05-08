package com.solution.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Project {
  @Id
	private Integer pno;
  @Column	
    private String name;
  @Column	
    private String Technology;
  @OneToMany(mappedBy = "project")
    private Set<Member> members;
  
	public Project() {
	}
	public Project(Integer pno, String name, String technology) {
		this.pno = pno;
		this.name = name;
		Technology = technology;
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
	public String getTechnology() {
		return Technology;
	}
	public void setTechnology(String technology) {
		Technology = technology;
	}
	
   	public Set<Member> getMembers() {
		return members;
	}
	
   	public void setMembers(Set<Member> members) {
	  		this.members = members;
   	}
} 
