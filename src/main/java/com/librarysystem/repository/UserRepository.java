package com.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
}
