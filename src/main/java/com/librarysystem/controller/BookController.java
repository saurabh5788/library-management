package com.librarysystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.dto.BooksResponseDTO;
import com.librarysystem.dto.ErrorDTO;
import com.librarysystem.entities.Book;
import com.librarysystem.service.BookService;
import com.librarysystem.service.UserService;

@RestController
@RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE)
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/{userid}/books")
	public ResponseEntity<?> fetchBooksByUser(
			@PathVariable("userid") Integer userId,
			@RequestParam("author") Optional<String> authorParam,
			@RequestParam("title") Optional<String> titleParam,
			@RequestParam("category") Optional<Integer> categoryIdParam/*,
			@RequestParam String pageNo*/) {
		
		if (userId == null || userId < 1 || !userService.isUserPresent(userId)) {
			return ResponseEntity.badRequest().body(
					new ErrorDTO(environment
							.getProperty("message.book.search.invaliduserid")));
		}
			
		String author = null;
		String title = null;
		Integer categoryId = null;

		boolean noCriteria = true;

		if (authorParam.isPresent()) {
			author = authorParam.get();
			noCriteria = false;
		}
		if (titleParam.isPresent()) {
			title = titleParam.get();
			noCriteria = false;
		}
		if (categoryIdParam.isPresent()) {
			categoryId = categoryIdParam.get();
			noCriteria = false;
		}

		if (noCriteria) {
			return ResponseEntity.badRequest().body(
					new ErrorDTO(environment
							.getProperty("message.book.search.nocriteria")));
		}
		List<Book> bookList = bookService.fetchBooksByAuthorTitleCategory(
				author, title, categoryId);
		if (!CollectionUtils.isEmpty(bookList)) {
			BooksResponseDTO booksResponseDTO = new BooksResponseDTO(bookList);
			return ResponseEntity.ok(booksResponseDTO);
		}
		return ResponseEntity.ok(new ErrorDTO(environment
				.getProperty("message.book.search.notbookpresent")));
		
	}
	
	
	@PostMapping("/users/{userid}/books")
	public ResponseEntity<?> returnBooks(){
		
		return bookService.returnBooks();
	}
}
