package com.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solution.entities.User;




public interface UserRepository extends JpaRepository<User, String> {
  public User findUserByUsername(String username);
}
