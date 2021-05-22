package com.librarysystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.librarysystem.entities.Book;

@Component
public interface BookService {

	
	ResponseEntity<?> returnBooks();

	List<Book> fetchBooksByAuthorTitleCategory(String author, String title,
			Integer categoryId);
	
}
