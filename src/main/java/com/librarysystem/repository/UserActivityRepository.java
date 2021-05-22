package com.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarysystem.entities.UserActivityLog;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivityLog, Integer> {
		
}
