package com.librarysystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.dto.BooksResponseDTO;
import com.librarysystem.entities.Book;
import com.librarysystem.service.BookService;

@RestController
@RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE)
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/{userid}/books")
	public ResponseEntity<?> fetchBooksByUser(
			@PathVariable("userid") String userId,
			@RequestParam Optional<String> authorParam,
			@RequestParam Optional<String> titleParam,
			@RequestParam Optional<Integer> categoryIdParam/*,
			@RequestParam String pageNo*/) {
		
			String author = null;
			String title = null;
			Integer categoryId = null;
			
			if(authorParam.isPresent()){
				author = authorParam.get();
			}
			if(titleParam.isPresent()){
				title = titleParam.get();
			}
			if(categoryIdParam.isPresent()){
				categoryId = categoryIdParam.get();
			}
			List<Book> bookList = bookService.fetchBooksByAuthorTitleCategory(author, title, categoryId);
			BooksResponseDTO booksResponseDTO = new BooksResponseDTO(bookList);
			
			return ResponseEntity.ok(booksResponseDTO);
		
	}
	
	
	@PostMapping("/users/{userid}/books")
	public ResponseEntity<?> returnBooks(){
		
		return bookService.returnBooks();
	}
}
