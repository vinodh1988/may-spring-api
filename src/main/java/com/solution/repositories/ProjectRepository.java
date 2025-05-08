package com.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solution.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
  public Project findByPno(Integer pno); // you can use findBy or getBy
}
