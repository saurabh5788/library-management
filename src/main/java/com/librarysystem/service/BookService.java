package com.librarysystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.librarysystem.dto.BookActivityRequestDTO;
import com.librarysystem.dto.BookActivityResponseDTO;
import com.librarysystem.entities.Book;

@Component
public interface BookService {

	ResponseEntity<BookActivityResponseDTO> returnBooks(int userid,
			BookActivityRequestDTO bookActivityRequestDTO);

	List<Book> fetchBooksByAuthorTitleCategory(String author, String title,
			Integer categoryId, int pageNo, int pageSize);

}
