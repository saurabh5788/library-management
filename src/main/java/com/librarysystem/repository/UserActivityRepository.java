package com.librarysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.entities.Book;
import com.librarysystem.entities.UserActivityLog;

public interface UserActivityRepository extends JpaRepository<UserActivityLog, Long> {
	
	
}
