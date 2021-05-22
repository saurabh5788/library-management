package com.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.librarysystem.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	boolean updateBookStatus(String bookStatus, Integer id);
}
